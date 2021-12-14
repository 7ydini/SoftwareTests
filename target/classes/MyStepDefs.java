import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;

public class MyStepDefs {
    @Допустим("введены два числа <a> и <b>")
    public void введеныДваЧислаAИB() {
    }

    @Если("разделить")
    public void разделить() {
    }

    @То("получим <result>")
    public void получимResult() {
    }

    @Допустим("введено только первое число <a>")
    public void введеноТолькоПервоеЧислоA() {
    }

    @То("произойдет <error>")
    public void произойдетError() {
    }

    @Допустим("введено только второе число <b>")
    public void введеноТолькоВтороеЧислоB() {
    }
}
