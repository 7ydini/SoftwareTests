package Controller;
import Interfaces.CalculatorPresenter;
import Model.CalculatorImpl;
import View.CalculatorGUI;

import java.awt.*;

public class Controller implements CalculatorPresenter {
    public static CalculatorImpl calculator = new CalculatorImpl();
    public static CalculatorGUI calculatorGUI;
    static {
        EventQueue.invokeLater(() -> {
            calculatorGUI = new CalculatorGUI();
        });
    }

    public static void main(String[] args) {
        System.out.println("---Start--- �� ���");
    }
    @Override
    public void onPlusClicked() {
        resultToView(calculator.sum(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument()));
    }

    @Override
    public void onMinusClicked() {
        resultToView(calculator.subtract(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument()));

    }

    @Override
    public void onDivideClicked() {
        try {
            resultToView(calculator.divide(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument()));
        }catch (ArithmeticException exception){
            calculatorGUI.displayError(exception.getMessage());
        }
    }

    @Override
    public void onMultiplyClicked() {
        resultToView(calculator.multiply(calculatorGUI.getFirstArgument(), calculatorGUI.getSecondArgument()));
    }

    public CalculatorGUI getCalculatorGUI() {
        return calculatorGUI;
    }
    public void resultToView(double result) {
        calculatorGUI.printResult(result);
    }
}
