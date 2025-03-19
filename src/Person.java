public class Person {

    private String name; // свойства класса доступны только экземпляру класса.
    private int age; // свойства класса доступны только экземпляру класса.

    public Person(String name, int age) { // конструктор класса.
        this.name = name; // this - обозначает явную привязку к свойству класса.
        this.age = age; // this - обозначает явную привязку к свойству класса.
    }

    private int getAge() {  // геттеры и сетеры
        return age;
    }

    private String getName() {
        return name;
    }
}
