package game;

import boss.Boss;
import players.*;

public class RpgGame {

    public static void startGame() {
        Boss boss = new Boss(1000, 30);
        Hero[] heroes = getHeroesArray();
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        heroesApplySuperPower(heroes, boss);
        showStatistics(heroes, boss);
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDied;
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            if(heroes[i].getHealth()< 0){
                heroes[i].setHealth(0);
            } }
    }
    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                if(boss.getHealth()<0){
                    boss.setHealth(0);
                }
            }
        }
    }

    private static Hero[] getHeroesArray() {
        Warrior warrior = new Warrior(100, 10);
        Berserk berserk = new Berserk(100, 10);
        Magical magical = new Magical(100, 10);
        Medical medical = new Medical(100, 0);

        Hero[] heroes = new Hero[4];
        heroes[0] = warrior;
        heroes[1] = berserk;
        heroes[2] = magical;
        heroes[3] = medical;
        return heroes;
    }



    private static void heroesApplySuperPower(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].useSuperPower(heroes, boss);
            }

        }
    }



    private static void showStatistics(Hero[] heroes, Boss boss) {
        System.out.println("_____________");
        System.out.println("Boss health - " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero "
                    + heroes[i].getClass().getSimpleName() +
                    " - " + heroes[i].getHealth());
        }
        System.out.println("_____________");
    }

}
