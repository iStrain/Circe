
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class Base2Solver {

    public Base2Solver() {

    }

    public void solveBase2(ProblemData prob, Model model) {

	int col_counter;
	int col_pos;
	int row_pos;
	int number_bits;
	int data_padding = prob.getPattern_len() - 1;
	int current_answer_len;
	int padding_bits_left;
	int new_result_len;
	boolean finished, first_bin_one_detected;

	model.clearValues();

	// first row
	number_bits = prob.getData_len();
	row_pos = 0;
	for (col_counter = 0; col_counter < number_bits; col_counter++) {
	    if (prob.getData().bits.get(col_counter)) {
		model.setValueAt("1", row_pos, col_counter);
	    } else {
		model.setValueAt("0", row_pos, col_counter);
	    }
	}

	// add padding zeros
	padding_bits_left = data_padding;
	do {
	    model.setValueAt("0", row_pos, col_counter);
	    col_counter++;
	    padding_bits_left--;

	} while (padding_bits_left > 0);

	// second row
	number_bits = prob.getPattern_len();
	row_pos = 1;
	for (col_counter = 0; col_counter < number_bits; col_counter++) {
	    if (prob.getPattern().bits.get(col_counter)) {
		model.setValueAt("1", row_pos, col_counter);
	    } else {
		model.setValueAt("0", row_pos, col_counter);
	    }
	}

	// start loop to finish solution
	col_pos = 0;
	row_pos = 2;
	padding_bits_left = prob.getData_len() - 1;
	finished = false;

	// Generate a new result line
	do {
	    number_bits = prob.getPattern_len();
	    first_bin_one_detected = false;
	    new_result_len = 0;
	    do {
		// do boolean on each bit here
		if ((model.getValueAt((row_pos - 1), col_pos) != (model.getValueAt((row_pos - 2), col_pos)))) {
		    model.setValueAt("1", row_pos, col_pos);
		    first_bin_one_detected = true;
		} else {
		    if (first_bin_one_detected) {
			model.setValueAt("0", row_pos, col_pos);
		    }
		}
		if (first_bin_one_detected) {
		    new_result_len++;
		}
		number_bits--;
		col_pos++;
	    } while (number_bits > 0);

	    // find the beginning of the next data word. It's the first
	    // binary one.
	    if (!first_bin_one_detected) {
		while ((!first_bin_one_detected) && (padding_bits_left > 0)) {
		    if (model.getValueAt(0, col_pos) == "1") {
			first_bin_one_detected = true;
			new_result_len++;
			model.setValueAt((model.getValueAt(0, col_pos)), row_pos, col_pos);
		    }
		    padding_bits_left--;
		    col_pos++;
		}
	    }

	    // if bit one has been detected we have to check to see if
	    // we can make another line of data or quit.
	    if (first_bin_one_detected) {
		if ((new_result_len + padding_bits_left) <= data_padding) {
		    finished = true;
		    // copy any remaining data bits down
		    if (padding_bits_left != 0) {
			while (padding_bits_left > 0) {
			    model.setValueAt((model.getValueAt(0, col_pos)), row_pos, col_pos);
			    padding_bits_left--;
			    col_pos++;
			}
		    }
		} else { // copy more bits down
		    while (new_result_len <= data_padding) {
			model.setValueAt((model.getValueAt(0, col_pos)), row_pos, col_pos);
			new_result_len++;
			padding_bits_left--;
			col_pos++;
		    }
		}
	    } else {
		// copy any remaining data bits down
		finished = true;
		if (padding_bits_left > 0) {
		    while (padding_bits_left > 0) {
			model.setValueAt((model.getValueAt(0, col_pos)), row_pos, col_pos);
			padding_bits_left--;
			col_pos++;
		    }
		} else {
		    model.setValueAt("0", row_pos, --col_pos);
		}
	    }

	    // set up for next loop

	    if (!finished) {
		// adjust points and counters
		col_pos -= new_result_len;
		row_pos++;

		// copy pattern to new line
		number_bits = prob.getPattern_len();
		for (col_counter = 0; col_counter < number_bits; col_counter++) {
		    if (prob.getPattern().bits.get(col_counter)) {
			model.setValueAt("1", row_pos, (col_counter + col_pos));
		    } else {
			model.setValueAt("0", row_pos, (col_counter + col_pos));
		    }
		}
		row_pos++;
	    } else {

	    }
	} while (!finished);
	model.tv.refresh();
    }
}
