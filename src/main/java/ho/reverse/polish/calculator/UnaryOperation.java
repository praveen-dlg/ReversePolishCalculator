package ho.reverse.polish.calculator;

/**
 * Represents a unary operation that takes a single double operand and returns a double result.
 * This is a functional interface, suitable for use with lambda expressions or method references
 * to define operations like square root, sine, cosine, etc.,
 * within the Reverse Polish Notation calculator.
 */
interface UnaryOperation {
    double apply(double operand);
}
