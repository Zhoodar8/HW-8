package players;

import boss.Boss;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void useSuperPower(Hero[] heroes, Boss boss) {
        int a = 2 + (int) ( Math.random() * 3 );
        heroes[1].setDamage(heroes[1].getDamage() * a);

    }
}