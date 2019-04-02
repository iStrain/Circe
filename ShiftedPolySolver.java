/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package CRC;

/**
 *
 * @author Ian
 */
public class ShiftedPolySolver {

   public void solveShiftedPoly(Model B2Model, Model SPModel) {

      // Start on first line of B2Model and convert
      // each line to polynomial format.
      // Stop when line is blank.

      int Max_X_Power;
      int max_line_length;
      int pos_count;
      int current_pos;
      int row_ptr;
      int indent_count;
      int index;
      int index_pos;
      int index_len;
      int digit;
      int last_line_len;
      @SuppressWarnings("unused")
    boolean line_not_blank = true;
      boolean lineStartsWithZero = false;
      boolean line_started;
      String indent_string = "";
      String current_poly_str = "";
      String index_str = "";
      String digit_str = "";

      row_ptr = 0;
      do {
         SPModel.setValueAt(current_poly_str, row_ptr, 0);
         row_ptr++;
      } while (row_ptr < SPModel.getRowCount());


      // scan first line to establish Max_X power
      max_line_length = B2Model.getColCount();
      Max_X_Power = 0;
      pos_count = 0;
      while ((Max_X_Power == 0) && (pos_count < max_line_length)) {
         if (B2Model.getValueAt(0, pos_count) != "") {
            pos_count++;
         } else {
            Max_X_Power = pos_count - 1;
         }
      }

      row_ptr = 0;
      do { // do conversions
         // convert a line
         current_pos = 0;
         last_line_len = current_poly_str.length();
         current_poly_str = "";
         for (indent_count = 0; indent_count < (row_ptr / 2); indent_count++) {
            current_poly_str = current_poly_str + "         ";
         }
         indent_string = "";
         line_started = false;
         while (current_pos < pos_count) {
            if (B2Model.getValueAt(row_ptr, current_pos) == "1") {

               if (line_started) {
                  current_poly_str = current_poly_str + " + ";
               } else {
                  line_started = true;
               }
               //insert index
               index = Max_X_Power - current_pos;
               index_str = Integer.toString(index);
               index_len = index_str.length();
               index_pos = 0;
               while (index_pos < index_len) {
                  digit_str = index_str.substring(index_pos, (index_pos + 1));
                  digit = Integer.valueOf(digit_str);
                  switch (digit) {

                     case 0:
                        if (index_len == 1) {
                           current_poly_str = current_poly_str + "1";
                        } else {
                           if (index_pos == 0) {
                              current_poly_str = current_poly_str + "X\u2070";
                           } else {
                              current_poly_str = current_poly_str + "\u2070";
                           }
                        }
                        break;
                     case 1:
                        if (index_len == 1) {
                           current_poly_str = current_poly_str + "X";
                        } else {
                           if (index_pos == 0) {
                              current_poly_str = current_poly_str + "X\u00B9";
                           } else {
                              current_poly_str = current_poly_str + "\u00B9";
                           }
                        }
                        break;
                     case 2:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u00B2";
                        } else {
                           current_poly_str = current_poly_str + "\u00B2";
                        }
                        break;
                     case 3:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u00B3";
                        } else {
                           current_poly_str = current_poly_str + "\u00B3";
                        }
                        break;
                     case 4:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u2074";
                        } else {
                           current_poly_str = current_poly_str + "\u2074";
                        }
                        break;
                     case 5:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u2075";
                        } else {
                           current_poly_str = current_poly_str + "\u2075";
                        }
                        break;
                     case 6:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u2076";
                        } else {
                           current_poly_str = current_poly_str + "\u2076";
                        }
                        break;
                     case 7:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u2077";
                        } else {
                           current_poly_str = current_poly_str + "\u2077";
                        }
                        break;
                     case 8:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u2078";
                        } else {
                           current_poly_str = current_poly_str + "\u2078";
                        }
                        break;
                     case 9:
                        if (index_pos == 0) {
                           current_poly_str = current_poly_str + "X\u2079";
                        } else {
                           current_poly_str = current_poly_str + "\u2079";
                        }
                  }
                  index_pos++;
               }
            }
            else {
               if ((B2Model.getValueAt(row_ptr, current_pos) == "0") && !line_started){
                  lineStartsWithZero = true;
               }
            }
            current_pos++;
         }
         if (!lineStartsWithZero) {
            SPModel.setValueAt((indent_string + current_poly_str), row_ptr, 0);
         } else {
            current_poly_str = "";
            for (pos_count = 0; (pos_count < last_line_len); pos_count++) {
               current_poly_str += " ";
            }
            current_poly_str += "0";
            SPModel.setValueAt((current_poly_str), row_ptr, 0);
         }
         row_ptr++;
      } while (line_started);
      SPModel.updateTableView();
   }
}
