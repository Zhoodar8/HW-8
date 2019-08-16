package players;

import boss.Boss;

import java.util.Random;

public class Magical extends Hero {
    public Magical(int health, int damage) {
        super(health, damage, Ability.BOOST);
    }

    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {
        Random r = new Random();
        int raundN = r.nextInt(5)  + 2;
        for (int i = 0; i < 3; i++){
            heroes[i].setDamage(heroes[i].getDamage() + raundN);




        }

    }
}