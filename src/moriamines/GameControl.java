package moriamines;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameControl {

    Player p = new Player();

    public Player getP() {
        return p;
    }

    Scanner input = new Scanner(System.in);
    boolean endGame = false;

    public void gameSetup() {
        createPlayer();
        createMap();
    }

    public void gameRun() {
        System.out.println("Starting game!");
        System.out.println(p.getCurrentRoom().getRoomDesc());

        while (endGame == false) {
            String cmd = input.nextLine().toLowerCase();
            switch (cmd) {
                case "room":
                case "roomdesc":
                case "description":
                case "room description":
                case "look around":
                    printRoomDesc();
                    break;
                case "n":
                case "north":
                    if (p.getCurrentRoom().getRoomN() != null) {
                        p.goNorth();
                        printRoomDesc();
                        break;
                    } else {
                        System.out.println("The stone wall does not allow for passage this way through.");
                        break;
                    }
                case "s":
                case "south":
                    if (p.getCurrentRoom().getRoomS() != null) {
                        p.goSouth();
                        printRoomDesc();
                        break;
                    } else {
                        System.out.println("A grey, rocky wall stands here. No way through.");
                        break;
                    }
                case "e":
                case "east":
                    if (p.getCurrentRoom().getRoomE() != null) {
                        p.goEast();
                        printRoomDesc();
                        break;
                    } else {
                        System.out.println("You searh the rocky wall, but find no way on.");
                        break;
                    }
                case "w":
                case "west":
                    if (p.getCurrentRoom().getRoomW() != null) {
                        p.goWest();
                        printRoomDesc();
                        break;
                    } else {
                        System.out.println("There is only a brick wall here.");
                        break;
                    }
                case "take gold":
                    if ((p.getCurrentRoom().getRoomGold()) > 0) {
                        p.setPlayerGold((p.getPlayerGold() + p.getCurrentRoom().getRoomGold()));
                        System.out.println("You pick up the gold you found.");
                        System.out.println("You now have " + p.getPlayerGold() + " Gold in your bag.");
                        p.getCurrentRoom().setRoomGold(0);
                        break;
                    } else {
                        System.out.println("There is nothing here.");
                        break;
                    }
                case "use":
                    System.out.println("Inventory:");
                    for (Item i : p.inv) {
                        System.out.println(i.getItemDesc());
                    }
                    System.out.println("What item would you like to use?");
                    useCommand();
                    break;
                case "equipped":
                case "equip":
                    System.out.println("Inventory:");
                    for (Item i : p.inv) {
                        System.out.println(i.getItemDesc());
                    }
                    System.out.println("What item would you like to equip?");
                    equipCommand();
                    break;
                case "items":
                case "item":
                    System.out.println("Inventory:");
                    for (Item i : p.inv) {
                        System.out.println(i.getItemDesc());
                    }
                    break;
                case "health":
                case "damage":
                case "defense":
                case "def":
                case "hp":
                case "dmg":
                case "stats":
                    System.out.println("Player Stats:");
                    System.out.println("Health: " + p.getPlayerHealth());
                    System.out.println("Damage: " + p.getPlayerDmg());
                    System.out.println("Armor: " + p.getPlayerDef());
                    System.out.println("Gold: " + p.getPlayerGold());
                    break;
                case "pick up":
                    System.out.println("you take the " + p.getCurrentRoom().getRoomItemDesc() + " and put it in yout bag.");
                    p.addToInv(p.getCurrentRoom().getRoomItem());
                    p.getCurrentRoom().setRoomItem(null);
                    break;
                case "quit":
                    System.out.println("");
                    endGame = true;
                    break;
                case "help":
                    System.out.println("List of commands:");
                    System.out.println("use: puts you in to use use mode. Write \"use\", press enter, then write the item you'd like to use.");
                    System.out.println("items: shows you what items you have in your bag.");
                    System.out.println("gold: shows you the current gold.");
                    System.out.println("take gold: picks up the gold on the floor of the room.");
                    System.out.println("take item: picks up the items in the current room.");
                    System.out.println("north: moves the player north, if possible.");
                    System.out.println("south: moves the player south, if possible.");
                    System.out.println("east: moves the player east, if possible.");
                    System.out.println("west: moves the player west, if possible.");
                    System.out.println("quit: ends the game.\n");
                    System.out.println(p.getCurrentRoom().getRoomDesc());
                    break;
                default:
                    System.out.println("Command not recognized. type help for list of commands.\n");
                    break;
            }
            if (p.getCurrentRoom().isRoomExit()) {
                endGame = true;
            }
        }

        System.out.println("Game Over!");
        System.out.println("you had " + p.getPlayerGold() + " Gold.");
        System.out.println("Thank you for playing Mines of Moria!");
    }

    public void createPlayer() {
        System.out.println("What is your name?");
        p.setPlayerName(input.nextLine());
        p.setPlayerGold(0);
        p.setPlayerHealth(100);

    }

    public void printRoomDesc() {
        if (p.getCurrentRoom().isRoomSeen() == true) {
            System.out.println(p.getCurrentRoom().getRoomDescSeen());
        } else {
            System.out.println(p.getCurrentRoom().getRoomDesc());
        }
    }

    public void equipCommand() {
        String item = input.nextLine().toLowerCase();
        switch (item) {
            case "wooden sword":
                for (Item i : p.inv) {
                    if (i.getItemDesc().toLowerCase().equals("wooden sword")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            p.setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + p.getPlayerDmg());
                        }
                    }
                }
            case "steel sword":
                for (Item i : p.inv) {
                    if (i.getItemDesc().toLowerCase().equals("steel sword")) {
                        if (i instanceof Sword) {
                            Sword mySword = (Sword) i;
                            p.setPlayerDmg(mySword.weaponDmg);
                            System.out.println("You equip the " + mySword.getItemDesc() + ". Your damage is now " + p.getPlayerDmg());
                        }
                    }
                }
        }
    }

    public void useCommand() {
        String use = input.nextLine().toLowerCase();
        switch (use) {
            case "health potion":
                for (Item i : p.inv) {
                    if (p.getPlayerHealth() == 100) {
                        System.out.println("You are already at full health!");
                        break;
                    } else if ((i.getItemDesc().toLowerCase()).equals("health potion")) {
                        if (i instanceof Potion) {
                            Potion myPotion = (Potion) i;
                            myPotion.getRestoreHealth();
                            break;
                        }
                    } else {
                        System.out.println("You don't have any potions!");
                        break;
                    }
                }
        }
    }

    public int randomGold() {
        return ThreadLocalRandom.current().nextInt(1, 30 + 1);
    }

    public void createMap() {
        Room r1 = new Room(0);
        r1.setRoomDesc("You walk into the mines, in to the entrance. There is a hallway to the north. There is a wooden sword in the corner.");
        r1.setRoomDescSeen("You go back to the entrance of the mine.\nThere is a a hallway to the north.");
        r1.setRoomItem(new Sword("wooden sword", 5, "sword"));
        Room r2 = new Room(randomGold());
        r2.setRoomDesc("You walk into the hallway. At the end, there is a small room. In of the corners lie roomGold gold pieces.");
        r2.setRoomDescSeen("You go back in to the hallway. There is a small room at the end.");
        Room r3 = new Room(0);
        r3.setRoomDesc("A bunch broken tools lies in the middle of the cornerroom. Amidst the pile there is a rusty pickaxe.");
        r3.setRoomDescSeen("You walk back into the corner room. There is some broken tools in the middle of the room. Nothing of value.");
        r3.setRoomItem(new Sword("rusty pickaxe", 7, "axe"));
        Room r4 = new Room(randomGold());
        r4.setRoomDesc("a broken down minecart stands here. In it lies a dead dwarf. You search his pockets, and find roomGold gold pieces  and a healing potion in his pockets.");
        r4.setRoomItem(new Potion("health potion", 30));
        Room r5 = new Room(randomGold());
        r5.setRoomDesc("Some rats run away as you enter the room. On the wall hangs a davy lamp. Something on the floor glimmers in the light of the lamp.");
        Room r6 = new Room(0);
        r6.setRoomDesc("You walk through a pitch-black mine tunnel. You feel like the ground is softly trembling underneath you - like something heavy is walking underneath you.");
        Room r7 = new Room(randomGold());
        r7.setRoomDesc("You enter what looks like the sleeping quarters of the mineworkers. Empty, unmade beds and old clothes lie around. You search the clothes and beds, and find roomGold Gold pieces.");
        Room r8 = new Room(5);
        r8.setRoomDesc("You walk along, and find the entrance to a mineshaft. A sign says \"DANGER\". A skeleton lies underneath the sign, a nasty grim face with a smile full of golden teeth.");
        Room r9 = new Room(randomGold());
        r9.setRoomDesc("You enter what looks like an underground bar. Empty bottles with a strong scent of alcohol lie all over. It looks like someone left in a hurry. On a table, there is some gold and some playing cards.");
        Room r10 = new Room(0);
        r10.setRoomDesc("In the next room, a mineshaft starts to the east. A sign at the entrance says \"Diamond mine ahead\". The door to the north says \"Caution\".");
        Room r11 = new Room(0);
        r11.setRoomDesc("You walk down the mineshaft. As you go down, more and more bones is spread over the floor. It crunches as you walk on them.");
        Room r12 = new Room(61);
        r12.setRoomDesc("As you walk down the empty mineshaft, you feel like someone is watching you. At the end, there is a chest. It looks like its safe enough to open.");
        Room r13 = new Room(0);
        r13.setRoomDesc("You come to the end of the old mine. \"Under construction\" is what the sign on the rocky wall tells you. On the ground, there is a rusty pickaxe.");
        Room r14 = new Room(150);
        r14.setRoomDesc("At the end of the mineshaft, you enter a large cave. Something monstrous is sleeping in the back of the room. It looks like there is something behind it - a chest, maybe?");
        Room r15 = new Room(randomGold());
        r15.setRoomDesc("You walk down an old tunnel, to what would look like the lower levels of the mine. You kick into something with your foot. It's a small box.");
        Room r16 = new Room(0);
        r16.setRoomDesc("You enter a large, central room. Several lit torches hangs on the walls. There is tunnels to the west, north and east of you. There is sound coming from the tunnel in the east.");
        Room r17 = new Room(randomGold());
        r17.setRoomDesc("You walk into the tunnel and into the room at the end. Theres something here! some dwarfes are picking and hacking away on a wall with their pickaxes. They don't look like normal Dwarfes - they seem like they are blurry and almmost transparent.");
        Room r18 = new Room(0);
        r18.setRoomDesc("You come to a crossroads, a split in the tunnel. You can continue north, lower down in the mines, or you can go east. It looks like there is light at the end of the tunnel to the east.");
        Room r19 = new Room(0);
        r19.setRoomDesc("Bossfight.exe");
        Room r20 = new Room(0);
        r20.setRoomDesc("You find a large treasure chest, filled to the brim with gold and jewelry.\nYou take it all, and leave the same way you came in.");
        r20.setRoomExit(true);
        Room r21 = new Room(0);
        r21.setRoomDesc("You walk out of the dungeon, and back to the city.");
        r21.setRoomExit(true);

        r1.setRoomN(r2);
        r1.setRoomS(r21);

        r2.setRoomN(r4);
        r2.setRoomW(r3);
        r2.setRoomE(r5);
        r2.setRoomS(r1);

        r3.setRoomE(r2);
        r3.setRoomN(r6);

        r4.setRoomN(r9);
        r4.setRoomW(r6);
        r4.setRoomS(r2);

        r5.setRoomN(r7);
        r5.setRoomW(r2);

        r6.setRoomN(r8);
        r6.setRoomE(r4);
        r6.setRoomS(r3);

        r7.setRoomN(r10);
        r7.setRoomS(r5);

        r8.setRoomN(r15);
        r8.setRoomW(r12);
        r8.setRoomE(r9);
        r8.setRoomS(r6);

        r9.setRoomW(r8);
        r9.setRoomS(r4);
        r9.setRoomE(r10);

        r10.setRoomN(r17);
        r10.setRoomW(r9);
        r10.setRoomS(r7);
        r10.setRoomE(r11);

        r11.setRoomW(r10);
        r11.setRoomN(r14);

        r12.setRoomE(r8);

        r13.setRoomS(r18);

        r14.setRoomS(r11);

        r15.setRoomN(r18);
        r15.setRoomS(r8);
        r15.setRoomE(r16);

        r16.setRoomN(r19);
        r16.setRoomW(r15);
        r16.setRoomE(r17);

        r17.setRoomW(r16);
        r17.setRoomS(r10);

        r18.setRoomN(r13);
        r18.setRoomS(r15);
        r18.setRoomE(r19);

        r19.setRoomN(r20);
        r19.setRoomW(r18);
        r19.setRoomS(r16);

        r20.setRoomS(r19);

        p.setCurrentRoom(r1);
        p.getCurrentRoom().setRoomSeen(true);
    }
}
