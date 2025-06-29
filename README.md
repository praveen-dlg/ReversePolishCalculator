# Reverse Polish Notation Calculator

A simple, extensible command-line Reverse Polish Notation calculator implemented in Java.

This project supports basic and scientific operations, includes unit tests with **100% code coverage**, and uses **GitHub Actions** for Continuous Integration.

## Design Pattern: Command Pattern

The **Command Pattern**. This design choice enhances the extensibility and maintainability of the calculator by encapsulating each operation (like addition, subtraction, square root, etc.) into its own functional interface and implementation.

## Features

* **Reverse Polish Notation **: Processes mathematical expressions written in Reverse Polish Notation.
* **Standard Arithmetic Operations**: Supports addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`).
* **Scientific Operations**: Includes square root (`sqrt`), sine (`sin`), and cosine (`cos`).
* **Additional Operations**:
    * `avg`: Calculates the average of two numbers.
    * `mod`: Calculates the modulus of two numbers.
* **Error Handling**: Provides clear messages for invalid expressions, such as insufficient operands or division by zero.
* **File Input**: Reads calculations from a specified input file.
* **Command Line Application**: Designed as a command-line tool.
* **Production Ready**: Written in Java, adhering to production-ready standards.
* **Unit Tests**: Comprehensive JUnit tests ensuring correctness and robustness, achieving **100% code coverage**.
* **Build Tool**: Uses Gradle/Maven for building the project and managing dependencies.
* **No External Frameworks (except build/test)**: Adheres to the requirement of using standard language features only, with exceptions for build and test tools.
* **No Binaries**: The submission will only include source code, not compiled binaries.

## How to Build and Run

### Prerequisites

* Java Development Kit (JDK) 11 or higher
* Gradle or Maven

### Building the Project

1.  Clone the repository:
    ```bash
    git clone git@github.com:praveen-dlg/ReversePolishCalculator.git
    cd ReversePolishCalculator
    ```
2.  Compile the Java code and run tests using Gradle:
    ```bash
    ./gradlew build
    ```
    This command will compile the source code, run the tests, and generate the JaCoCo test coverage report.
    **Using Maven:**
    Compile the Java code and run tests using Maven:
    ```bash
    ./mvnw clean install
    ```
    This command will compile the source code, run the tests, and package the application.

### Running the Application

After building, you can run the calculator from the command line.

1. Create an input file (e.g., `input.txt`) with RPN expressions, one per line:

    ```
    1.0 2.0 +
    3 4 *
    6 3 * 2 - sqrt
    1 + 1 -
    4 2 - 2 - 1000 *
    10 30 avg
    10 3 mod
    9 sqrt
    0 sin
    0 cos
    10 0 /
    ```

2. Run the application, providing the input file path:

    ```bash
    ./gradlew run --args="input.txt"
    ```
   **Using Maven:**
   Run the application, providing the input file path:
    ```bash
    ./mvnw exec:java -Dexec.mainClass="ho.reverse.polish.calculator.ReversePolishCalculatorMain" -Dexec.args="input.txt"
    ```

3. Expected Output for input.txt:

    ```bash
    1.0 2.0 + = 3.0
    3 4 * = 12.0
    6 3 * 2 - sqrt = 4.0
    1 + 1 - Not Reverse Polish Notation try backwards
    4 2 - 2 - 1000 * = 0.0
    10 30 avg = 20.0
    10 3 mod = 1.0
    9 sqrt = 3.0
    0 sin = 0.0
    0 cos = 1.0
    10 0 / - Not Reverse Polish Notation try backwards
    ```


## Testing

The project includes comprehensive unit tests using JUnit 5.

To run the tests and generate code coverage reports:
```bash
./gradlew test jacocoTestReport
```
This will generate a coverage report at build/reports/jacoco/test/html/index.html showing uncovered code paths.

* **Using Maven:**
  To run the tests:
    ```bash
    ./mvnw test
    ```
  To generate code coverage reports (requires JaCoCo plugin configured in `pom.xml`):
    ```bash
    ./mvnw jacoco:report
    ```
  The JaCoCo report will typically be generated in `target/site/jacoco/index.html`.

