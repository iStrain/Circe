# Circe
JavaFX program to help students practice CRC calculations.

The original files Ian provided are in CRC Trainer Development.zip - you should definitely download those!

Our working set includes:
+ Circe.java (main JavaFX file - includes main() and start() methods, instantiates the JavaFX GUI, ready for the maths code);
+ Model.java (wraps JavaFX TableView in Constructor, Accessor, Mutator and utility methods to mimic Swing's JTable class - this is where we'll get performance improvements from people with more experience in JavaFX);
+ somewhat modified versions of Ian's files BinaryNumber.java, ProblemData.java, Base2Solver.java and ShiftedPolySolver.java (yeah, mainly to change class, method and variable names for harmony with the way I do them #cosOCD, but also to use my Model class instead of Swing's JTable);
+ Tone.java (simple ADSHR tone generator - just makes keys beep, it's a bit of a "work-in-progress" but it beeps); and
+ Circe.css (JavaFX CSS file - includes most of the Styles for GUI components, we'll edit this to mimic the Applet).

They should compile OK in Eclipse with the .java files and Circe.css in the usual /src directory.

Current status: if you compile and run it, you can see we have the main window and 3 tabs: 2 labels, 2 text fields, 2 buttons and a logo on the input pane; a working "Base 2 Solution" tab, and a working (but not yet properly formatted) "Shifted Poly Solution" tab.

We only have 1 job left, as I see it:
A choice, either:
(a)  Copy the exact same GUI format from Ian's other files; or
(b)  Finish the formatting for the Shifted Poly Solution tab, and a few other minor changes, to make sure everything harmonises with our format.

So, who wants to put a hand up for the formatting?

Cheers,


DUNCAN
