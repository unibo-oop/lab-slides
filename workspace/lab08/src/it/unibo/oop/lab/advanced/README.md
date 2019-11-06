# Work with MVC

This application is the same in the main course slides, with minor improvements (the code here is not required to fit to few slides). Refer to to slides to understand how the application works.
We will enrich the example by adding I/O.

## Prepare the UI to show errors

The I/O access is source of new possible unpredicted situations, that should be reported to the user as errors via the UI. As a first step, we will add to the view the ability to display errors generated in the controller.

* Add a method void displayError(String message) in `DrawNumberView`
* Implement the method in `DrawNumberViewImpl`, using `JOptionPane.showMessageDialog()` to display the error

## Configuration file

Currently, the game settings (minimum, maximum, and number of allowed attempts) are hard-coded. Modify the application in such a way that those settings are read from the supplied configuration files (config.yml). An example of configuration file is available in the res folder.

### Suggestions:

* Use the resource loader to load the file provided in res. You can wrap the stream with a `StreamReader` and a `BufferedReader` to get the contents and proceed line by line.

* The file (see the example in the "res" folder) is a [standard YAML file](https://en.wikipedia.org/wiki/YAML). There are libraries to parse YML easily, but this very file is so simple that no particular strategy is required: just filter what is before and after the colon.

* Do not make the View operate on the file system. More precisely, the controller in its constructor must be able to read the provided configuration file, and import the three constants. Even better, an external utility (either a method or another class) could be responsible for that. The reason is that the interaction with the file system is not part of the domain model, nor, in this case, is part of the view.

* You can use `StringTokenizer` to split a `String` in parts. Another option, available for this very case, is `String.split()`, passing `":"` as argument. Beware of `split()`: the input `String` is actually a regular expression. Regular expressions (regex) are a very powerful tool, but we can not cover them in this course: ``StringTokenizer`` is recommended unless you already know regular expressions and how to use them.

## Multiple views

* Modify the architecture in such a way that multiple views are supported at the same time.

* Develop two new views (classes extending `DrawNumberView`): one that writes the match log on file, another that writes on stdout. Those views are *output only* (they do not send new input to the controller).

* Extend the controller to support multiple views. For doing so, make sure that the controller has a list of views (and not a single one), and that it notifies all of them (for instance with a `for` cicle) every time a new event should be displayed.

* Attach at the same time two graphical views, the file logger, and the console view, and verify that the application works as expected