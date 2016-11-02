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

    //Makes the player equip the chosen sword/armor. Adds the damage or defense to the players.
    public void equipCommand() {
        System.out.println("Inventory:");
        for (Item i : getInv()) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to equip?");
        String item = input.nextLine().toLowerCase();
        switch (item) {
            case "quit":
            case "exit":
            case "cancel":
                break;
            case "wooden sword":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("wooden sword")) {
                        if (i instanceof Weapon) {
                            Weapon mySword = (Weapon) i;
                            setPlayerDmg(mySword.getWeaponDmg());
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
                break;
            case "steel sword":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("steel sword")) {
                        if (i instanceof Weapon) {
                            Weapon mySword = (Weapon) i;
                            setPlayerDmg(mySword.getWeaponDmg());
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
                break;
            case "rusty pickaxe":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("rusty pickaxe")) {
                        if (i instanceof Weapon) {
                            Weapon mySword = (Weapon) i;
                            setPlayerDmg(mySword.getWeaponDmg());
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
                break;
            case "broken bottle":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("broken bottle")) {
                        if (i instanceof Weapon) {
                            Weapon mySword = (Weapon) i;
                            setPlayerDmg(mySword.getWeaponDmg());
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
                break;
            case "dwarf femur":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("dwarf femur")) {
                        if (i instanceof Weapon) {
                            Weapon mySword = (Weapon) i;
                            setPlayerDmg(mySword.getWeaponDmg());
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
                break;
            case "ancient dwarf war axe":
                for (Item i : getInv()) {
                    if (i.getItemDesc().toLowerCase().equals("ancient dwarf war axe")) {
                        if (i instanceof Weapon) {
                            Weapon mySword = (Weapon) i;
                            setPlayerDmg(mySword.getWeaponDmg());
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + getPlayerDmg());
                        }
                    }
                }
                break;
            case "wooden helmet":
                for (Item i : inv) {
                    if (i.getItemDesc().toLowerCase().equals("wooden helmet")) {
                        if (i instanceof Armor) {
                            Armor myArmor = (Armor) i;
                            setPlayerDef(getPlayerDef() + (myArmor.getArmorDefense()));
                            System.out.println("You equip the " + myArmor.getItemDesc() + ". Your defense is now " + getPlayerDef());
                        }
                    }
                }
                break;
            default:
                System.out.println("You dont have that item! \n");
                equipCommand();
        }
    }

    // used for eating/drinking healing potions. Works the same way as equipCommand();
    public void useCommand() {
        System.out.println("Inventory:");
        for (Item i : getInv()) {
            System.out.println(i.getItemDesc());
        }
        System.out.println("What item would you like to use?");
        String use = input.nextLine().toLowerCase();
        switch (use) {
            case "quit":
            case "exit":
            case "cancel":
                break;
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
                }
                break;
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
                }
                break;
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
            default:
                System.out.println("You dont have that item!");
                useCommand();
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
