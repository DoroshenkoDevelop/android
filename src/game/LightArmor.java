package game;

import java.util.Random;

public class LightArmor extends Armor {
    private Random rand;

    public LightArmor(int armorRating, int durobility) {
        super(armorRating, durobility);
        rand = new Random();
    }

    @Override
    public int reduceDamage(int damage) {
        return super.reduceDamage(damage) - rand.nextInt(0, 2);
    }
}
