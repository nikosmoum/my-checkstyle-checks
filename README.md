# My Checkstyle checks

## What is Checkstyle?

<a href="http://checkstyle.sourceforge.net/index.html" target="_blank">Checkstyle</a> is an open source code formatting / static analysis tool for Java (and other languages).

## Description

This project is a personal collection of <a href="http://checkstyle.sourceforge.net" target="_blank">Checkstyle</a> checks I find useful. Some of them are standard (readily available in Checkstyle, <a href="http://checkstyle.sourceforge.net/checks.html" target="_blank">here</a>), while others are custom-built modules that can be plugged in to Checkstyle.

## How to use

* Prerequisite: You have a working Java JRE on your machine.

* Download and build this project by running `mvn package` from the project's main directory.

* Download Checkstyle .jar file by following the instructions <a href="http://checkstyle.sourceforge.net/#Download" target="_blank">here</a> and save it to an appropriate location.

* Run this command (assuming you use linux) from the project's main directory, and replace `<fully_qualified_checkstyle_jar_file_location>` with the location and name of the checkstyle .jar you downloaded, and `<fully_qualified_location_of_source_file_directory>` with the source file or folder you want to run the checks against:
```
java -classpath \
target/my-custom-checkstyle-extensions-0.0.1-SNAPSHOT.jar:\
<fully_qualified_checkstyle_jar_file_location> \
com.puppycrawl.tools.checkstyle.Main \
-c myChecks.xml <fully_qualified_location_of_source_file_directory>
```

