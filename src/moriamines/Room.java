package moriamines;

public class Room {

    private String roomDesc = "";
    private int roomGold = 0;
    private boolean roomExit = false;
    private Item roomItem;

    private Room RoomN = null;
    private Room RoomS = null;
    private Room RoomE = null;
    private Room RoomW = null;

    public Room(int Gold) {
        roomGold = Gold;
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
}
