package ho.reverse.polish.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ReversePolishCalculator {

    private static final Map<String, BinaryOperation> binaryOperations = new HashMap<>();
    private static final Map<String, UnaryOperation> unaryOperations = new HashMap<>();

    static {
        binaryOperations.put("+", (a, b) -> a + b);  // Lambda expression
        binaryOperations.put("-", (a, b) -> a - b);
        binaryOperations.put("*", (a, b) -> a * b);
        binaryOperations.put("/", (a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        });
        binaryOperations.put("avg", (a, b) -> (a + b) / 2);
        binaryOperations.put("mod", (a, b) -> a % b);

        unaryOperations.put("sqrt", Math::sqrt);   // Method reference
        unaryOperations.put("sin", Math::sin);
        unaryOperations.put("cos", Math::cos);
    }


    public String evaluateExpression(String line) {
        if (line.isEmpty()) return "";

        String[] tokens = line.split("\\s+");
        Stack<Double> stack = new Stack<>();

        try {
            for (String token : tokens) {
                if (binaryOperations.containsKey(token)) {
                    if (stack.size() < 2) throw new IllegalArgumentException("Insufficient operands for " + token);
                    double operand2 = stack.pop();
                    double operand1 = stack.pop();
                    stack.push(binaryOperations.get(token).apply(operand1, operand2));
                } else if (unaryOperations.containsKey(token)) {
                    if (stack.size() < 1) throw new IllegalArgumentException("Insufficient operands for " + token);
                    double operand = stack.pop();
                    stack.push(unaryOperations.get(token).apply(operand));
                } else {
                    stack.push(Double.parseDouble(token));
                }
            }

            if (stack.size() == 1) {
                return line + " = " + stack.pop();
            } else {
                return line + " - Not Reverse Polish Notation try backwards";
            }
        } catch (Exception e) {
            // For cases like "1 + 2" or "a b +" or "1 0 /"
            return line + " - Not Reverse Polish Notation try backwards";
        }
    }
}