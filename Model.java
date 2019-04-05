
/*
 * Class Model by Duncan Baxter 2019 (s3737140):
 * Implements Swing Table-style access to a JavaFX TableView<String>
 * 
 * Constructor instantiates a 2D backing array of String variables, an ObservableList<String[]> as a wrapper, and 
 * a TableView<String[]> to display the ObservableList.  The ObservableList can be used to instantiate the TableView, 
 * and as a source of Listener events.
 * 
 * All of these variables are private.  This helps the class methods automatically keep the array, ObservableList and 
 * TableView consistent, and prevents a lot of really weird bugs!
 * 
 * Accessor and mutator methods are provided for the data: the accessor method (getValueAt(row, column)) looks at
 * the array, and the mutator method (setValueAt(String, row, column)) updates the array and the ObservableList.
 * There are also accessor methods for the number of rows, and columns, in the array.
 * 
 * Additional functionality:
 * updateObList() method - useful if you make a lot of changes to the array outside the class methods.
 * updateTableView() method - refreshes the TableView from the array. 
 * clearValues() method - sets every element of the array, ObservableList and TableView to the empty string "".
 * clearValues(String) method - sets every element of these three variables to the String that was passed in as a 
 * 	parameter (which can be any String, including an empty string "").
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class Model {
    private String[][] data; // Underlying 2D String array used as the data model for the TableView
    private ObservableList<String[]> ols; // Observable list of String arrays linking data model to TableView
    private TableView<String[]> tv; // TableView of String arrays used for display

    // Constructor for a Model with the (specified) number of rows and columns
    public Model(int rows, int columns) {
	data = new String[rows][columns];
	ols = FXCollections.observableArrayList(data);
	tv = new TableView<String[]>();

	// Initialise the columns in the TableView
	for (int i = 0; i < data[0].length; i++) {
	    TableColumn<String[], String> tc = new TableColumn<>(String.valueOf(i));
	    final int colNo = i;

	    // Set a CellValueFactory callback method so we can see the values in the individual cells
	    tc.setCellValueFactory(new Callback<CellDataFeatures<String[], String>, ObservableValue<String>>() {
		@Override
		public ObservableValue<String> call(CellDataFeatures<String[], String> p) {
		    return new SimpleStringProperty((p.getValue()[colNo]));
		}
	    });

	    // Take the available real estate, subtract 21 pixels for borders, etc and divide amongst the columns
	    tc.prefWidthProperty().bind(tv.widthProperty().subtract(30.0d).divide(columns));
	    tv.getColumns().add(tc);
	}

	// Link the ObservableList of String arrays (ie. columns) to the TableView
	tv.setItems(ols);
    }

    public ObservableList<String[]> getObList() {
	return ols;
    };

    public TableView<String[]> getTableView() {
	return tv;
    };

    public void updateObList() {
	ols = FXCollections.observableArrayList(data);
	tv.setItems(ols);
    }

    public void updateTableView() {
	ols = FXCollections.observableArrayList(data);
	tv.setItems(ols);
	tv.refresh();
    }

    public int getRowCount() {
	return this.data.length;
    }

    public int getColCount() {
	return this.data[0].length;
    }

    public String getValueAt(int row, int column) {
	return data[row][column];
    }

    public void setValueAt(String str, int row, int column) {
	this.data[row][column] = str;
	ols.set(row, data[row]);
    }

    public int findEmpty(int row) {
	int rInt = 0;
	while ((rInt < this.data[row].length) && (!data[row][rInt].isEmpty())) {
	    rInt++;
	}
	return rInt;
    }

    public void clearValues() {
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[0].length; j++) {
		data[i][j] = "";
	    }
	}
	updateObList();
	tv.setItems(ols);
    }

    public void clearValues(String str) {
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[0].length; j++) {
		data[i][j] = str;
	    }
	}
	updateObList();
	tv.setItems(ols);
    }
}
