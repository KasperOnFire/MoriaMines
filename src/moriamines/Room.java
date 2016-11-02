package moriamines;

import moriamines.Items.Item;

public class Room {

    private String roomDesc = "";
    private String roomDescSeen = "";
    private int roomGold = 0;
    private Item roomItem;
    private boolean roomExit = false;
    private boolean roomSeen = false;
    private Monster roomMonster = null;

    private Room RoomN = null;
    private Room RoomS = null;
    private Room RoomE = null;
    private Room RoomW = null;

    public Room(int Gold) {
        roomGold = Gold;
    }
    
    /*
    This method runs when you enter a room, and looks if there is a monster object in the room.
    If there is, combat is started.
    */

    public void enterRoom(Player pl) {
        if (roomMonster != null) {
            printRoomDesc();
            Combat c = new Combat(pl, roomMonster);
            c.startCombat();
            System.out.println(roomDescSeen);
        } else {
            printRoomDesc();
        }
    }

    //Prints the correct room description depending on if you have seen the room before or not.
    public void printRoomDesc() {
        if (roomSeen) {
            System.out.println(getRoomDescSeen());
        } else {
            System.out.println(getRoomDesc());
        }
    }

    public void setRoomSeen(boolean roomSeen) {
        this.roomSeen = roomSeen;
    }

    public boolean isRoomSeen() {
        return roomSeen;
    }

    public boolean isRoomExit() {
        return roomExit;
    }

    public void setRoomExit(boolean roomExit) {
        this.roomExit = roomExit;
    }

    public String getRoomDesc() {
        return roomDesc.replace("roomGold", "" + roomGold);
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomDescSeen() {
        return roomDescSeen.replace("roomGold", "" + roomGold);
    }

    public void setRoomDescSeen(String roomDesc) {
        this.roomDescSeen = roomDesc;
    }

    public int getRoomGold() {
        return roomGold;
    }

    public void setRoomGold(int roomGold) {
        this.roomGold = roomGold;
    }

    public Room getRoomN() {
        return RoomN;
    }

    public void setRoomN(Room RoomN) {
        this.RoomN = RoomN;
    }

    public Room getRoomS() {
        return RoomS;
    }

    public void setRoomS(Room RoomS) {
        this.RoomS = RoomS;
    }

    public Room getRoomE() {
        return RoomE;
    }

    public void setRoomE(Room RoomE) {
        this.RoomE = RoomE;
    }

    public Room getRoomW() {
        return RoomW;
    }

    public void setRoomW(Room RoomW) {
        this.RoomW = RoomW;
    }

    public Item getRoomItem() {
        return roomItem;
    }

    public String getRoomItemDesc() {
        return roomItem.getItemDesc();
    }

    public void setRoomItem(Item roomItem) {
        this.roomItem = roomItem;
    }

    public Monster getRoomMonster() {
        return roomMonster;
    }

    public void setRoomMonster(Monster roomMonster) {
        this.roomMonster = roomMonster;
    }

}
