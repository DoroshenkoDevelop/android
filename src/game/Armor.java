package game;

public abstract class Armor {
    private int armorRating;
    private int durobility;

    Armor(int armorRating, int durobility) {
        this.armorRating = armorRating;
        this.durobility = durobility;
    }

    public int reduceDamage(int damage) {
        if (durobility <= 0) return damage;
        durobility -= 1;
        return Math.max(damage - armorRating, 0);
    }
}
