package moriamines;

import moriamines.Items.Item;

public class Monster {

    private String monsterDesc;
    private int monsterHealth;
    private int monsterDmg;
    private Item monsterItem;
    private int monsterGold = 0;
    private int monsterExp;

    public Monster(String desc, int hp, int dmg, Item it, int gold) {
        monsterDesc = desc;
        monsterHealth = hp;
        monsterDmg = dmg;
        monsterItem = it;
        monsterGold = gold;
        monsterExp = hp;
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

    public int getMonsterGold() {
        return monsterGold;
    }

    public void setMonsterGold(int monsterGold) {
        this.monsterGold = monsterGold;
    }

    public int getMonsterExp() {
        return monsterExp;
    }

    public void setMonsterExp(int monsterExp) {
        this.monsterExp = monsterExp;
    }
}
