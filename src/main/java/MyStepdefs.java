import Controller.Controller;
import View.CalculatorGUI;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.awt.*;
import java.util.Locale;


class Mock extends Controller {
    public Mock() {
        super();
    }
    static {
        EventQueue.invokeLater(()-> calculatorGUI
                = new CalculatorGUI());
    }

    public void close_message() {
        this.getCalculatorGUI().getResult().setText("");
    }

    public String get_message() {
        return this.getCalculatorGUI().getError().getText();
    }
}

public class MyStepdefs {

    private static Mock app;

    //private static double a,b;

    @Before
    public static void init() {
        app = new Mock();
    }

    @Дано("^введены два числа (.+) и (.+)")
    public void given(String a, String b) {
        app.getCalculatorGUI().getFirstArgValue().setText(a);
        app.getCalculatorGUI().getSecondArgValue().setText(b);
    }

    @Дано("^введено только первое число (-?\\d+.?\\d*)")
    public void given_first(double a) {
        app.getCalculatorGUI().getFirstArgValue().setText(Double.toString(a));
    }

    @Дано("^введено только второе число (-?\\d+.?\\d*)")
    public void given_second(double b) {
        app.getCalculatorGUI().getSecondArgValue().setText(Double.toString(b));
    }

    @Если("^сложить$")
    public void when_sum() {
        app.getCalculatorGUI().getSum().doClick();
        //app.close_message();
    }

    @Если("^вычесть$")
    public void when_subtract() {
        app.getCalculatorGUI().getMinus().doClick();
        //app.close_message();
    }

    @Если("^умножить$")
    public void when_multiply() {
        app.getCalculatorGUI().getMultiply().doClick();
        //app.close_message();
    }

    @Если("^разделить$")
    public void when_divide() {
        app.getCalculatorGUI().getDivide().doClick();
        //app.close_message();
    }

    @Тогда("^получим (.+)$")
    public void then_result(String res) {
        Assert.assertEquals(String.format(Locale.ROOT, "%.8f", Double.parseDouble(res)), app.getCalculatorGUI().getResult().getText());
    }

    @Тогда("^произойдёт (.+.)$")
    public void then_error(String error) {
        Assert.assertEquals(error, app.get_message());
    }
}
