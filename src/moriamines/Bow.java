package moriamines;

public class Bow extends Weapon {

    public int weaponRange;

    public Bow(String desc, int dmg, int range) {
        super(desc, dmg);
        weaponRange = range;

    }

}
