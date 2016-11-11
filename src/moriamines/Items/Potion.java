package moriamines.Items;

import moriamines.Player;

public class Potion extends Item {

    private int restoreHealth;

    public int getRestoreHealth() {
        return restoreHealth;
    }

    public Potion(String desc, int restore) {
        super(desc);
        restoreHealth = restore;
    }

    // Restores health to the player when called.
    public void restoreHealth(Potion i, Player p) {
        if (p.getPlayerCurrentHealth() != p.getPlayerMaxHealth()) {
            if (p.getPlayerMaxHealth() < (p.getPlayerCurrentHealth() + i.getRestoreHealth())) {
                System.out.println("You healed for " + (p.getPlayerMaxHealth() - p.getPlayerCurrentHealth()));
                p.setPlayerCurrentHealth(p.getPlayerMaxHealth());

            } else {
                p.setPlayerCurrentHealth(p.getPlayerCurrentHealth() + i.getRestoreHealth());
                System.out.println("You healed for " + i.getRestoreHealth());
            }
            p.getInv().remove(i);
            System.out.println("You now have " + p.getPlayerCurrentHealth() + "/" + p.getPlayerMaxHealth() + " health.");
        } else {
            System.out.println("you are already at max health!");
        }
    }

}
