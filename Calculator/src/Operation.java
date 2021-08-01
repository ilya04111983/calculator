
public class Operation // класс Операция, предназначен для вычисления результата арифметических операций

{
    public static int add(int a, int b) { // сложение
        return a + b;
    }
    public static int sub(int a, int b) { // вычитание
        return a - b;
    }
    public static int multiply(int a, int b) { // умножение
        return a * b;
    }
    public static int div(int a, int b) { // деление
        if(b==0) // если второй операнд это 0
        {
            throw new ArithmeticException("Деление на 0"); // выброс исключения об делении на 0
        }
        return a / b;
    }
}
