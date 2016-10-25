package moriamines;

public class Weapon extends Item {

    public int weaponDmg;

    public Weapon(String desc, int dmg) {
        super(desc);
        weaponDmg = dmg;
    }
}
