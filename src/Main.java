import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        points();
        helloWorld();
        rectangle();
        sumOfNumbers();
        userPoint();
        arrayMaxMin();
        evenNotEven();
        arrayBack();
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

    /*Lesson-5*/
    public static void arrayInt() {
        int[] first =  new int[10];
        int[] second =  new int[] {1, 2, 3, 4};
    }


    public static void lessonFive(int[] array) {
        int[] secondArray = new int[array.length];
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Сортировка: " + Arrays.toString(array));
        int index = Arrays.binarySearch(array, 2);
        System.out.println("Результат: " + index);
        System.arraycopy(array, 0, secondArray, 0, secondArray.length);
        System.out.println("Копирование: " + Arrays.toString(secondArray));
    }

    public static void userPoint() {
        Scanner scanner = new Scanner(System.in);
        int[] point = new int[5];
        int sum = 0;
        for (int i = 0; i < point.length; i++) {
            System.out.print("Введите число: ");
            int input = scanner.nextInt();
            sum += input;
            point[i] = input;
        }
        System.out.println(Arrays.toString(point));
        System.out.println("Сумма чисел: " + sum);
    }
    /*Lesson-5*/

    /*HomeWork-5*/
    /*1) Напишите программу, которая находит и выводит максимальное и минимальное
    значение в массиве целых чисел. Также вычислите индекс этих элементов.*/
    public static void arrayMaxMin() {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, -1};
         int arrayMax = 0;
         int arrayMin = 0;
         int minIndex = 0;
         int maxIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < arrayMin) {
                arrayMin = array[i];
                minIndex = i;
            }
            if (array[i] > arrayMax) {
                arrayMax = array[i];
                maxIndex = i;
            }
        }
        System.out.println("Число макс: " + arrayMax + ", индекс: " + minIndex);
        System.out.println("Число мин: " + arrayMin + ", индекс: " + maxIndex);
    }
    /*2) Напишите программу, которая принимает массив целых чисел и подсчитывает,
    сколько четных и сколько нечетных чисел в нем содержится.*/
    public static void evenNotEven() {
       // Scanner scanner = new Scanner(System.in);
        int[] arrays = new int[] {1, 2, 3, 4, 5};
        int even = 0;
        int notEven = 0;
        for (int array : arrays) {
            if (array % 2 == 0) {
                even++;
            }
            else {
                notEven++;
            }
        }
        System.out.println("Четных: " + even);
        System.out.println("Не четных: " + notEven);
    }
    /*3) Напишите программу, которая принимает массив целых чисел и изменяет его порядок
    на обратный. Выведите результат после изменения порядка.*/
    public static void arrayBack() {
        int[] arrayBack = new int[] {1, 2, 3, 4, 5};
        int[] newArray = new int[arrayBack.length];
        for (int i = 0; i < arrayBack.length; i++) {
            newArray[arrayBack.length - 1 - i] = arrayBack[i];
        }
        System.out.println("Обратный порядок: " + Arrays.toString(newArray));
    }
    /*HomeWork-5*/
}
