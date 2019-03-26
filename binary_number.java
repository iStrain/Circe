/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CRC;

   import java.util.BitSet;

/**
 *
 * @author Ian
 */
public class binary_number {

   public final int MAXLEN = 25;
   //All binary numbers are held in an aray of this length
   public final int MAX_BITS = 10;

   BitSet bits = new BitSet(MAXLEN);
   // the array for the pattern bits.
   int len;

   public void clear_number() {
      
      bits.clear();

   }
}
