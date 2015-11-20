# Work with MVC

This application is the same you have already encountered in the course, with minor improvements (the code here is not required to fit to few slides). Refer to to slides to understand how the application works.


## Show errors

* Modify the view interface and implementation in such a way that it can display controller-generated error strings

* The implementation may use JOptionPane.showMessageDialog() to display the error


## Configuration file

Currently, the game settings (minimum, maximum, and number of allowed attempts) are hardcoded. Modify the application in such a way that those settings are read from the supplied configuration files (config.yml).

### Suggestions:

* Use Files.readLines() to get the file content

* The file is a [standard YAML file](https://en.wikipedia.org/wiki/YAML). There are libraries to parse YML easily, but this very file is so simple that no particular strategy is required: just filter what is before and after the colon.

* Do not make the View operate on the file system. I/O operations belong to the Controller.

* **Only if you already know them** you can use Regular Expressions. **DO NOT** try to learn Regexps for solving this exercise.


## Multiple views

* Modify the architecture in such a way that multiple views are supported at the same time

* Develop two new views: one that writes the match log on file, another that writes on stdout. Those views are *output only* (they do not send new input to the controller).

* Attach at the same time two graphical views, the file logger, and the console view, and verify that the application works as expected