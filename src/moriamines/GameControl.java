package moriamines;

import moriamines.Items.Potion;
import moriamines.Items.Armor;
import moriamines.Items.Item;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import moriamines.Items.Weapon;

public class GameControl {

    private Player p = new Player(this);
    private Scanner input = new Scanner(System.in);
    private boolean gamePlaying = true;

    //Used for making a method in Potion and in main work.
    public Player getP() {
        return p;
    }

    // sets up the game, map and player.
    public void startGame() {
        System.out.println("Welcome to the Mines of Moria!");
        gameSetup();
        gameRun();
    }

    // asks if the player would like to play again.
    public void endGame() {
        System.out.println("Do you want to play again? This will discard your highscore!");
        String s = input.nextLine().toLowerCase();
        switch (s) {
            case "y":
            case "yes":
                startGame();
                break;
            case "n":
            case "no":
                break;
        }
    }

    // Sets up the game. Creates a player and instantiates the rooms.
    public void gameSetup() {
        p.playerSetup();
        createMap();
    }

    // Primary game method. Waits for user input, and runs the commands associated with the users inputs.
    public void gameRun() {
        help();
        System.out.println("Starting game!");
        gamePlaying = true;
        System.out.println(p.getCurrentRoom().getRoomDesc());
        while (gamePlaying) {
            String cmd = input.nextLine().toLowerCase();
            switch (cmd) {
                case "room":
                case "roomdesc":
                case "description":
                case "room description":
                case "look around":
                    p.getCurrentRoom().printRoomDesc();
                    break;
                case "n":
                case "north":
                    p.goNorth();
                    break;
                case "s":
                case "south":
                    p.goSouth();
                    break;
                case "e":
                case "east":
                    p.goEast();
                    break;
                case "w":
                case "west":
                    p.goWest();
                    break;
                case "take gold":
                    if ((p.getCurrentRoom().getRoomGold()) > 0) {
                        p.addPlayerGold(p.getCurrentRoom().getRoomGold());
                        System.out.println("You pick up the gold you found.");
                        System.out.println("You now have " + p.getPlayerGold() + " Gold in your bag.\n");
                        p.getCurrentRoom().setRoomGold(0);
                    } else {
                        System.out.println("There is nothing here.\n");
                    }
                    break;
                case "use":
                    p.useCommand();
                    break;
                case "equip":
                    p.equipCommand();
                    break;
                case "items":
                case "item":
                case "inventory":
                case "inv":
                case "equipped":
                    p.inventory();
                    System.out.println("");
                    p.equipped();
                    break;
                case "health":
                case "damage":
                case "defense":
                case "def":
                case "hp":
                case "dmg":
                case "stats":
                    p.playerStats();
                    break;
                case "pick up":
                    if (p.getCurrentRoom().getRoomItem() == null) {
                        System.out.println("There is no item here");
                    } else {
                        System.out.println("you take the " + p.getCurrentRoom().getRoomItemDesc() + " and put it in yout bag.\n");
                        p.addToInv(p.getCurrentRoom().getRoomItem());
                        p.getCurrentRoom().setRoomItem(null);
                    }
                    break;
                case "quit":
                    System.out.println("");
                    gamePlaying = false;
                    break;
                case "help":
                    help();
                    System.out.println(p.getCurrentRoom().getRoomDesc());
                    break;
                case "hs":
                case "highscore":
                    FileHandler.printHighscore();
                    break;
                default:
                    System.out.println("Command not recognized. type help for list of commands.\n");
                    break;
            }
            if (p.getCurrentRoom().isRoomExit()) {
                gamePlaying = false;
            }
        }
        gameOver();
    }

    //Prints out the list of commands.
    private void help() {
        System.out.println("\nList of commands:");
        System.out.println("use/heal: puts you in to use use mode. Write \"use\", press enter, then write the item you'd like to use.");
        System.out.println("equip: puts you in to use equip mode. Write \"equip\", press enter, then write the item you'd like to equip.");
        System.out.println("items/inv/inventory: shows you what items you have in your bag, and what you have equipped.");
        System.out.println("stats: Shows you your HP/Gold/Damage/Armor.");
        System.out.println("take gold: picks up the gold on the floor of the room.");
        System.out.println("pick up: picks up the items in the current room.");
        System.out.println("north: moves the player north, if possible.");
        System.out.println("south: moves the player south, if possible.");
        System.out.println("east: moves the player east, if possible.");
        System.out.println("west: moves the player west, if possible.");
        System.out.println("highscore/hs: shows you the highscores for the game.");
        System.out.println("quit: ends the game.\n");
    }

