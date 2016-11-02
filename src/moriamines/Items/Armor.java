package moriamines.Items;

public class Armor extends Item {

    private int armorDefense;

    public int getArmorDefense() {
        return armorDefense;
    }

    public void setArmorDefense(int armorDefense) {
        this.armorDefense = armorDefense;
    }

    public Armor(String desc, int def) {
        super(desc);
        armorDefense = def;

    }
}
