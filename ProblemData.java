
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Ian
 */
public class ProblemData {
    Random generator2 = new Random();
    private BinaryNumber data = new BinaryNumber();
    private int data_len;
    private BinaryNumber pattern = new BinaryNumber();
    private int pattern_len;

    public ProblemData() {
	// seed the random number generator with the time
	Date time = new Date();
	long all_time = time.getTime();
	generator2.setSeed(all_time);
    }

    public BinaryNumber getData() {
	return data;
    }

    public int getData_len() {
	return data_len;
    }

    public BinaryNumber getPattern() {
	return pattern;
    }

    public int getPattern_len() {
	return pattern_len;
    }

    public void generateNewProblem() {
	int c;
	/** a counter variable **/
	int rand;
	int bit_len; // used to hold the length of the binary number.
	boolean bit_size_OK = false; // used to record that the binary number is big enough.

	// clear both numbers
	getData().clear_number();
	getPattern().clear_number();

	// for data, keep picking a length until its big enough.
	bit_len = 0;
	while (bit_len < 2 || bit_len >= getData().MAX_BITS) {
	    bit_len = generator2.nextInt(getData().MAX_BITS);
	}
	data_len = bit_len;

	// Generate random binary number for data
	data.bits.set(0); // Set the first bit to True
	for (c = 1; c < bit_len; c++) { // now set remaining bits
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

	// Generate random binary number for pattern
	pattern.bits.set(0); // Set the first bit to True
	for (c = 1; c < bit_len; c++) {// now set remaining bits
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
