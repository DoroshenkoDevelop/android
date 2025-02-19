/*Задача 1: Работа с классами и методами*/
/*HomeWork-7*/
public class Book {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("1984", "George Orwell", 1950);

        System.out.println(book1.getInfo());
        System.out.println(book2.getInfo());

        System.out.println("Книги равны? " + book1.equals(book2));
    }

    /*Задача 1: Работа с классами и методами*/

    private String title;
    private String author;
    private int year;

    // Конструктор
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Вывод
    public String getInfo() {
        return "Книга: " + title + ", Автор: " + author + ", Год издания: " + year;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

}
