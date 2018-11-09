# Simple monolithic GUI

## Understand
1. Read the class carefully
2. Read the comments carefully
3. Note how ``System.getProperties()`` is used to obtain properties of the current system
4. Note how these properties are used to produce multi-platform code
   **NOTE**: ``write once, run everywhere`` is true only if the code is maeant to be multiplatform!
5. Note the use of ``Toolkit`` to get the current screen resolution, and dimension the window correctly
6. Note the use of ``JFrame. setLocationByPlatform()`` to delegate the window positioning to the system composer (the part of the graphical stack in charge of effectively drawing windows, borders, decorations and effects).

## Do
### Ex 01.01
1. Create a new JPanel
2. Use an horizontal BoxLayout as layout
3. Set the new JPanel as the only content of the center of the current BorderLayout
4. Add the "write" JButton to the new panel
5. Test your application: it should appear similar, but the button will get smaller
6. In ``display()``, use JFrame.pack() to resize the frame to the minimum size prior to displaying

### Ex 01.02
1. Create a new "Read" button
2. Add it to the JPanel created in ``Ex 01.01``
3. Test your application. Verify that you can see a new button, but it is useless
4. Write a new ``ActionListener`` for the new button, in form of anonymous class, that prints a string on terminal (use ``System.out``) when the button is pressed.
5. Test it

### Ex 01.03
1. Modify the ActionListener in such a way that it reads the content of the same file that is written when the button "write" is pressed, and prints its content on standard output

**Remember that:**
* There are some _very handy_  methods in `java.nio.Files` (e.g. `[readAllLines](http://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html#readAllLines(java.nio.file.Path,%20java.nio.charset.Charset))`
* `PrintStream`s are probably the easiest way to write text on files