    //triggers when a condition for game end is triggered. Prints 3 lines of text.
    private void gameOver() {
        System.out.println("Game Over!\n");
        System.out.println("you had " + p.getPlayerGold() + " Gold.");
        System.out.println("Thank you for playing Mines of Moria!\n");

    }

    //Generate a random number between 1 and 30. Used when adding gold to the room in createMap().
    private int randomGold() {
        return ThreadLocalRandom.current().nextInt(1, 30 + 1);
    }

    //Generates a static map. Also adds gold, items and monsters to the rooms.
    public void createMap() {
        Item bone = new Item("broken bone");
        Monster goblin = new Monster("mine goblin", 18, 4, bone, 2);
        Monster orc = new Monster("orc", 25, 3, bone, 3);

        Room r1 = new Room(randomGold());
        r1.setRoomDesc("You walk into the mines, in to the entrance. There is a hallway to the north. There is some gold on the floor.");
        r1.setRoomDescSeen("You go back to the entrance of the mine.\nThere is a a hallway to the north, and the exit to the south.");

        Room r2 = new Room(randomGold());
        r2.setRoomDesc("You walk into the hallway. At the end, there is a small room. In of the corners lie roomGold gold pieces.");
        r2.setRoomDescSeen("You go back in to the hallway. There is a small room at the end.");
        r2.setRoomMonster(new Monster("black rat", 15, 2, (new Armor("fur hat", 2)), 0));

        Room r3 = new Room(0);
        r3.setRoomDesc("A bunch broken tools lies in the middle of the cornerroom. Amidst the pile there is a rusty pickaxe.");
        r3.setRoomDescSeen("You walk back into the corner room. There is some broken tools in the middle of the room. Nothing of value.");
        r3.setRoomItem(new Weapon("rusty pickaxe", 6));

        Room r4 = new Room(randomGold());
        r4.setRoomDesc("a broken down minecart stands here. In it lies a dead dwarf. You search his pockets, and find roomGold gold pieces  and a healing potion in his pockets. But then he comes alive!");
        r4.setRoomDescSeen("You go back to the broken minecart and the dead dwarf.");
        r4.setRoomItem(new Potion("health potion", 30));
        r4.setRoomMonster(new Monster("zombie dwarf", 18, 3, (new Potion("rotten meat", 10)), 15));

        Room r5 = new Room(randomGold());
        r5.setRoomDesc("Some rats run away as you enter the room. On the wall hangs a davy lamp. Something on the floor glimmers in the light of the lamp.");
        r5.setRoomDescSeen("The davy lamp on the wall flickers as you walk back into the room.");
        r5.setRoomMonster(goblin);

        Room r6 = new Room(0);
        r6.setRoomDesc("You walk through a pitch-black mine tunnel. You feel like the ground is softly trembling underneath you - like something heavy is walking underneath you.");
        r6.setRoomDescSeen("You walk back into the pitch black darkness. It is completely silent - very eerie.");

        Room r7 = new Room(randomGold());
        r7.setRoomDesc("You enter what looks like the sleeping quarters of the mineworkers. Empty, unmade beds and old clothes lie around. You search the clothes and beds, and find roomGold Gold pieces.");
        r7.setRoomDescSeen("The sleeping quarters look just like when you left them.");
        r7.setRoomMonster(goblin);

        Room r8 = new Room(randomGold());
        r8.setRoomDesc("You walk along, and find the entrance to a mineshaft. A sign says \"DANGER\". A skeleton lies underneath the sign, a nasty grim face with a smile full of golden teeth.");
        r8.setRoomDescSeen("You go back to the mineshaft entrance. But now there is no skeleton!");
        r8.setRoomItem(new Item("Gold Teeth"));

        Room r9 = new Room(randomGold());
        r9.setRoomItem(new Weapon("broken bottle", 4));
        r9.setRoomDesc("You enter what looks like an underground bar. Empty bottles with a strong scent of alcohol lie all over. It looks like someone left in a hurry. On a table, there is some gold and some playing cards.");
        r9.setRoomDescSeen("The underground bar it still silent and empty, except for all the bottles");
        r9.setRoomMonster(new Monster("ghostly bartender", 7, 1, (new Item("ghostly essence")), 0));

        Room r10 = new Room(0);
        r10.setRoomDesc("In the next room, a mineshaft starts to the east. A sign at the entrance says \"Diamond mine ahead\". The door to the north says \"Caution\".");
        r10.setRoomDescSeen("The entrance to the diamon mine is silent and dark.");
        r10.setRoomMonster(new Monster("skeleton warrior", 20, 5, (new Weapon("Steel sword", 10)), 10));

        Room r11 = new Room(0);
        r11.setRoomItem(new Weapon("dwarf femur", 3));
        r11.setRoomDesc("You walk down the mineshaft. As you go down, more and more bones is spread over the floor. It crunches as you walk on them.");
        r11.setRoomDescSeen("The bones still crunch under your feet as you walk back.");

        Room r12 = new Room(61);
        r12.setRoomItem(new Potion("fried chicken", 25));
        r12.setRoomDesc("As you walk down the empty mineshaft, you feel like someone is watching you. At the end, there is a chest. It looks like its safe enough to open.");
        r12.setRoomDescSeen("The empty mineshaft still doesn't feel empty at all...");
        r12.setRoomMonster(orc);

        Room r13 = new Room(0);
        r13.setRoomDesc("You come to the end of the old mine. \"Under construction\" is what the sign on the rocky wall tells you. On the ground, there is some mushrooms.");
        r13.setRoomDescSeen("Some rocks have tumbled down the wall, blocking the old \"Under construction\" sign off completely.");
        r13.setRoomItem(new Potion("green mushroom", 10));

        Room r14 = new Room(150);
        r14.setRoomDesc("At the end of the mineshaft, you enter a large cave. Something monstrous is sleeping in the back of the room. It looks like it has some swords stuck in its back!");
        r14.setRoomDescSeen("The body of the monster lies in the middle of the large cave.");
        r14.setRoomMonster(new Monster("Fire Elemental", 40, 15, (new Armor("Ironclad boots", 4)), 0));

        Room r15 = new Room(randomGold());
        r15.setRoomItem(new Potion("red mushroom", 15));
        r15.setRoomDesc("You walk down an old tunnel, to what would look like the lower levels of the mine. You kick into something with your foot. It's a mushroom.");
        r15.setRoomDescSeen("You go back to the old tunnel.");

        Room r16 = new Room(0);
        r16.setRoomDesc("You enter a large, central room. Several lit torches hangs on the walls. There is tunnels to the west, north and east of you. There is sound coming from the tunnel in the east.");
        r16.setRoomDescSeen("You go back into the well-lit room.");
        r16.setRoomMonster(orc);
        r16.setRoomItem(new Weapon("Blade of the Tribes", 15));

        Room r17 = new Room(randomGold());
        r17.setRoomItem(new Weapon("ancient dwarf war axe", 10));
        r17.setRoomDesc("You walk into the tunnel and into the room at the end. Theres something here! some dwarfes are picking and hacking away on a wall with their pickaxes. They don't look like normal Dwarfes - they seem like they are blurry and almmost transparent.");
        r17.setRoomDescSeen("The ghastly dwarfs are all gone. The tunnel is silent.");
        r17.setRoomMonster(new Monster("Ghost dwarves", 30, 9, (new Armor("plate armor", 5)), 20));

        Room r18 = new Room(0);
        r18.setRoomDesc("You come to a crossroads, a split in the tunnel. You can continue north, lower down in the mines, or you can go east. It looks like there is light at the end of the tunnel to the east.");
        r18.setRoomDescSeen("The crossroads look just like when you last left.");
        r18.setRoomItem(new Item("torch"));

        Room r19 = new Room(0);
        r19.setRoomDesc("Bossfight.exe");
        r19.setRoomDescSeen("BossDead.exe");
        r19.setRoomMonster(new Monster("Leoric, the Skeleton King", 100, 20, null, 200));

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
