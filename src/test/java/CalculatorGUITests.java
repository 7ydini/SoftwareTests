import Controller.Controller;
import View.CalculatorGUI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorGUITests extends CalculatorGUI {
    public static Controller controller;
    public final double delta = 1e-9;

    @BeforeClass
    public static void createCalculatorGUI() {
        controller = new Controller();
    }

    @Before
    public void setArgsValue() {
        CalculatorGUI.firstArgValue.setText("5");
        CalculatorGUI.secondArgValue.setText("5");
    }

    @Test
    public void clickOnPlusTest() {
        CalculatorGUI.sum.doClick();
        Assert.assertEquals(10, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }

    @Test
    public void clickOnMinusTest() {
        CalculatorGUI.minus.doClick();
        Assert.assertEquals(0, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }

    @Test
    public void clickOnMultiplyTest() {
        CalculatorGUI.multiply.doClick();
        Assert.assertEquals(25, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }

    @Test
    public void clickOnDivideTest() {
        CalculatorGUI.divide.doClick();
        Assert.assertEquals(1, Double.parseDouble(CalculatorGUI.result.getText()), delta);
    }

    @Test
    public void displayErrorDivideByZeroTest() {
        CalculatorGUI.secondArgValue.setText("0");
        CalculatorGUI.divide.doClick();
        Assert.assertEquals(controller.getCalculatorGUI().getError().getText(), "|b| < 10e-8");
    }

    @Test
    public void displayErrorFirsArgEmptyMultiplyTest() {
        CalculatorGUI.firstArgValue.setText("");
        CalculatorGUI.secondArgValue.setText("1");
        CalculatorGUI.multiply.doClick();
        Assert.assertEquals(controller.getCalculatorGUI().getError().getText(), "Первый аргумент пустой!");
    }

    @Test
    public void displayErrorFirsArgEmptyMinusTest() {
        CalculatorGUI.firstArgValue.setText("");
        CalculatorGUI.secondArgValue.setText("1");
        CalculatorGUI.minus.doClick();
        Assert.assertEquals(controller.getCalculatorGUI().getError().getText(), "Первый аргумент пустой!");
    }

    @Test
    public void displayErrorFirsArgEmptySumTest() {
        CalculatorGUI.firstArgValue.setText("");
        CalculatorGUI.secondArgValue.setText("1");
        CalculatorGUI.sum.doClick();
        Assert.assertEquals(controller.getCalculatorGUI().getError().getText(), "Первый аргумент пустой!");
    }
    @Test
    public void displayErrorFirsArgEmptyDivideTest() {
        CalculatorGUI.firstArgValue.setText("");
        CalculatorGUI.secondArgValue.setText("1");
        CalculatorGUI.divide.doClick();
        Assert.assertEquals(controller.getCalculatorGUI().getError().getText(), "Первый аргумент пустой!");
    }

    @Test
    public void displayErrorSecondArgEmptySumTest() {
        CalculatorGUI.secondArgValue.setText("");
        CalculatorGUI.firstArgValue.setText("1");
        CalculatorGUI.sum.doClick();
        Assert.assertEquals(controller.getCalculatorGUI().getError().getText(), "Второй аргумент пустой!");
    }

    @Test
    public void displayErrorSecondArgEmptyMinusTest() {
        CalculatorGUI.secondArgValue.setText("");
        CalculatorGUI.firstArgValue.setText("1");
        CalculatorGUI.sum.doClick();
        Assert.assertEquals(controller.getCalculatorGUI().getError().getText(), "Второй аргумент пустой!");
    }

}
