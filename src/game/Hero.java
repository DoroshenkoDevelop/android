package game;

public abstract class Hero {
    private String name;
    private int hp;
    private Armor armor;
    private Weapon weapon;

    Hero(String name, int hp, Armor armor, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.weapon = weapon;
    }

    public int attack(int diceResult) {

        System.out.printf("Hero", name, diceResult);
        return weapon.getDamage() + diceResult;

    }

    public void getDamage(int damage) {
        int finalDamage = armor.reduceDamage(damage);
        hp -= finalDamage;
        System.out.printf("Hero lost hp", name,finalDamage,hp);
    }

    public boolean isLife() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }
}
