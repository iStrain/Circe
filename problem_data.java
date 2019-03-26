/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CRC;

import java.util.Random;
import java.util.Date;

/**
 *
 * @author Ian
 */
public class problem_data {

   Random generator2 = new Random();

   private binary_number data = new binary_number();
   private int data_len;
   private binary_number pattern = new binary_number();
   private int pattern_len;

   public int getData_len() {
      return data_len;
   }

   public int getPattern_len() {
      return pattern_len;
   }

   public binary_number getData() {
      return data;
   }

   public binary_number getPattern() {
      return pattern;
   }


   public problem_data() {
      // seed the random number generator with the time
      Date time = new Date();
      long all_time;
      all_time = time.getTime();
      generator2.setSeed(all_time);
   }

   public void Gen_New_Prob() {
      int c;
      /** a counter variable  **/
      int rand;
      int bit_len; // used to hold the length of the binary number.
      boolean bit_size_OK = false; // used to record that the binary number is big enough.


      //clear both numbers
      getData().clear_number();
      getPattern().clear_number();

      // for data, keep picking a length until its big enough.
      bit_len = 0;
      while (bit_len < 2 || bit_len >= getData().MAX_BITS) {
         bit_len = generator2.nextInt(getData().MAX_BITS);
      }
      data_len = bit_len;

      //Generate random binary number for data
      data.bits.set(0);  //Set the first bit to True
      for (c = 1; c < bit_len; c++) {  //now set remaining bits
         rand = generator2.nextInt();
         if (rand < 0) {
            data.bits.clear(c);
         } else {
            data.bits.set(c);
         }
         data.len = bit_len;
      }


      // for pattern, keep picking a length until its big enough.
      bit_len = 0;
      while (bit_len < 2 || bit_len >= getPattern().MAX_BITS) {
         bit_len = generator2.nextInt(getData().MAX_BITS);
      }
      pattern_len = bit_len;

      //Generate random binary number for pattern
      pattern.bits.set(0);  //Set the first bit to True
      for (c = 1; c < bit_len; c++) {//now set remaining bits
         rand = generator2.nextInt();
         if (rand < 0) {
            pattern.bits.clear(c);
         } else {
            pattern.bits.set(c);
         }
         pattern.len = bit_len;

      }
   }
}
