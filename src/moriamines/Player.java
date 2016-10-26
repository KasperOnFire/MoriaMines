package moriamines;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    /* CASTING Eksempel.
    
    item temp = inventory[0];
    
    if (temp instanseof sword){
        Sword mySword = (car) temp;
        mySword.getWeaponDmg;
    }
     */
    Room currentRoom = new Room(0);

    ArrayList<Item> inv = new ArrayList();

    private String playerName;
    private int playerHealth;
    private int playerGold;
    private int playerDmg;
    private int playerDef;

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
        getCurrentRoom().setRoomSeen(true);
        currentRoom = currentRoom.getRoomN();
    }

    public void goSouth() {
        getCurrentRoom().setRoomSeen(true);
        currentRoom = currentRoom.getRoomS();
    }

    public void goEast() {
        getCurrentRoom().setRoomSeen(true);
        currentRoom = currentRoom.getRoomE();
    }

    public void goWest() {
        getCurrentRoom().setRoomSeen(true);
        currentRoom = currentRoom.getRoomW();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void playerSetup() {
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        setPlayerName(input.nextLine());
        setPlayerGold(0);
        setPlayerHealth(100);
        setPlayerDef(0);
        setPlayerDmg(1);
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