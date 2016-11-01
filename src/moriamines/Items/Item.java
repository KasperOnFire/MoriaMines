package moriamines.Items;

import moriamines.GameControl;

public class Item {

    private String itemDesc;
    protected GameControl gc;
    
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

}
