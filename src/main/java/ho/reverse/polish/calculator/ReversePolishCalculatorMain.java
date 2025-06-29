package ho.reverse.polish.calculator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class ReversePolishCalculatorMain {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ho.test.calculator.ReversePolishCalculator <input_file_path>");
            return;
        }

        try {
            ReversePolishCalculator reversePolishCalculator = new ReversePolishCalculator();
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            for (String line : lines) {
                String result = reversePolishCalculator.evaluateExpression(line.trim());
                System.out.println(result);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}