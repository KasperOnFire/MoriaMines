package moriamines;

import java.util.Scanner;

public class Combat {

    private Player p;
    private Monster m;
    private boolean combat;
   // Scanner input = new Scanner(System.in);

    public Combat(Player pl, Monster mo) {
        p = pl;
        m = mo;
    }

    public void startCombat() {
        // String cmd = input.nextLine().toLowerCase();
        combat = true;
        System.out.println("There is a monster in here!");
        System.out.println("The monster is a " + p.getCurrentRoom().getRoomMonster().getMonsterDesc());
        while (combat) {
            monsterTurn();
            playerTurn();
        }
        loot();
    }

    public void monsterTurn() {
        System.out.println("The monster attacks you.");
        System.out.println("it hits you for " + m.getMonsterDmg());
        p.setPlayerHealth(p.getPlayerHealth() - (m.getMonsterDmg() - p.getPlayerDef()));
        if (p.getPlayerHealth() > 0) {
            System.out.println("You have " + p.getPlayerHealth() + " Health left!");
        } else {
            System.out.println("You die!");

        }

    }

    public void playerTurn() {
        System.out.println("You attack the monster!");
        if (p.getPlayerDmg() > 2) {
            System.out.println("You swing your weapon for " + p.getPlayerDmg() + " damage");
            m.setMonsterHealth((m.getMonsterHealth() - p.getPlayerDmg()));
        } else {
            System.out.println("You punch the monster for " + p.getPlayerDmg() + " damage");
            m.setMonsterHealth((m.getMonsterHealth() - p.getPlayerDmg()));
        }
        if (m.getMonsterHealth() > 0) {
            System.out.println("The monster takes damage! it now has " + m.getMonsterHealth() + " health left!");
        } else {
            System.out.println("The monster dies!");
            combat = false;
        }
    }

    public void loot() {
        System.out.println("you search the monster, and you find a " + m.getMonsterItem().getItemDesc());
        p.addToInv(m.getMonsterItem());
        m.setMonsterItem(null);
    }

}
