import Model.CalculatorImpl;
import View.CalculatorGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorGUITests extends CalculatorGUI {
    public static CalculatorGUI calculatorGUI;
    public final double delta = 1e-9;

    @BeforeClass
    public static void createCalculatorGUI(){
        calculatorGUI = new CalculatorGUI();
    }
    @Before
    public void setArgsValue(){
        CalculatorGUI.firstArgValue.setText("5");
        CalculatorGUI.secondArgValue.setText("5");
    }

    @Test(expected = ArithmeticException.class)
    public void displayErrorDivideByZeroTest(){
        CalculatorGUI.secondArgValue.setText("0");
        CalculatorImpl.calculatorGUI = new CalculatorGUI();
        CalculatorGUI.divide.doClick();
    }

    @Test
    public void clickOnPlusTest(){
        CalculatorGUI.sum.doClick();
        Assert.assertEquals(10, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }

    @Test
    public void clickOnMinusTest(){
        CalculatorGUI.minus.doClick();
        Assert.assertEquals(0, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }

    @Test
    public void clickOnMultiplyTest(){
        CalculatorGUI.multiply.doClick();
        Assert.assertEquals(25, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }

    @Test
    public void clickOnDivideTest(){
        CalculatorGUI.divide.doClick();
        Assert.assertEquals(1, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }
}
