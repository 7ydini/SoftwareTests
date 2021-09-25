package Model;

import Controller.Controller;
import Interfaces.Calculator;
import View.CalculatorGUI;

import java.awt.*;

public class CalculatorImpl implements Calculator {
    public static CalculatorGUI calculatorGUI;
    public static Controller controller = new Controller();
    public static void main(String[] args) {
        try {
            EventQueue.invokeLater(() -> calculatorGUI = new CalculatorGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public double sum(double a, double b) {
        double result = a + b;
        controller.resultToView(result);
        return result;
    }

    @Override
    public double subtract(double a, double b) {
        double result = a - b;
        controller.resultToView(result);
        return result;
    }

    @Override
    public double multiply(double a, double b) {
        double result = a * b;
        controller.resultToView(result);
        return result;
    }

    @Override
    public double divide(double a, double b) {
        if(Math.abs(b) < 10e-8){
            throw new ArithmeticException("|b| < 10e-8");
        }
        double result = a / b;
        controller.resultToView(result);
        return result;
    }
}
