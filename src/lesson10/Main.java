package lesson10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
         int first = 0;
         int second = 0;
         String str = "";
         System.out.println(division(first,second));
         System.out.println(arrayBoundaries(first));
         nullPointer();
         numberFormat(str);
         nested(first,second);
         myFinally(str);
         emptyString();
         checkAge();
        try {
            fileFormat();
        } catch (FileNotFoundException f){
            System.out.println("Error " + f.getMessage());
        }
    }

    /*homework*/
    /*Задача 1: Деление на ноль (ArithmeticException)
    Задача: Написать программу, которая делит одно число на другое. Обработать
    исключение, если происходит деление на ноль.*/

    public static int division(int first, int second) {
           try {
            System.out.println("Enter a number: ");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            System.out.println("Enter a number: ");
            int s = scanner.nextInt();
            first = i;
            second = s;
            System.out.println("Equally: " + first / second);
            return first / second;
        } catch (ArithmeticException a) {
            a.printStackTrace();
        }
        return 0;
    }

    /*Задача 2: Выход за границы массива (ArrayIndexOutOfBoundsException)
    Задача: Запросить у пользователя индекс массива и вывести элемент. Обработать
    ситуацию выхода за границы массива*/

    public static int arrayBoundaries(int first) {
        try{
            int[] array = {1,2};
            System.out.println("Enter the array index: ");
            Scanner index = new Scanner(System.in);
            int number = index.nextInt();
            int element = array[number];
            System.out.println("Done");
        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Error " + a.getMessage());
        }
        return 0;
    }

    /*Задача 3: Обработка NullPointerException
    Задача: Попробовать вызвать метод у null-объекта и обработать NullPointerException.*/

    public static void nullPointer() {
        try {
            String nullStr = null;
            int lenghtStr = nullStr.length();
        } catch (NullPointerException n){
            System.out.println("Error " + n.getMessage());
        }
    }

    /*Задача 4: Обработка NumberFormatException
    Задача: Преобразовать строку в число и обработать ситуацию, если ввод
    некорректный.*/

    public static void numberFormat(String first) {
        System.out.println("Enter string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try {
            int number = Integer.parseInt(str);
            System.out.println("Done");
        } catch (NumberFormatException n) {
            System.out.println("Error " + n.getMessage());
        }

    }
    /*Задача 5: Исключение при работе с файлами (FileNotFoundException)
    Задача: Открыть несуществующий файл и обработать ошибку.*/

    public static void fileFormat() throws FileNotFoundException {
        File file = new File("file.txt");
        FileReader fileReader = new FileReader(file);
    }

    /*Задача 6: Вложенные try-catch
    Задача: Обработать исключения на разных уровнях (деление на ноль и выход за
            границы массива) */
    public static void nested(int first, int second ) {
        try {
            int[] array = {1,2};
            int number = 3;
            int element = array[number];
            try {
                int res = first / second;
                System.out.println("Equally: " + first / second);

            }
            catch (ArrayIndexOutOfBoundsException a) {
                System.out.println("Error " + a.getMessage());
            }
        }
        catch (ArithmeticException a) {
            System.out.println("Error " + a.getMessage());
        }
    }

    /*Задача 7: Кастомное исключение (CustomException)
    Задача: Создать свое исключение и бросить его, если число меньше 0*/
    public static int myException(int ex) {
        int num= -1;
        try {
            if (num < 0) {
                throw new MyCustomException("Error");
            }
            System.out.println("Число корректно: " + num);
        } catch (MyCustomException m){

        }
    return -6;
    }

    /*Задача 8: Использование finally для закрытия ресурсов
    Задача: Открыть файл и закрыть Scanner, используя finally*/
    public static int myFinally(String first) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter");
            String nameFile = scanner.nextLine();
            File file = new File(nameFile);
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error file " + e.getMessage());
        }
        finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner закрыт.");
            }
        }
        return -6;
    }
   /* Homework*/

    /*Задача 1:Деление с обработкой исключения
    Задача: Написать программу, которая делит два числа, введенных пользователем*/
    public static int divisionSecondTask(int first, int second) {
        try {
            System.out.println("Enter a number: ");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            System.out.println("Enter a number: ");
            int s = scanner.nextInt();
            first = i;
            second = s;
            System.out.println("Equally: " + first / second);
            return first / second;
        } catch (ArithmeticException a) {
            a.printStackTrace();
        }
        return 0;
    }


    /* Задача 2: Проверка возраста (кастомное исключение)
 Задача: Попросить пользователя ввести возраст. Если возраст < 18, выбросить
исключение*/
    public static void checkAge() {
        System.out.println("Enter your age: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int age = scanner.nextInt();
            if (age < 18) {
                throw new MyCustomAgeException(age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*Задача 3: Обработка пустой строки
    Задача: Запросить у пользователя строку и проверить, что она не пустая.*/
    public static void emptyString(){
        System.out.println("Enter any text: ");
        Scanner scanner = new Scanner(System.in);
        try {
            String str = scanner.nextLine();
            if (str.trim().isEmpty()) {
                throw new MyCustomException(str);
            }
        } catch (MyCustomException m) {
            m.printStackTrace();
        }
    }
    /* Homework*/
}

