
/*
 * CIRCE - A JavaFX TEACHING TOOL BY:
 * -	Ian Baker (instructor)
 * -	Duncan Baxter s3737140
 * -	Kira Macarthur 
 * -	Rohan
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * Top-level Class for the tool
 */

public class Circe extends Application {
    Stage stage;
    TabPane root;
    Button btNew;

    /*
     * JavaFX Application thread automatically calls start() method. The parameter
     * Stage stage is our top-level window, then Scene scene, TabPane root, and all
     * the other Nodes. This method is quite short: it just creates the GUI.
     * 
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) throws IOException {
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
     * tabPane() method: creates TabPane, 3 Tabs and their contents.
     */
    private boolean createTabPane() {
	// Create a TabPane to hold the 3 Tabs
	root = new TabPane();

	// Load the JavaFX CSS StyleSheet
	root.getStylesheets().add("file:src/Circe.css");

	// Create the 2 x Text Fields (one-liners)
	TextField tfData = new TextField("10010011");
	tfData.setEditable(false);
	TextField tfPoly = new TextField("10111");
	tfPoly.setEditable(false);

	// Create the 2 x Buttons
	btNew = new Button("New CRC question");
	btNew.setOnMousePressed(me -> new Thread(new Tone(262, 100)).start());
	btNew.setOnAction(ae -> {
	    System.out.println("Process New CRC question");
	});

	Button btExit = new Button("Exit");
	btExit.setOnMousePressed(me -> new Thread(new Tone(262, 100)).start());
	btExit.setOnAction(ae -> {
	    System.out.println("Process Exit");
	    System.exit(0);
	});

	// Create a VBox to hold the TextFields and Buttons
	VBox vb = new VBox(10.0d);
	vb.getChildren().addAll(tfData, tfPoly, btNew, btExit);
	vb.setAlignment(Pos.CENTER);

	// Create an Image from our file
	ImageView iv = new ImageView(
		"https://upload.wikimedia.org/wikipedia/commons/1/1d/J._W._Waterhouse_-_Circe_Invidiosa_-_Google_Art_Project.jpg");
	iv.setPreserveRatio(true);
	iv.setFitWidth(125);

	// Create a BorderPane to hold the VBox
	BorderPane bp = new BorderPane();
	bp.setLeft(iv);
	BorderPane.setAlignment(iv, Pos.CENTER);
	bp.setRight(vb);

	// Create the input Tab
	Tab tabInput = new Tab("Input");
	tabInput.setClosable(false);
	tabInput.setContent(bp);

	// Create the binary Tab and a TextArea (multiple lines)
	TextArea taBinary = new TextArea();
	taBinary.setEditable(false);
	Tab tabBinary = new Tab("Binary", taBinary);
	tabBinary.setClosable(false);

	// Create the polynomial Tab and a TextArea (multiple lines)
	TextArea taPoly = new TextArea();
	taPoly.setEditable(false);
	Tab tabPoly = new Tab("Polynomial", taPoly);
	tabPoly.setClosable(false);

	// Add all 3 Tabs to the TabPane
	root.getTabs().addAll(tabInput, tabBinary, tabPoly);

	// Signal that we need to layout the TabPane (ie. the Nodes are done)
	root.needsLayoutProperty();
	return true;
    }

    /*
     * The usual "main" method - this code is only executed on platforms that lack
     * full JavaFX support.
     */
    public static void main(String[] args) {
	Application.launch(args);
    }
}
