# spriteCloud Assignment

## Description

Project created for spriteCloud technical assignment. It includes UI and API test automation implementation and execution.

## Features

- **Web Testing:** Automates end-to-end testing of web applications.

- **API Testing:** Simplified API request handling and response validation.

- **Modular design:** Implementation of the Page Object Model pattern.

- **BDD with Cucumber:** Write tests in a natural language format using feature files.

- **Serialization and deserialization:** POJO-based handling of API requests and responses.

- **Dependency management:** Maven is used to manage libraries.

- **Reporting**: HTML report generation using Cucumber for clear visualization of test results. Reports are automatically published to GitHub Pages via GitHub Actions, facilitating easy access and ongoing review.

- **GitHub Actions:** Automates the execution of tests in a continuous integration pipeline.


## Technologies Used

- **Language:** `Java`

- **Web Automation:** `Selenium WebDriver`

- **API Testing Framework:** `REST Assured`

- **Test Framework:** `JUnit`

- **Behavior-Driven Development (BDD):** `Cucumber`

- **Dependency Manager:** `Maven`

- **Reporting:** `Cucumber HTML Reports`

- **Continuous Integration:** `GitHub Actions`

## Project Structure

```bash
|-- src
    |-- main
        |-- java
            |-- api
                |-- endpoints
                |-- models
                    |-- requests
                    |-- responses
                |-- services
            |-- ui
                |-- manager
                |-- pages
    |-- test
        |-- java
            |-- data
            |-- runner
            |-- stepsdefinitions
                |-- api_steps
                |-- ui_steps
        |-- resources
            |-- features
                |-- api_features
                |-- ui_features
```

- **main/java/api/endpoints:** Contains the endpoints used for API testing.
- **main/java/api/models:** POJOs for serialization and deserialization of API requests and responses.
- **main/java/api/services:** Contains classes that abstract API operations, such as methods for retrieving and manipulating resources.
- **main/java/ui/manager:** Contains the class that manages the WebDriver.
- **main/java/ui/pages:** Classes representing the web pages under test.
- **test/java/data:** Contains static data and context data (A dynamic context store was not implemented to not over engineer.)
- **test/java/runner:** Contains test runner
- **test/java/stepsdefinitions:** Contains step definitions for UI and API Cucumber tests.
- **test/resources/features:** Contains feature files for UI and API test cases.

## Setup and run

1. Clone the repository:
```bash
git clone https://github.com/julianmancuello/spriteCloud-Assignment.git
```
2. Import the project into IntelliJ IDEA or any compatible IDE.
3. Ensure environment configuration:
   - Java 20 should be configured in the ```PATH```.
   - Maven must be installed locally. Verify the installation by running:
     ```bash
     mvn -version
     ```
4. Navigate to the project directory and install the required dependencies using Maven:
```bash
mvn clean install
```
5. Run:
```bash
mvn clean test
```

## Continuous Integration and HTML report

A CI pipeline is configured using GitHub Actions to automate the testing process. The pipeline runs the tests on each push to the main branch.

The configuration file is located at .github/workflows/pipeline.yml.

After every run the results are published in the Actions tab in the repository.

Results report is published in gh-pages branch and can be accessed via the following link:
https://julianmancuello.github.io/spriteCloud-Assignment/







