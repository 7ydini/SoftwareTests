package Controller;
import Interfaces.CalculatorPresenter;
import Model.CalculatorImpl;
import View.CalculatorGUI;

public class Controller implements CalculatorPresenter {
    CalculatorImpl calculator = new CalculatorImpl();
    CalculatorGUI calculatorGUI = new CalculatorGUI();
    @Override
    public void onPlusClicked() {
        calculator.sum(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument());
    }

    @Override
    public void onMinusClicked() {
        calculator.subtract(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument());
    }

    @Override
    public void onDivideClicked() {
        calculator.divide(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument());
    }

    @Override
    public void onMultiplyClicked() {
        calculator.multiply(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument());
    }

    public void resultToView(double result) {
        calculatorGUI.printResult(result);
    }
}
