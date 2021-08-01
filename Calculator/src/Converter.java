import java.util.HashMap;
import java.util.TreeMap;

public class Converter { // класс Конвертор, предназначен для конвертации чисел из десятеричных в римские и наоборот

    //  TreeMap сортирует ключи в естественном порядке. В этом решении важную роль играет метод TreeMap floorKey,
    //  так как вы можете удобно искать самый большой ключ, меньший или равный данному ключу
    //  Если есть точное совпадение, вы просто возвращаете связанный римский символ, иначе вы просто соединяете римский символ,
    //  связанный с наибольшим ключом, меньшим, чем заданное число, с возвращаемым, рекурсивно вызывая функцию,
    //  используя текущее число, вычитая предыдущий найденный самый большой ключ
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    // HashMap представляет отображение или иначе говоря словарь, где каждый элемент представляет пару "ключ-значение".
    // При этом все ключи уникальные в рамках объекта HashMap
    // Такие коллекции облегчают поиск элемента, если нам известен ключ - уникальный идентификатор объекта
    // Ключами у нас будут римские цыфры от 1 до 10
    private final static HashMap<String, Integer> numbers = new HashMap<String, Integer>();
    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        numbers.put("I", 1);
        numbers.put("II", 2);
        numbers.put("III", 3);
        numbers.put("IV", 4);
        numbers.put("V", 5);
        numbers.put("VI", 6);
        numbers.put("VII", 7);
        numbers.put("VIII", 8);
        numbers.put("IX", 9);
        numbers.put("X", 10);
    }
    public static String toRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }
    public static int fromRoman(String number){
        if(numbers.containsKey(number)) { // если словарь имеет римскую цыфру со значнием number
            return numbers.get(number); // возвращаем значение этой цыфры в десятеричной системе из словаря
        }
        else // иначе
        {
            throw new NumberFormatException("Неверный формат цыфры для преобразования."); // выбром исключния об неверном формате цыфры
        }
    }
}
