import Model.CalculatorImpl;
import View.CalculatorGUI;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorImplTest {
    public static CalculatorImpl calculator;
    public static CalculatorGUI calculatorGUI;
    public final double delta = 1e-9;

    @BeforeClass
    public static void createCalculator(){
        calculator = new CalculatorImpl();
    }

    @Test
    public void sumTest(){
        Assert.assertEquals(5, calculator.sum(2.5, 2.5), delta);
        Assert.assertEquals(10, calculator.sum(6, 4), delta);
        Assert.assertEquals(0, calculator.sum(-2.5, 2.5), delta);
        Assert.assertEquals(8, calculator.sum(3.7, 4.3), delta);
    }

    @Test
    public void subtractTest(){
        Assert.assertEquals(5, calculator.subtract(7.5, 2.5), delta);
        Assert.assertEquals(0, calculator.subtract(15, 15), delta);
        Assert.assertEquals(-5, calculator.subtract(2.5, 7.5), delta);
        Assert.assertEquals(12.0, calculator.subtract(7.5, -4.5), delta);
        Assert.assertEquals(-3, calculator.subtract(-7.5, -4.5), delta);
        Assert.assertEquals(-12, calculator.subtract(-7.5, 4.5), delta);
    }

    @Test
    public void divideTest(){
        Assert.assertEquals(3, calculator.divide(7.5, 2.5), delta);
        Assert.assertEquals(-3, calculator.divide(-7.5, 2.5), delta);
        Assert.assertEquals(3, calculator.divide(-7.5, -2.5), delta);
    }
    @Test(expected = ArithmeticException.class)
    public void divideExceptionTest(){
        calculator.divide(10, 10e-9);
    }

    @Test
    public void multiplyTest(){
        Assert.assertEquals(15, calculator.multiply(7.5, 2), delta);
        Assert.assertEquals(22.5, calculator.multiply(7.5, 3), delta);
        Assert.assertEquals(1, calculator.multiply(10, 0.1), delta);
    }

    @Test(expected = ArithmeticException.class)
    public void displayErrorTest(){
        calculatorGUI.displayError("Деление на 0");
    }

}
