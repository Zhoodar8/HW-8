package players;

import boss.Boss;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }
    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {
        Random r = new Random();
        int randN = r.nextInt(15) + 10;
        heroes[0].setDamage(heroes[0].getDamage() + randN);




    }
}
