import View.CalculatorGUI;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorGUITests {
    public static CalculatorGUI calculatorGUI;
    //public final double delta = 1e-9;
    @BeforeClass
    public static void createCalculatorGUI(){
        calculatorGUI = new CalculatorGUI();
    }
    @Test(expected = ArithmeticException.class)
    public void displayErrorTest(){
        calculatorGUI.displayError("Деление на 0");
    }
}
