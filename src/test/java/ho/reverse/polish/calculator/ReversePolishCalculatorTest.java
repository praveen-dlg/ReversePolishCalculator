package ho.reverse.polish.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReversePolishCalculatorTest {

    private ReversePolishCalculator reversePolishCalculator;

    @BeforeEach
    public void setUp() {
        // Initialize a new ReversePolishCalculator instance before each test
        reversePolishCalculator = new ReversePolishCalculator();
    }

    /**
     * Helper method to evaluate an expression using the calculator instance.
     *
     * @param expr The RPN expression string to evaluate.
     * @return The result string returned by the calculator.
     */
    private String eval(String expr) {
        return reversePolishCalculator.evaluateExpression(expr);
    }

    @Test
    public void testAdd() {
        assertTrue(eval("1 2 +").endsWith("= 3.0"));
    }

    @Test
    public void testSubtract() {
        assertTrue(eval("5 3 -").endsWith("= 2.0"));
    }

    @Test
    public void testMultiply() {
        assertTrue(eval("4 2 *").endsWith("= 8.0"));
    }

    @Test
    public void testDivide() {
        assertTrue(eval("10 2 /").endsWith("= 5.0"));
    }

    @Test
    public void testSqrt() {
        assertTrue(eval("9 sqrt").endsWith("= 3.0"));
    }

    @Test
    public void testSin() {
        assertEquals("0 sin = 0.0", eval("0 sin"));
    }

    @Test
    public void testCos() {
        assertEquals("0 cos = 1.0", eval("0 cos"));
    }

    @Test
    public void testAvg() {
        assertTrue(eval("10 30 avg").endsWith("= 20.0"));
    }

    @Test
    public void testMod() {
        assertTrue(eval("10 3 mod").endsWith("= 1.0"));
    }

    @Test
    public void testNonNumericInput() {
        assertTrue(eval("a b +").contains("Not Reverse Polish Notation"));
    }

    @Test
    public void testEmptyLine() {
        assertEquals("", eval(""));
    }

    @Test
    public void testInvalidOrder() {
        assertTrue(eval("1 + 2").contains("Not Reverse Polish Notation"));
    }

    @Test
    public void testTooManyOperands() {
        assertTrue(eval("1 2 3 +").contains("Not Reverse Polish Notation"));
    }

    @Test
    public void testStackUnderflow() {
        assertTrue(eval("+").contains("Not Reverse Polish Notation"));
    }

    @Test
    public void testInvalidUnaryOperation() {
        assertTrue(eval("sin").contains("Not Reverse Polish Notation"));
    }

    @Test
    public void testDivideByZero() {
        assertEquals("1 0 / - Not Reverse Polish Notation try backwards", eval("1 0 /"));
    }
}