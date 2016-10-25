package moriamines;

public class Chest extends Armor {

    private String armorType;

    public Chest(String Desc, int def, String type) {
        super(Desc, def);
        armorType = type;
    }

}