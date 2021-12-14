# language: ru

Функционал: Калькулятор сумма 2х чисел
  Структура сценария: sum a + b
    Допустим введены два числа <a> и <b>
    Если сложить
    То получим <result>
    Примеры:
            | a    | b    | result  |
            | 3.8  | 2.4  | 6.2        |
            | 0    | 2.1  | 2.1        |
            | 3.2  | 0    | 3.2        |
            | 0    | 0    | 0          |
            | -3.2 | 2.1  | -1.1       |
            | 2.1  | -3.2 | -1.1       |
            | -2.1 | -3.2 | -5.3       |
            | -2.1 | 0    | -2.1       |
            | 0    | -3.2 | -3.2       |
            | 3.2  | -3.2 | 0          |


  Структура сценария: Первое не введено
    Допустим введено только первое число <a>
    Если сложить
    То произойдет <error>
    Примеры:
            | a    | error                   |
            | 3.2  | Второй аргумент пустой! |
            | -3.2 | Второй аргумент пустой! |
            | 0    | Второй аргумент пустой! |


  Структура сценария: Второе не введено
    Допустим введено только второе число <b>
    Если сложить
    То произойдет <error>
    Примеры:
            | b    | error                   |
            | 3.2  | Первый аргумент пустой! |
            | -3.2 | Первый аргумент пустой! |
            | 0    | Первый аргумент пустой! |