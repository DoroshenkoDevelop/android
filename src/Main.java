import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        points();
        helloWorld();
        rectangle();
        sumOfNumbers();
    }
    /*Вывод имени пользователя*/
    public static void helloWorld() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String user = myScanner.nextLine();
        System.out.println("Hello " + user);
    }

    /*Напишите программу, которая выводит таблицу умножения для числа N, где N вводится с клавиатуры.*/
    public static void sumOfNumbers () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int num = scanner.nextInt();
        int secNum = 1;
        while ((secNum) <= (num+1)){
            System.out.println(num + " * " + secNum + " = " + num*secNum);
            secNum++;
        }
    }

    /*Напишите программу, которая принимает на вход баллы студента и выводит оценку по шкале.*/
    public static void points() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Points: ");
        int num = scanner.nextInt();
        if(num >=90){
            System.out.println("Point : A");
        } else if (num >= 75){
            System.out.println("Point : B");
        } else if (num >= 50){
            System.out.println("Point : С");
        } else if (num >= 30){
            System.out.println("Point : D");
        } else if (num >= 0){
            System.out.println("Point : F");
        }
    }

     /*Напишите программу, которая вычисляет периметр и площадь прямоугольника. Длина и ширина
    прямоугольника вводятся с клавиатуры.*/
    public static void rectangle() {

        Scanner in = new Scanner(System.in); // создаёт новый объект класса Scanner для чтения данных из консоли в Java.
        System.out.print("a = "); // Он выводит текст на консоль без добавления символа новой строки в конце.
        int a = in.nextInt(); // метод класса Scanner, который возвращает введённое с клавиатуры целочисленное значение.
        System.out.print("b = a + 10"); // Он выводит текст на консоль без добавления символа новой строки в конце.
        int b = a + 10;
        int p = a * 2 + b * 2;
        int s = a * b;
        System.out.println("P = " + p + " см"); // это метод для вывода текста или значения переменной на консоль в языке программирования Java с последующим переводом строки.
        System.out.println("S = " + s + " см^2"); // это метод для вывода текста или значения переменной на консоль в языке программирования Java с последующим переводом строки.

    }

    /*Напишите программу, которая принимает строку и переставляет слова в обратном порядке, используя только методы String и StringBuilder*/
    public static void str(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод строки
        System.out.print("Введите строку: ");
        String input = scanner.nextLine().trim();

        // Получаем строку с перевернутыми словами
        String reversed = reverseWords(input);

        // Вывод результата
        System.out.println("Строка с обратным порядком слов: " + reversed);
    }

    // Метод для переворота слов в строке
    public static String reverseWords(String input) {
        StringBuilder result = new StringBuilder();
        int end = input.length(); // Начинаем с конца строки

        // Проходим по строке с конца к началу
        for (int i = input.length() - 1; i >= 0; i--) {
            // Если находим пробел, то добавляем слово
            if (input.charAt(i) == ' ' || i == 0) {
                int start = (i == 0) ? i : i + 1; // Учитываем первое слово
                result.append(input.substring(start, end)); // Добавляем слово
                if (i > 0) result.append(" "); // Добавляем пробел между словами
                end = i; // Обновляем конец для следующего слова
            }
        }
        return result.toString().trim(); // Убираем лишние пробелы
    }
}
