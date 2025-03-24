public class Electronics implements Product {
    private String name;
    private double price;

    // Конструктор
    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // метод getFinalPrice
    @Override
    public double getFinalPrice() {
        return price * 0.9; // 10% скидка
    }

    @Override
    public String toString() {
        return "Electronics: " + name + ", Final Price: " + getFinalPrice();
    }
}
