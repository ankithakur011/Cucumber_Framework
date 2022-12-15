This project contains a test automation framework using Selenium with Java as the coding language. It follows the page object model (POM) as the design pattern, uses Cucumber for writing test cases, and includes the log4j logging framework and Maven for managing dependencies and building the project.

**Prerequisites**

To run the tests, you need to have Java 8 or higher and Maven installed on your system.

**Page objects**

The page object model (POM) is a design pattern that creates an abstraction layer for the pages in the application under test. Each page is represented by a page object, which contains the elements and functionality specific to that page. This allows tests to interact with the page through the page object, making the tests more readable and maintainable.

In this project, the page objects are located in the src/main/java/com/mycompany/app/pageobjects and src/test/java/com/mycompany/app/pageobjects directories.

**Cucumber tests**

This project uses Cucumber to write and run the tests. Cucumber allows tests to be written in a human-readable language called Gherkin, which makes the tests easy to understand and maintain.

The Cucumber tests are located in the src/test/java/com/mycompany/app/tests directory. The RunCukesTest.java file is the Cucumber test runner, and the step definitions (the glue code between the Gherkin tests and the actual tests) are located in the same directory.

**Logging**

This project uses log4j for logging. The log4j configuration is done in the log4j.properties file. The log files will be created in the logs directory.

**Dependency management and build**

This project uses Maven for managing project dependencies and building the project. The dependencies are specified in the pom.xml file, and the build can be executed using the mvn command.
