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
    private int playerHealth;
    private int playerGold;
    private int playerDmg;
    private int playerDef;
    private int monstersKilled;

    // equips the item that matches the description the usre puts in.
    public void equipCommand() {
        System.out.println("Inventory:");
        for (Item i : getInv()) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to equip?");
        String item = input.nextLine().toLowerCase();
        if (item != "quit") {
            for (Item j : inv) {
                if (item.equals(j.getItemDesc())) {
                    if (j instanceof Weapon && !j.isEquipStatus()) {
                        Weapon mySword = (Weapon) j;
                        setPlayerDmg(mySword.getWeaponDmg());
                        System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        j.setEquipStatus(true);
                        break;
                    } else if (j instanceof Armor && !j.isEquipStatus()) {
                        Armor myArmor = (Armor) j;
                        setPlayerDef(getPlayerDef() + (myArmor.getArmorDefense()));
                        System.out.println("You equip the " + myArmor.getItemDesc() + ". Your defense is now " + getPlayerDef());
                        j.setEquipStatus(true);
                        break;
                    }
                } else if (j.isEquipStatus()) {
                    System.out.println("You already equipped that item!");
                } else {
                    System.out.println("You dont have that item!");
                }

            }
        }
    }

    // used for eating/drinking healing potions. Works the same way as equipCommand();
    public void useCommand() {
        System.out.println("Inventory:");
        for (Item i : inv) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to use?");
        String use = input.nextLine().toLowerCase();
        if (use != "quit") {
            if (getPlayerHealth() == 100) {
                System.out.println("You are already at full health!");
            } else {
                for (Item j : inv) {
                    if (use == j.getItemDesc()) {
                        if (j instanceof Potion) {
                            Potion myPotion = (Potion) j;
                            myPotion.getRestoreHealth();
                            break;
                        }
                    } else {
                        System.out.println("You dont have that item!");
                    }

                }
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

    public void addToInv(Item i) {
        inv.add(i);
    }

    /*The following 4 functions is what defines movement in the game.
    it sets the users room to the one north/south and so on of it.
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
            System.out.println("The stone wall does not allow for passage this way through.");
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    // Creates the player. Asks for a name, and sets the player values to defaults.
    public void playerSetup() {
        System.out.println("What is your name?");
        setPlayerName(input.nextLine());
        setPlayerGold(0);
        setPlayerHealth(100);
        setPlayerDmg(2);
        setPlayerDef(0);
        inv.add(new Weapon("wooden sword", 3));
        inv.add(new Armor("cotton shirt", 1));
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(int playerGold) {
        this.playerGold = playerGold;
    }

    public int getMonstersKilled() {
        return monstersKilled;
    }

    public void setMonstersKilled(int monstersKilled) {
        this.monstersKilled = monstersKilled;
    }

}
