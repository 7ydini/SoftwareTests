package Interfaces;

public interface CalculatorView {

    /**
     * Отображает результат вычисления
     */
    void printResult(double result);

    /**
     * Показывает ошибку, например деление на 0, пустые аргументы и прочее
     */
    void displayError(String message);

    /**
     * Возвращает значение, введенное в поле первого аргументы
     */
    double getFirstArgument();

    /**
     * Возвращает значение, введенное в поле второго аргументы
     */
    double getSecondArgument();
}
