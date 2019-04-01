
/*
 * CIRCE - A JavaFX TEACHING TOOL BY:
 * -	Ian Baker (instructor)
 * -	Duncan Baxter (s3737140)
 */

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * Top-level Class for the tool
 */

public class Circe extends Application {
    Stage stage;
    TabPane root;
    TextField tfData;
    TextField tfPattern;
    Button btNew;

    public ProblemData problemData = new ProblemData();
    public Model B2Model = new Model(40, 25);
    public Base2Solver B2Solver = new Base2Solver();
    public Model SPModel = new Model(40, 1);
    public ShiftedPolySolver SPSolver = new ShiftedPolySolver();

    /*
     * The usual "main" method - this code is only executed on platforms that lack
     * full JavaFX support.
     */
    public static void main(String[] args) {
	Application.launch(args);
    }

    /*
     * JavaFX Application thread automatically calls start() method. The parameter
     * Stage stage is our top-level window, then Scene scene, TabPane root, and all
     * the other Nodes. This method is quite short: it just creates the GUI.
     * 
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) {
	this.stage = stage;
	// Set the Style for the primary Stage
	stage.initStyle(StageStyle.DECORATED);
	// Set the title of the primary Stage
	stage.setTitle("Circe");
	// Create the TabPane, 3 Tabs and their contents
	createTabPane();
	// Create a Scene based on the TabPane with no background fill
	Scene scene = new Scene(root, null);
	// Add the Scene to the primary Stage and resize
	stage.setScene(scene);
	stage.show();
	btNew.requestFocus();
    }

    /*
     * createTabPane() method: creates TabPane, 3 Tabs and their contents.
     */
    private boolean createTabPane() {
	// Create a TabPane to hold the 3 Tabs
	root = new TabPane();

	// Load the JavaFX CSS StyleSheet
	root.getStylesheets().add("file:src/Circe.css");

	// Create an Image from our file
	ImageView iv = new ImageView(
		"https://upload.wikimedia.org/wikipedia/commons/1/1d/J._W._Waterhouse_-_Circe_Invidiosa_-_Google_Art_Project.jpg");
	iv.setPreserveRatio(true);
	iv.setFitWidth(100);

	// Create the 2 x Labels (one for each Text Field)
	Label lbData = new Label("Data");
	Label lbPattern = new Label("Pattern");

	// Create the "Circe" logo
	Text tx = new Text("CIRCE");
	tx.getStyleClass().add("logo-text");

	// Create the 2 x Text Fields (one-liners)
	tfData = new TextField();
	tfData.setEditable(false);
	tfPattern = new TextField();
	tfPattern.setEditable(false);

	// Create the 2 x Buttons
	btNew = new Button("New CRC problem");
	btNew.setTooltip(new Tooltip("Press this button to generate new Data and Pattern strings"));
	btNew.setOnMousePressed(me -> new Thread(new Tone(262, 100)).start());
	btNew.setOnAction(ae -> {
	    updateProblemDisplay();
	    System.out.println("Process New CRC problem");
	});

	Button btExit = new Button("Exit");
	btExit.setOnMousePressed(me -> new Thread(new Tone(262, 100)).start());
	btExit.setOnAction(ae -> {
	    System.out.println("Process Exit");
	    System.exit(0);
	});

	// Create a GridPane to hold the ImageView, Labels, TextFields and Buttons
	GridPane gp = new GridPane();
	gp.getStyleClass().add("grid-pane");

	// Set Grid-lines-visible during debug
	// gp.setGridLinesVisible(true);

	// Set column parameters, and add a TextArea + ImageView in Column 0
	ColumnConstraints c0 = new ColumnConstraints();
	c0.setPercentWidth(20);
	c0.setHalignment(HPos.LEFT);
	TextArea taInstructions = new TextArea("\nInstructions\n\n"
		+ "1. Press the button below to get a new CRC Problem.\n\n" + "2. Attempt the problem yourself.\n\n"
		+ "3. Compare your answers to those in the Base2 and Shifted Poly tabs.\n");
	taInstructions.setEditable(false);
	gp.add(taInstructions, 0, 0, 3, 1);
	gp.add(iv, 0, 1, 1, 4);

	// Set column parameters, and add 2 x Labels + Logo in Column 1
	ColumnConstraints c1 = new ColumnConstraints();
	c1.setPercentWidth(35);
	c1.setHalignment(HPos.LEFT);
	GridPane.setConstraints(lbData, 1, 1, 1, 1, HPos.LEFT, VPos.BASELINE);
	GridPane.setConstraints(lbPattern, 1, 2, 1, 1, HPos.LEFT, VPos.BASELINE);
	GridPane.setConstraints(tx, 1, 3, 1, 3, HPos.LEFT, VPos.BOTTOM);
	gp.addColumn(1, lbData, lbPattern, tx);

	// Set column parameters, and add 2 x Text Fields, and 2 x Buttons in Column 2
	ColumnConstraints c2 = new ColumnConstraints();
	c2.setPercentWidth(45);
	c2.setHalignment(HPos.RIGHT);
	GridPane.setConstraints(tfData, 2, 1, 1, 1, HPos.RIGHT, VPos.BASELINE);
	GridPane.setConstraints(tfPattern, 2, 2, 1, 1, HPos.RIGHT, VPos.BASELINE);
	GridPane.setConstraints(btNew, 2, 3, 1, 1, HPos.RIGHT, VPos.TOP);
	GridPane.setConstraints(btExit, 2, 4, 1, 1, HPos.RIGHT, VPos.TOP);
	gp.getColumnConstraints().addAll(c0, c1, c2);
	gp.addColumn(2, tfData, tfPattern, btNew, btExit);

	// Create the Instructions Tab
	Tab tabInput = new Tab("Instructions");
	tabInput.setClosable(false);
	tabInput.setContent(gp);

	// Populate the data and pattern TextFields, and both data models
	updateProblemDisplay();

	// Create the Base2 Solution Tab and add the B2 TableView
	Tab tabBinary = new Tab("Base2 Solution", B2Model.getTableView());
	tabBinary.setClosable(false);

	// Create the Shifted Poly Solution Tab and add the SP TableView
	TableView<String[]> sptv = SPModel.getTableView();
	sptv.getStyleClass().add("sptableview");
	Tab tabPoly = new Tab("Shifted Poly Solution", sptv);
	tabPoly.setClosable(false);

	// Add all 3 Tabs to the TabPane
	root.getTabs().addAll(tabInput, tabBinary, tabPoly);

	// Signal that we need to layout the TabPane (ie. the Nodes are done)
	root.needsLayoutProperty();
	return true;
    }

