package moriamines;

import moriamines.Items.Item;
import java.util.ArrayList;
import java.util.Scanner;
import moriamines.Items.Armor;
import moriamines.Items.Potion;
import moriamines.Items.Weapon;

public class Player {

    private GameControl gc;

    public Player(GameControl gac) {
        gc = gac;
    }

    private Room currentRoom = new Room(0);
    private Scanner input = new Scanner(System.in);
    private ArrayList<Item> inv = new ArrayList();

    private String playerName;
    private int playerMaxHealth;
    private int playerCurrentHealth;
    private int playerGold;
    private int playerDmg;
    private int playerDef;
    private int monstersKilled;
    private int playerExp;
    private int playerLvl;

    // Creates the player. Asks for a name, and sets the player values to defaults.
    public void playerSetup() {
        System.out.println("What is your name?");
        setPlayerName(input.nextLine());
        setPlayerGold(0);
        setPlayerMaxHealth(60);
        setPlayerCurrentHealth(60);
        setPlayerDmg(2);
        setPlayerDef(0);
        setPlayerExp(0);
        setPlayerLvl(1);
        inv.add(new Weapon("wooden sword", 3));
        inv.add(new Armor("cotton shirt", 1));
    }

    public void playerStats() {
        System.out.println("Player Stats:");
        System.out.println("Health: " + getPlayerCurrentHealth() + "/" + getPlayerMaxHealth());
        System.out.println("Damage: " + (getPlayerDmg() + getPlayerLvl()));
        System.out.println("Armor: " + getPlayerDef());
        System.out.println("Gold: " + getPlayerGold());
        System.out.println("Inventory: " + inv.size() + " items");
        System.out.println("Level: " + getPlayerLvl());
        System.out.println("Exp: " + getPlayerExp() + "/100");
    }

    public void levelUp() {
        playerLvl++;
        System.out.println("You are now level " + playerLvl + "!");
        System.out.println("Max HP increased by 10!");
        setPlayerMaxHealth(getPlayerMaxHealth() + 10);
        setPlayerCurrentHealth(getPlayerCurrentHealth() + 10);
        System.out.println("Your Health is now " + getPlayerCurrentHealth() + "/" + getPlayerMaxHealth());
    }

    // equips the item that matches the description the usre puts in. v2 - its dynamic. works for every item, no matter the name.
    public void equipCommand() {
        System.out.println("Inventory:");
        for (Item i : getInv()) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to equip?");
        String item = input.nextLine().toLowerCase();
        int counter = 0;
        if (item != "quit") {
            for (Item j : inv) {
                if (item.equals(j.getItemDesc())) {
                    if (j instanceof Weapon && !j.isEquipStatus()) {
                        Weapon mySword = (Weapon) j;
                        setPlayerDmg(mySword.getWeaponDmg());
                        System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + (getPlayerDmg() + getPlayerLvl()));
                        System.out.println("");
                        j.setEquipStatus(true);
                        break;
                    } else if (j instanceof Armor && !j.isEquipStatus()) {
                        Armor myArmor = (Armor) j;
                        setPlayerDef(getPlayerDef() + (myArmor.getArmorDefense()));
                        System.out.println("You equip the " + myArmor.getItemDesc() + ". Your defense is now " + getPlayerDef());
                        System.out.println("");
                        j.setEquipStatus(true);
                        break;
                    } else if (item.equals(j.getItemDesc()) && j.isEquipStatus()) {
                        System.out.println("You already equipped that item!");
                    }
                } else {
                    counter++;
                    if (counter == inv.size()) {
                        System.out.println("You don't have that item!");
                    }
                }
            }

        }

    }

    // used for eating/drinking healing potions. Works the same way as equipCommand(); also Dynamic
    public void useCommand() {
        int counter = 0;
        System.out.println("Inventory:");
        for (Item i : inv) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to use?");
        String use = input.nextLine().toLowerCase();
        if (use != "quit") {
            if (getPlayerCurrentHealth() == 100) {
                System.out.println("You are already at full health!");
            } else if (use != "quit") {
                for (Item j : inv) {
                    if (use.equals(j.getItemDesc())) {
                        if (j instanceof Potion) {
                            Potion myPotion = (Potion) j;
                            myPotion.restoreHealth(myPotion, this);
                            break;
                        }
                    }
                }
            } else {
                counter++;
                if (counter == inv.size()) {
                    System.out.println("You don't have that item!");
                }

            }
        }
    }

    /*The following 4 functions is what defines movement in the game
    .
    it sets the users room to the one north /south and so on.
     */
    public void goNorth() {
        if (currentRoom.getRoomN() != null) {
            getCurrentRoom().setRoomSeen(true);
            currentRoom = currentRoom.getRoomN();
            currentRoom.enterRoom(this);
        } else {
            System.out.println("The stone wall does not allow for passage this way through.");
        }
    }

    public void goSouth() {
        if (currentRoom.getRoomS() != null) {
            getCurrentRoom().setRoomSeen(true);
            currentRoom = currentRoom.getRoomS();
            currentRoom.enterRoom(this);
        } else {
            System.out.println("There is only a rock wall here.");
        }
    }

    public void goEast() {
        if (currentRoom.getRoomE() != null) {
            getCurrentRoom().setRoomSeen(true);
            currentRoom = currentRoom.getRoomE();
            currentRoom.enterRoom(this);
        } else {
            System.out.println("The stone wall does not allow for passage this way through.");
        }
    }

    public void goWest() {
        if (currentRoom.getRoomW() != null) {
            getCurrentRoom().setRoomSeen(true);
            currentRoom = currentRoom.getRoomW();
            currentRoom.enterRoom(this);
        } else {
            System.out.println("The stone wall does not allow for passage this way through.");
        }
    }

    public void inventory() {
        System.out.println("Inventory:");
        for (Item i : inv) {
            System.out.println(i.getItemDesc());
        }
    }

    public void equipped() {
        System.out.println("Equipped items:");
        for (Item i : inv) {
            if (i.isEquipStatus()) {
                System.out.println(i.getItemDesc());
            }
        }
    }

    public int getPlayerDmg() {
        return playerDmg;
    }

    public void setPlayerDmg(int playerDmg) {
        this.playerDmg = playerDmg;
    }

    public int getPlayerDef() {
        return playerDef;
    }

    public void setPlayerDef(int playerDef) {
        this.playerDef = playerDef;
    }

    public ArrayList<Item> getInv() {
        return inv;
    }

    public void setInv(ArrayList<Item> inv) {
        this.inv = inv;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public void addToInv(Item i) {
        inv.add(i);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerCurrentHealth() {
        return playerCurrentHealth;
    }

    public void setPlayerCurrentHealth(int playerCurrentHealth) {
        this.playerCurrentHealth = playerCurrentHealth;
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(int playerGold) {
        this.playerGold = playerGold;
    }

    public void addPlayerGold(int pold) {
        playerGold = playerGold + pold;
    }

    public int getMonstersKilled() {
        return monstersKilled;
    }

    public void setMonstersKilled(int monstersKilled) {
        this.monstersKilled = monstersKilled;
    }

    public int getPlayerExp() {
        return playerExp;
    }

    public void setPlayerExp(int playerExp) {
        this.playerExp = playerExp;
    }

    public int getPlayerLvl() {
        return playerLvl;
    }

    public void setPlayerLvl(int playerLvl) {
        this.playerLvl = playerLvl;
    }

}
