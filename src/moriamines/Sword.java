package moriamines;

public class Sword extends Weapon {

    private String weaponType;

    public Sword(String desc, int dmg, String type) {
        super(desc, dmg);
        weaponType = type;

    }
}