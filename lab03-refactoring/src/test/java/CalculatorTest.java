import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testCalc() {
        // (2+3) / (2*3) = 5/6 = 0.833...
        assertEquals(0.833, calculator.calculateResult(2, 3), 0.001);
    }

    @Test
    public void testCalcWithLargeNumbers() {
        // (10+5) / (10*5) = 15/50 = 0.3
        assertEquals(0.3, calculator.calculateResult(10, 5), 0.001);
    }
}