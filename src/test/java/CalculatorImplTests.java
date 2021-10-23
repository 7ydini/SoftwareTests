import Interfaces.Calculator;
import Model.CalculatorImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorImplTests {
    public static Calculator calculator;
    public final double delta = 1e-9;

    @BeforeClass
    public static void createCalculator() {
        calculator = new CalculatorImpl();
    }


    //SUM TESTS
    @Test
    public void positivePositiveSumTest() {
        Assert.assertEquals(5, calculator.sum(2.5, 2.5), delta);
    }

    @Test
    public void positiveNegativeSumTest() {
        Assert.assertEquals(2, calculator.sum(6, -4), delta);
    }

    @Test
    public void negativePositiveSumTest() {
        Assert.assertEquals(0, calculator.sum(-2.5, 2.5), delta);
    }

    @Test
    public void negativeNegativeSumTest() {
        Assert.assertEquals(-5, calculator.sum(-2.5, -2.5), delta);
    }

    @Test
    public void positiveZeroSumTest() {
        Assert.assertEquals(3.7, calculator.sum(3.7, 0), delta);
    }

    @Test
    public void negativeZeroSumTest() {
        Assert.assertEquals(-3.7, calculator.sum(-3.7, 0), delta);
    }

    @Test
    public void zeroZeroSumTest() {
        Assert.assertEquals(0, calculator.sum(0, 0), delta);
    }


    //Subtract TESTS
    @Test
    public void positivePositiveSubtractTest() {
        Assert.assertEquals(0, calculator.subtract(2.5, 2.5), delta);
    }

    @Test
    public void positiveNegativeSubtractTest() {
        Assert.assertEquals(10, calculator.subtract(6, -4), delta);
    }

    @Test
    public void negativePositiveSubtractTest() {
        Assert.assertEquals(-5, calculator.subtract(-2.5, 2.5), delta);
    }

    @Test
    public void negativeNegativeSubtractTest() {
        Assert.assertEquals(0, calculator.subtract(-2.5, -2.5), delta);
    }

    @Test
    public void positiveZeroSubtractTest() {
        Assert.assertEquals(3.7, calculator.subtract(3.7, 0), delta);
    }

    @Test
    public void negativeZeroSubtractTest() {
        Assert.assertEquals(-3.7, calculator.subtract(-3.7, 0), delta);
    }

    @Test
    public void zeroZeroSubtractTest() {
        Assert.assertEquals(0, calculator.subtract(0, 0), delta);
    }
    //

    //Divide TESTS
    @Test
    public void positivePositiveDivideTest() {
        Assert.assertEquals(1, calculator.divide(2.5, 2.5), delta);
    }

    @Test
    public void positiveNegativeDivideTest() {
        Assert.assertEquals(-2, calculator.divide(6, -3), delta);
    }

    @Test
    public void negativePositiveDivideTest() {
        Assert.assertEquals(-1, calculator.divide(-2.5, 2.5), delta);
    }

    @Test
    public void negativeNegativeDivideTest() {
        Assert.assertEquals(1, calculator.divide(-2.5, -2.5), delta);
    }

    @Test(expected = ArithmeticException.class)
    public void positiveZeroDivideTest() {
        calculator.divide(3.7, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void negativeZeroDivideTest() {
        calculator.divide(-3.7, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void zeroZeroDivideTest() {
        calculator.divide(0, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void divideExceptionTest() {
        calculator.divide(10, 10e-9);
    }

    //Multiply TESTS
    @Test
    public void positivePositiveMultiplyTest() {
        Assert.assertEquals(6.25, calculator.multiply(2.5, 2.5), delta);
    }

    @Test
    public void positiveNegativeMultiplyTest() {
        Assert.assertEquals(-24, calculator.multiply(6, -4), delta);
    }

    @Test
    public void negativePositiveMultiplyTest() {
        Assert.assertEquals(-6.25, calculator.multiply(-2.5, 2.5), delta);
    }

    @Test
    public void negativeNegativeMultiplyTest() {
        Assert.assertEquals(6.25, calculator.multiply(-2.5, -2.5), delta);
    }

    @Test
    public void positiveZeroMultiplyTest() {
        Assert.assertEquals(0, calculator.multiply(3.7, 0), delta);
    }

    @Test
    public void negativeZeroMultiplyTest() {
        Assert.assertEquals(0, calculator.multiply(-3.7, 0), delta);
    }

    @Test
    public void zeroZeroMultiplyTest() {
        Assert.assertEquals(0, calculator.multiply(0, 0), delta);
    }

}
