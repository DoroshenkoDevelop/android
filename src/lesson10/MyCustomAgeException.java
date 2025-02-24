package lesson10;

public class MyCustomAgeException extends Exception {
    private int age;

    MyCustomAgeException(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        System.out.println(age + " less than 18");
        return "";
    }
}
