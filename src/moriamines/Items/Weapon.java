package moriamines.Items;

public class Weapon extends Item {

    private int weaponDmg;

    public int getWeaponDmg() {
        return weaponDmg;
    }

    public void setWeaponDmg(int weaponDmg) {
        this.weaponDmg = weaponDmg;
    }

    public Weapon(String desc, int dmg) {
        super(desc);
        weaponDmg = dmg;
    }
}
