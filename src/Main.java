import game.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Hero player1 = chooseYouHero(random);
        Dice dice1 = new Dice(random);
        Dice dice2 = new Dice(random);
    }

    public static Hero chooseYouHero(Random rand) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя персонажа:");
        String nameHero = scanner.nextLine();
        System.out.println("Введите число от 1 до 3, где 1 - Паладин, 2 - Разбойник, 3 - Лучник");
        int result = scanner.nextInt();
        switch (result) {
            case 1 :
                return new Paladin("Paladin", 40, new HardArmor(20, 5), new Sword(5, rand));
            case 2 :
                return new Rogue("Rog", 30, new MiddelArmor(10, 5), new Dagger(10, rand));
            case 3 :
                return new Archer("Archer", 20, new LightArmor(5, 10), new Arch(20, rand));
            default:
                return null;
        }

    }

}


