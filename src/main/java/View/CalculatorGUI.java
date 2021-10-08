package View;

import Controller.Controller;
import Interfaces.CalculatorView;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class CalculatorGUI implements CalculatorView {
    private static Controller controller;
    private static JFrame frame = new JFrame("Interfaces.Calculator");
    private static JPanel panel = new JPanel();
    private static JLabel resultLabel = new JLabel("Result:");
    protected static JLabel result = new JLabel();
    private static final JLabel firstArgLabel = new JLabel("First Argument:");
    private static final JLabel secondArgLabel = new JLabel("Second Argument:");
    protected static JTextField firstArgValue = new JTextField("");
    protected static JTextField secondArgValue = new JTextField("");
    protected static JButton sum;
    protected static JButton minus;
    protected static JButton multiply;
    protected static JButton divide;
    static{

        controller = new Controller();
        sum = new JButton("+");
        sum.addActionListener(e -> {
            controller.onPlusClicked();
        });
        minus = new JButton("-");
        minus.addActionListener(e -> {
            controller.onMinusClicked();
        });
        multiply = new JButton("*");
        multiply.addActionListener( e -> {
            controller.onMultiplyClicked();
        });
        divide = new JButton("/");
        divide.addActionListener(e -> {
            controller.onDivideClicked();
        });
        firstArgValue.setDocument(new PlainDocument(){
            final String chars = "0123456789.";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if(chars.contains(str)){
                    super.insertString( offs, str, a);
                }
            }
        });
        secondArgValue.setDocument(new PlainDocument(){
            final String chars = "0123456789.";
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if(chars.contains(str)){
                    super.insertString( offs, str, a);
                }
            }
        });

        GridLayout layout = new GridLayout(5,4);
        panel.setLayout(layout);
        fillPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250, 300);
        frame.setVisible(true);
        frame.setLocation(800, 400);
    }

    private static void fillPanel() {
        panel.add(firstArgLabel);
        panel.add(secondArgLabel);
        panel.add(firstArgValue);
        panel.add(secondArgValue);
        panel.add(resultLabel);
        panel.add(result);
        panel.add(sum);
        panel.add(minus);
        panel.add(multiply);
        panel.add(divide);
    }

    @Override
    public void printResult(double resultD) {
        result.setText(String.valueOf(resultD));
        result.repaint();
    }

    @Override
    public void displayError(String message) {
        JFrame errorFrame = new JFrame();
        JLabel error = new JLabel(message);
        errorFrame.add(error);
        errorFrame.setSize(200, 100);
        errorFrame.setVisible(true);
        errorFrame.setLocation(800, 400);
        throw new ArithmeticException(message);
    }

    @Override
    public double getFirstArgument() {
        double result = 0;
        try {
            result = Double.parseDouble(firstArgValue.getText());
        }catch (NumberFormatException ex){
            displayError("Первый аргумент пустой!");
        }
        return result;
    }

    @Override
    public double getSecondArgument() {
        double result = 0;
        try {
            result = Double.parseDouble(secondArgValue.getText());
        }catch (NumberFormatException ex){
            displayError("Второй аргумент пустой!");
        }
        return result;
    }
}
