package moriamines.Items;

import moriamines.GameControl;

public class Item {

    private String itemDesc;
    public boolean equipStatus = false;

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Item(String desc) {
        itemDesc = desc;
    }

    public boolean isEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(boolean equipStatus) {
        this.equipStatus = equipStatus;
    }

}
