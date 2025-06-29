package ho.reverse.polish.calculator;

/**
 * Represents a binary operation that takes two double operands and returns a double result.
 * This is a functional interface, suitable for use with lambda expressions or method references
 * to define operations like addition, subtraction, multiplication, division, etc.,
 * within the Reverse Polish Notation calculator.
 */
interface BinaryOperation {
    double apply(double operand1, double operand2);
}
