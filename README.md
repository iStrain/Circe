# Circe
JavaFX program to help students practice CRC calculations.

The original files Ian provided are in CRC Trainer Development.zip - you should definitely download those!

Our working set includes:
+ Circe.java (main JavaFX file - includes main() and start() methods, instantiates the JavaFX GUI, ready for the maths code);
+ Model.java (wraps JavaFX TableView in Constructor, Accessor, Mutator and utility methods to mimic Swing's Table class - this is where we'll get performance improvements from people with more experience in JavaFX);
+ Tone.java (simple ADSHR tone generator - just makes keys beep, it's a bit of a "work-in-progress" but it beeps); and
+ Circe.css (JavaFX CSS file - includes most of the Styles for GUI components, we'll edit this to mimic the Applet).

They should compile OK in Eclipse with the .java files and Circe.css in the usual /src directory.

Current status: if you compile and run it, you can see we have the main window and 3 tabs: 2 labels, 2 text fields, 2 buttons and a logo on the input pane; a working "Base 2 Solution" tab, and a (non-working) text area on the "Shifted Poly Solution" tab.

We now have the maths part, so it's "full steam ahead" on the program.  Take a look at the new files Ian gave us, and see if you can work out how best to integrate them into the existing framework.  We'll compare notes in "a coupla days", and agree on a way forward!

I've had a quick look, though, and it should integrate nicely.  We have 2 jobs left, as I see it:
1. Randomising the input parameters (existing file ProblemData.java is fine for that - DONE);
2. Display the output under the binary method (existing file Base2solver.java looks good - DONE);
3. Display the output under the polynomial method (existing file ShiftedPoly_solver.java, again, looks fine).
We will need to include a couple of the "struct" class files in the project (e.g. Model.java as explained above) ... but they are pretty much what I expected.

Then we have job 4: a choice, either:
4(a)  Copy the exact same GUI format from the other files; or
4(b)  Make a couple of minor changes to make sure everything harmonises with our format.

So, who wants to put a hand up for 3 or 4?

Cheers,


DUNCAN
