# Circe
JavaFX program to help students practice CRC calculations
+ Circe.java (main JavaFX file - includes main() and start() methods, sets up the GUI, ready for the maths code);
+ Tone.java (simple ADSHR tone generator - just makes keys beep, bit of a "work-in-progress");
+ Circe.css (JavaFX CSS file - includes most of the Styles for GUI components, we'll edit this to mimic the Applet); and
+ Circe.png (background picture for input section, bit of a place-holder, unlikely to be in the final version).

They should compile OK in Eclipse with Circe.java, Tone.java and Circe.css in the usual /src directory, and Circe.png in a /bin/images directory under the same Project folder.

Current status: if you compile and run it, you can see we have the main window, 3 tabbed panes, 2 text fields and 2 buttons on the input pane, and a text area on each of the other 2 panes.  We're pretty much ready to include the maths as the functionality underlying the "New CRC question" button, and update the styles to mimic the applet.
