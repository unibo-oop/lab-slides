# Ex01: simple monolithic GUI

## Understand
1. Read the class carefully
2. Read the comments carefully
5. Note the use of ``Toolkit`` to get the current screen resolution, and dimension the window correctly
6. Note the use of ``JFrame. setLocationByPlatform()`` to delegate the window positioning to the system composer (the part of the graphical stack in charge of effectively drawing windows, borders, decorations and effects).

## Do
### Ex 01.01
1. Create a new JPanel
2. Use an horizontal BoxLayout as layout
3. Set the new JPanel as the only content of the center of the current BorderLayout
4. Add the JButton to the new panel
5. Test your application: it should appear similar, but the button will get smaller
6. In ``display()``, use JFrame.pack() to resize the frame to the minimum size prior to displaying

### Ex 01.02
1. Create a new "Result" text field
2. Add it to the external JPanel in such a way that it gets on the top of the frame (Borderlayout.NORTH)
3. Test your application. Verify that you can see a new Text field, but it is useless

### Ex 01.03
1. Modify the application in such a way that the text field displays the same number that gets printed
2. Test it
