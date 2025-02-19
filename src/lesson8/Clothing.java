package lesson8;

public class Clothing implements Product {
    private String name;
    private double price;

    // Конструктор для инициализации полей
    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getFinalPrice() {
        return price * 0.85; // 15% скидка
    }

    @Override
    public String toString() {
        return "lesson8.Clothing: " + name + ", Final Price: " + getFinalPrice();
    }
}
