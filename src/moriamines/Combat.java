package moriamines;

import java.util.Scanner;
import moriamines.Items.Item;

public class Combat {

    private Player p;
    private Monster m;
    private boolean combat = false;
    Scanner input = new Scanner(System.in);

    public Combat(Player pl, Monster mo) {
        p = pl;
        m = mo;
    }

    //  The combat method. Runs the monsters and the players turn.
    public void startCombat() {
        combat = true;
        System.out.println("There is a monster in here!");
        System.out.println("The monster is a " + p.getCurrentRoom().getRoomMonster().getMonsterDesc());
        while (combat) {
            monsterTurn();
            playerTurn();
        }
        loot();
    }

    //Makes the monster attack.
    public void monsterTurn() {
        System.out.println("The monster attacks you.");
        System.out.println("it hits you for " + m.getMonsterDmg() + ".");
        p.setPlayerHealth(p.getPlayerHealth() - (m.getMonsterDmg() - p.getPlayerDef()));
        if (p.getPlayerHealth() > 0) {
            System.out.println("You have " + p.getPlayerHealth() + " Health left!");
        } else {
            System.out.println("You die!");

        }

    }

// runs the player turns. Waits for player inputs to choose what to do.
    public void playerTurn() {
        System.out.println("What will you do?");
        System.out.println("Fight/Heal/Use Items");
        String cmd = input.nextLine().toLowerCase();
        switch (cmd) {
            case "fight":
            case "hit":
                System.out.println("You attack the monster!");
                if (p.getPlayerDmg() > 2) {
                    System.out.println("You swing your weapon for " + p.getPlayerDmg() + " damage.");
                    m.setMonsterHealth((m.getMonsterHealth() - p.getPlayerDmg()));
                } else {
                    System.out.println("You punch the monster for " + p.getPlayerDmg() + " damage.");
                    m.setMonsterHealth((m.getMonsterHealth() - p.getPlayerDmg()));
                }
                if (m.getMonsterHealth() > 0) {
                    System.out.println("The monster takes damage! it now has " + m.getMonsterHealth() + " health left!");
                } else {
                    System.out.println("The monster dies!");
                    combat = false;
                }
                break;
            case "use":
            case "use item":
                p.useCommand();
                break;
            case "equipped":
            case "equip":
                p.equipCommand();
                break;
            case "items":
            case "item":
            case "inventory":
                System.out.println("Inventory:");
                for (Item i : p.getInv()) {
                    System.out.println(i.getItemDesc());
                }
                break;
        }

    }

    //Gives the player the item a dead monster may have.
    public void loot() {
        if (m.getMonsterItem() != null) {
            System.out.println("you search the monster, and you find a " + m.getMonsterItem().getItemDesc());
            p.addToInv(m.getMonsterItem());
            m.setMonsterItem(null);
        } else {
            System.out.println("You search the monster, but find nothing of use.");
        }

    }

}
