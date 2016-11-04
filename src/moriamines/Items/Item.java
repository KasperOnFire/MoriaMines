package moriamines.Items;

import moriamines.GameControl;

public class Item {

    private String itemDesc;
    protected GameControl gc;
    public boolean equipStatus = false;
    
    public Item (GameControl gac){
        gc  = gac;
    }

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
