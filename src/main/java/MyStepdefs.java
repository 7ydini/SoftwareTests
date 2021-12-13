import Controller.Controller;
import cucumber.api.java.Before;
import cucumber.api.java.ru.����;
import cucumber.api.java.ru.����;
import cucumber.api.java.ru.�����;
import org.junit.Assert;

import java.util.Locale;


class Mock extends Controller {
    public Mock() {
        super();
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

    @����("^������� ��� ����� (.+) � (.+)")
    public void given(String a, String b) {
        app.getCalculatorGUI().getFirstArgValue().setText(a);
        app.getCalculatorGUI().getSecondArgValue().setText(b);
    }

    @����("^������� ������ ������ ����� (-?\\d+.?\\d*)")
    public void given_first(double a) {
        app.getCalculatorGUI().getFirstArgValue().setText(Double.toString(a));
    }

    @����("^������� ������ ������ ����� (-?\\d+.?\\d*)")
    public void given_second(double b) {
        app.getCalculatorGUI().getSecondArgValue().setText(Double.toString(b));
    }

    @����("^�������$")
    public void when_sum() {
        app.getCalculatorGUI().getSum().doClick();
        //app.close_message();
    }

    @����("^�������$")
    public void when_subtract() {
        app.getCalculatorGUI().getMinus().doClick();
        //app.close_message();
    }

    @����("^��������$")
    public void when_multiply() {
        app.getCalculatorGUI().getMultiply().doClick();
        //app.close_message();
    }

    @����("^���������$")
    public void when_divide() {
        app.getCalculatorGUI().getDivide().doClick();
        //app.close_message();
    }

    @�����("^������� (.+)$")
    public void then_result(String res) {
        Assert.assertEquals(String.format(Locale.ROOT, "%.8f", Double.parseDouble(res)), app.getCalculatorGUI().getResult().getText());
    }

    @�����("^���������� (.+.)$")
    public void then_error(String error) {
        Assert.assertEquals(error, app.get_message());
    }
}
