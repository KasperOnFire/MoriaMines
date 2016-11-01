package moriamines;

import moriamines.Items.Item;

public class Monster {

    private String monsterDesc;
    private int monsterHealth;
    private int monsterDmg;
    private Item monsterItem;

    public Monster(String desc, int hp, int dmg, Item it) {
        monsterDesc = desc;
        monsterHealth = hp;
        monsterDmg = dmg;
        monsterItem = it;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    public void setMonsterDesc(String monsterDesc) {
        this.monsterDesc = monsterDesc;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public int getMonsterDmg() {
        return monsterDmg;
    }

    public void setMonsterDmg(int monsterDmg) {
        this.monsterDmg = monsterDmg;
    }

    public Item getMonsterItem() {
        return monsterItem;
    }

    public void setMonsterItem(Item monsterItem) {
        this.monsterItem = monsterItem;
    }

}
