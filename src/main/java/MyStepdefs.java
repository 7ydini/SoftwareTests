import Controller.Controller;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

public class MyStepdefs {

    private static Controller app;
    public final double delta = 1e-9;

    @BeforeAll
    public static void init() {
        app = new Controller();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        Assert.assertEquals(Double.parseDouble(res), Double.parseDouble(app.getCalculatorGUI().getResult().getText()), delta);
    }

    @Тогда("^произойдёт (.+.)$")
    public void then_error(String error) {
        Assert.assertEquals(error, app.getCalculatorGUI().getError().getText());
    }

    @То("произойдет (.+.)$")
    public void произойдетError(String error) {
        Assert.assertEquals(error, app.getCalculatorGUI().getError().getText());
    }
}
