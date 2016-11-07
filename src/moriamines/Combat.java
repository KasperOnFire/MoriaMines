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
        System.out.println("The monster is a " + p.getCurrentRoom().getRoomMonster().getMonsterDesc() + ("!"));
        while (combat) {
            monsterTurn();
            if (p.getPlayerCurrentHealth() > 0) {
                playerTurn();
            }

        }
        if (p.getPlayerCurrentHealth() > 0) {
            loot();
        }
    }

    //Makes the monster attack.
    public void monsterTurn() {
        System.out.println("The monster attacks you.");
        if ((m.getMonsterDmg() - p.getPlayerDef()) < 1) {
            p.setPlayerCurrentHealth((p.getPlayerCurrentHealth() - 1));
            System.out.println("it hits you for 1.");
            System.out.println("You have " + p.getPlayerCurrentHealth() + " Health left!\n");
        } else {
            p.setPlayerCurrentHealth(p.getPlayerCurrentHealth() - (m.getMonsterDmg() - p.getPlayerDef()));
            if (p.getPlayerCurrentHealth() > 0) {
                System.out.println("it hits you for " + (m.getMonsterDmg() - p.getPlayerDef()));
                System.out.println("You have " + p.getPlayerCurrentHealth() + " Health left!\n");
            } else {
                System.out.println("You die!\n");
                combat = false;
            }
        }

    }

// runs the player turns. Waits for player inputs to choose what to do.
    public void playerTurn() {
        System.out.println("What will you do?");
        System.out.println("Fight/Heal/Use/Equip Items");
        String cmd = input.nextLine().toLowerCase();
        switch (cmd) {
            case "fight":
            case "hit":
            case "attack":
                System.out.println("You attack the monster!");
                if ((p.getPlayerDmg() + p.getPlayerLvl()) > 3) {
                    System.out.println("You swing your weapon for " + (p.getPlayerDmg() + p.getPlayerLvl()) + " damage.");
                    m.setMonsterHealth((m.getMonsterHealth() - (p.getPlayerDmg() + p.getPlayerLvl())));
                } else {
                    System.out.println("You punch the monster for " + (p.getPlayerDmg() + p.getPlayerLvl()) + " damage.");
                    m.setMonsterHealth((m.getMonsterHealth() - (p.getPlayerDmg() + p.getPlayerLvl())));
                }
                if (m.getMonsterHealth() > 0) {
                    System.out.println("The monster takes damage! it now has " + m.getMonsterHealth() + " health left!\n");
                } else {
                    System.out.println("The monster dies!\n");
                    p.setMonstersKilled(p.getMonstersKilled() + 1);
                    combat = false;
                }
                break;
            case "use":
            case "use item":
            case "heal":
                p.useCommand();
                break;
            case "equipped":
            case "equip":
            case "weapon":
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
            default:
                System.out.println("Command not recognized\n");
                playerTurn();
                break;
        }

    }

    //Gives the player the item a dead monster may have.
    public void loot() {
        System.out.println("You earn " + m.getMonsterExp() + " experience.");
        if ((m.getMonsterExp() + p.getPlayerExp()) > 100) {
            System.out.println("Level up!");
            p.levelUp();
            p.setPlayerExp((m.getMonsterExp() + p.getPlayerExp()) - 100);
            System.out.println("Exp: " + p.getPlayerExp() + "/100.");
        } else {
            p.setPlayerExp(p.getPlayerExp() + m.getMonsterExp());
            System.out.println("Exp: " + p.getPlayerExp() + "/100.");
        }
        if (m.getMonsterItem() != null) {
            System.out.println("you search the monster, and you find a " + m.getMonsterItem().getItemDesc() + ".");
            p.addToInv(m.getMonsterItem());
            m.setMonsterItem(null);
        } else {
            System.out.println("You search the monster, but find nothing of use.");
        }
        if (m.getMonsterGold() > 0) {
            System.out.println("you also find " + m.getMonsterGold() + " gold.");
            p.addPlayerGold(m.getMonsterGold());
            m.setMonsterGold(0);
        }

    }

}
