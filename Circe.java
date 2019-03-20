
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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * Top-level Class for the tool
 */

public class Circe extends Application {
    Stage stage;
    GraphicsContext gc; // Graphics Context for drawing on primary Stage
    TabPane root;
    String oldHint; // Storage: former "press ESC key" message
    KeyCombination oldKey; // Storage: former exit-from-FullScreen key(s)

    /*
     * JavaFX Application thread automatically calls start() method. The parameter
     * Stage stage is our top-level window, then Scene scene, BorderPane root, and
     * finally other Nodes. This is quite short: it just creates the GUI.
     * 
     * start() may throw an IOException when trying to load the Image from the file.
     * There's no point in continuing if we can't load the Image, so the exception
     * can go through to the 'keeper.
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
	tabPane();
	// Create a Scene based on the TabPane with no background fill
	Scene scene = new Scene(root, null);
	// Add the Scene to the primary Stage and resize
	stage.setScene(scene);
	stage.show();
    }

    /*
     * tabPane() method: creates TabPane, 3 Tabs and their contents.
     */
    private boolean tabPane() {
	// Create the input Tab
	Tab tabInput = new Tab("Input");
	tabInput.setClosable(false);
	
	// Create a VBox to hold the TextFields and Buttons
	VBox vb = new VBox(5.0d);

	// Create a BorderPane to hold the VBox
	BorderPane bp = new BorderPane(vb);
	tabInput.setContent(bp);
	vb.setAlignment(Pos.CENTER);

	// Create 2 x Text Fields
	TextField tfData = new TextField("10010011");
	tfData.setEditable(false);
	TextField tfPoly = new TextField("10111");
	tfPoly.setEditable(false);

	// Create 2 x Buttons and add everything to the VBox
	Button btNew = new Button("New CRC parameters");
	btNew.setOnMousePressed(me -> new Thread(new Tone(262, 100)).start());
	btNew.setOnAction(ae -> {
	    System.out.println("Process New CRC parameters");
	});

	Button btExit = new Button("Exit");
	btExit.setOnMousePressed(me -> new Thread(new Tone(262, 100)).start());
	btExit.setOnAction(ae -> {
	    System.out.println("Process Exit");
	    System.exit(0);
	});
	vb.getChildren().addAll(tfData, tfPoly, btNew, btExit);
	
	// Create binary Tab and a TextArea
	TextArea taBinary = new TextArea();
	taBinary.setEditable(false);
	Tab tabBinary = new Tab("Binary", taBinary);
	tabBinary.setClosable(false);

	// Create polynomial Tab and a TextArea
	TextArea taPoly = new TextArea();
	taPoly.setEditable(false);
	Tab tabPoly = new Tab("Polynomial", taPoly);
	tabPoly.setClosable(false);

	// Create TabPane and add the 3 Tabs
	root = new TabPane(tabInput, tabBinary, tabPoly);
	// Load the JavaFX CSS StyleSheet
	root.getStylesheets().add("file:src/Circe.css");

	// Create an Image from our file
	Image image = new Image("file:bin/images/Circe.png");
	// Set the image as the TabPane's background
	root.setBackground(
		new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER, new BackgroundSize(0.0d, 0.0d, false, false, false, true))));
	// Signal that we need to layout the TabPane (ie. Nodes are done)
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
