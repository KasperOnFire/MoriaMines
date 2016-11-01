package moriamines;

import moriamines.Items.Item;
import java.util.ArrayList;
import java.util.Scanner;
import moriamines.Items.Potion;
import moriamines.Items.Sword;

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

    public void equipCommand() {
        System.out.println("Inventory:");
        for (Item i : getInv()) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to equip?");
        String item = input.nextLine().toLowerCase();
        switch (item) {
            case "wooden sword":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("wooden sword")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
            case "steel sword":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("steel sword")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
            case "rusty pickaxe":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("rusty pickaxe")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
            case "broken bottle":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("broken bottle")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
            case "dwarf femur":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("dwarf femur")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
            case "ancient dwarf war axe":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("ancient dwarf war axe")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
        }
    }

    public void useCommand() {
        System.out.println("Inventory:");
        for (Item i : getInv()) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to use?");
        String use = input.nextLine().toLowerCase();
        switch (use) {
            case "health potion":
                for (Item i : getInv()) {
                    if (getPlayerHealth() == 100) {
                        System.out.println("You are already at full health!");
                    } else if ((i.getItemDesc().toLowerCase()).equals("health potion")) {
                        if (i instanceof Potion) {
                            Potion myPotion = (Potion) i;
                            myPotion.getRestoreHealth();
                        }
                    }
                    break;
                }
            case "fried chicken":
                for (Item i : getInv()) {
                    if (getPlayerHealth() == 100) {
                        System.out.println("You are already at full health!");
                    } else if ((i.getItemDesc().toLowerCase()).equals("fried chicken")) {
                        if (i instanceof Potion) {
                            Potion myPotion = (Potion) i;
                            myPotion.getRestoreHealth();
                        }
                    }
                    break;
                }
            case "red mushroom":
                for (Item i : getInv()) {
                    if (getPlayerHealth() == 100) {
                        System.out.println("You are already at full health!");

                    } else if ((i.getItemDesc().toLowerCase()).equals("red mushroom")) {
                        if (i instanceof Potion) {
                            Potion myPotion = (Potion) i;
                            myPotion.getRestoreHealth();

                        }
                    }
                }
                break;
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

    public void playerSetup() {
        System.out.println("What is your name?");
        setPlayerName(input.nextLine());
        setPlayerGold(0);
        setPlayerHealth(100);
        setPlayerDmg(2);
        setPlayerDef(0);
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

}
