import java.util.Scanner;

public class Calculator { // класс Калькулятор, предназначен для взаимодействия с пользователем
    static String parseExpression(String expression) { // метод обработки арифметического выражения, заданного пользователем
        String a = null, b = null, op = null; // a, b - первый и второй операнды в строковом представлении, op - символ операции
        int op1 = 0, op2 = 0, result = 0; // op1, op2 - первый и второй операнды в численном представлении, result - результат операции
        boolean type = false; // тип цыфр, true - арабские, false - римские
        if (expression.indexOf('+') != -1) { // метод indexOf находит индекс символа-параметра в строке, возвращает -1 если такого символа нет
            op = "+"; // запись в op символа операции
        } else if (expression.indexOf('-') != -1) {
            op = "-";
        } else if (expression.indexOf('*') != -1) {
            op = "*";
        } else if (expression.indexOf('/') != -1) {
            op = "/";
        }
        if (op == null) { // если op равен null, значит в выражении нет символа операции
            throw new NumberFormatException("Неверный формат выражения"); // выброс исключения
        } else { // иначе
            // запись в a части строки выражения от начала и до символа операции
            a = expression.substring(0, expression.indexOf(op));
            // запись в b части строки выражения от символа и до конца строки выражения
            b = expression.substring(expression.indexOf(op) + 1, expression.length());
            if (a.matches("[-+]?\\d+")) { // если a является целым числом
                // запись в операнд1 значения a
                op1 = Integer.parseInt(a);
                if(b.matches("[-+]?\\d+")) // если b является целым числом
                {
                    // запись в операнд2 значения b
                    op2 = Integer.parseInt(b);
                }
                else { // иначе выброс исключения
                    throw new NumberFormatException("Ошибка преобразования цыфры");
                }
                type = true; // тип чисел - арабские
            } else { // иначе
                // запись в операнды результатов преобразования римских цыфр в арабские
                op1 = Converter.fromRoman(a);
                op2 = Converter.fromRoman(b);
                type = false; // тип чисел - римские
            }
            switch (op) { // определение операции
                case "+":
                    result = Operation.add(op1, op2); // выполнение операции
                    break;
                case "-":
                    result = Operation.sub(op1, op2);
                    break;
                case "*":
                    result = Operation.multiply(op1, op2);
                    break;
                case "/":
                    result = Operation.div(op1, op2);
                    break;
            }
        }

        if (type) { // если числа были арабские
            return String.valueOf(result); // возврат результата в строковом представлении
        } else { // если числа были римские
            return Converter.toRoman(result); // возврат результата в представлении в римских цыфрах
        }
    }

    public static void main(String[] args) {
        String expression = ""; // переменная для хранения арифметиского выражения
        Scanner in = new Scanner(System.in); // переменная для ввода с консоли
        try { // начало блока отслеживания исключений
            while (true) { // бесконечный цикл
                System.out.println("Введите выражение (0 - для завершения программы)");
                expression = in.nextLine(); // ввод выражения
                if (expression.equals("0")) { // если 0 - то выход из цикла
                    break;
                } else { // иначе
                    System.out.println(Calculator.parseExpression(expression)); // вывод результата выражения
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()); // вывод исключений
        }
    }
}
