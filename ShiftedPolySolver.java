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

	int pos_count = B2Model.findEmpty(0);
	int Max_X_Power = pos_count - 1;	// Wouldn't "Max Power" be a great name for a super-hero?
	int current_pos;
	int row_ptr;
	int index;
	boolean lineStartsWithZero = false;
	boolean line_started;
	String[] convert = { "\u2070", "\u00B9", "\u00B2", "\u00B3", "\u2074", 
			     "\u2075", "\u2076", "\u2077", "\u2078", "\u2079" };
	String tab_str = "\t\t\t\t\t\t\t\t\t\t" + "\t\t\t\t\t\t\t\t\t\t" + "\t\t\t\t\t";
	String indent_string = "";
	String current_poly_str = "";

	SPModel.clearValues();

	row_ptr = 0;
	do { // do conversions
	     // convert a line
	    current_pos = 0;
	    current_poly_str = tab_str.substring(0, row_ptr >> 1);
	    indent_string = "";
	    line_started = false;
	    while (current_pos < pos_count) {
		if (B2Model.getValueAt(row_ptr, current_pos) == "1") {
		    if (line_started) {
			current_poly_str = current_poly_str + "  +\t";
		    } else {
			line_started = true;
		    }

		    // With a bonus new converter - fractionally shorter, quite a bit faster!
		    index = Max_X_Power - current_pos;
		    switch (index) {
		    case 0:
			current_poly_str += "1";
			break;
		    case 1:
			current_poly_str += "X ";
			break;
		    default:
			current_poly_str += "X";
			if (index < 10) {
			    current_poly_str += convert[index];
			} else {
			    current_poly_str += (convert[index / 10] + convert[index % 10]);
			}
		    }
		} else {
		    if ((B2Model.getValueAt(row_ptr, current_pos) == "0") && !line_started) {
			lineStartsWithZero = true;
		    }
		}
		current_pos++;
	    }
	    if (!lineStartsWithZero) {
		SPModel.setValueAt((indent_string + current_poly_str), row_ptr, 0);
	    } else {
		current_poly_str = tab_str.substring(0, row_ptr >> 1);
		current_poly_str += "0";
		SPModel.setValueAt((current_poly_str), row_ptr, 0);
	    }
	    row_ptr++;
	} while (line_started);
	SPModel.updateTableView();
    }
}