    /*
     * updateProblemDisplay() method uses ProblemData.generateNewProblem() to create
     * a new pair of binary numbers. Converts each binary number to a string and
     * displays it on the Instructions tab. Uses B2Solver.solveBase2() to complete
     * the Base2 Solution TableView. Uses SPSolver.solveShiftedPoly() to complete
     * the Shifted Poly Solution TableView.
     */
    private void updateProblemDisplay() {
	int field_pos;
	int string_output_len;
	String string_output;

	// Create a new pair of binary numbers for a new problem.
	problemData.generateNewProblem();

	// Convert "Data" binary number to a string and display
	string_output_len = problemData.getData_len();
	string_output = "";
	for (field_pos = 0; field_pos < string_output_len; field_pos++) {
	    if (problemData.getData().bits.get(field_pos)) {
		string_output = string_output + "1";
	    } else {
		string_output = string_output + "0";
	    }
	}
	tfData.setText(string_output);

	// Convert "Pattern" binary number to a string and display
	string_output_len = problemData.getPattern_len();
	string_output = "";
	for (field_pos = 0; field_pos < string_output_len; field_pos++) {
	    if (problemData.getPattern().bits.get(field_pos)) {
		string_output = string_output + "1";
	    } else {
		string_output = string_output + "0";
	    }
	}
	tfPattern.setText(string_output);

	// Populate Base2 and Shifted Poly Models from the new Data and Pattern
	B2Solver.solveBase2(problemData, B2Model);
	SPSolver.solveShiftedPoly(B2Model, SPModel);
    }
}
