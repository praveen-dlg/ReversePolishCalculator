package ho.reverse.polish.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ReversePolishCalculatorMainTest {
    private ReversePolishCalculatorMain polishCalculatorMain;
    @BeforeEach
    public void setUp() {
        // Initialize a new ReversePolishCalculatorMain instance before each test
        polishCalculatorMain = new ReversePolishCalculatorMain();
    }
    @Test
    void testMainWithValidFile(@TempDir Path tempDir) throws Exception {
        Path inputFile = tempDir.resolve("input.txt");
        Files.write(inputFile, List.of("2 3 +", "4 5 *"));

        ReversePolishCalculatorMain.main(new String[]{inputFile.toString()});
        // Add assertions if needed
    }

    @Test
    void testMainWithInvalidFile() {
        assertDoesNotThrow(() ->
                ReversePolishCalculatorMain.main(new String[]{"nonexistent.txt"})
        );
    }

    @Test
    void testMainWithNoArguments() {
        assertDoesNotThrow(() -> ReversePolishCalculatorMain.main(new String[]{}));
    }
}