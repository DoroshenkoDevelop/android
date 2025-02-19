package lesson8;

public class Author {
    private String name;
    private int birthYear;

    // Конструктор для инициализации полей
    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    // Геттеры для полей
    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    // Переопределение
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author author = (Author) obj;
        return name.equals(author.name) && birthYear == author.birthYear;
    }



}
