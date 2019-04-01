# Circe
JavaFX program to help students practice CRC calculations:  Still needs some minor tweaking of formatting, but essentially done.

The original files Ian provided are in CRC Trainer Development.zip - you should definitely download those!

Our working set includes:
+ Circe.java (main JavaFX file - includes main() and start() methods, instantiates the JavaFX GUI;
+ Model.java (wraps JavaFX TableView in Constructor, Accessor, Mutator and utility methods to mimic Swing's JTable class - this is where we'll get performance improvements from people with more experience in JavaFX);
+ somewhat modified versions of Ian's files BinaryNumber.java, ProblemData.java, Base2Solver.java and ShiftedPolySolver.java (yeah, mainly to change class, method and variable names for harmony with the way I do them #cosOCD, but also to use my Model class instead of Swing's JTable);
+ Tone.java (simple ADSHR tone generator - just makes keys beep, it's a bit of a "work-in-progress" but at least it beeps); and
+ Circe.css (JavaFX CSS file - includes most of the Styles we apply to the GUI components).

They should compile OK in Eclipse with the .java files and Circe.css in the usual /src directory.

Current status: if you compile and run it, you can see we have the main window and 3 tabs: 2 labels, 2 text fields, 2 buttons and a logo on the input pane; a working "Base 2 Solution" tab; and a working "Shifted Poly Solution" tab.  I call that "job done"!

Being the perfectionist I am, I will doubtless still fiddle around with the formatting, but I like the way it looks and works.

Cheers,


DUNCAN
