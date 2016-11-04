package moriamines.Items;

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
    public void restoreHealth(Item i) {
        if ((gc.getP().getPlayerCurrentHealth() + restoreHealth) > gc.getP().getPlayerMaxHealth()) {
            gc.getP().setPlayerCurrentHealth(gc.getP().getPlayerMaxHealth());
            System.out.println("You healed for " + (100 - gc.getP().getPlayerMaxHealth()));
        } else {
            gc.getP().setPlayerCurrentHealth((gc.getP().getPlayerCurrentHealth() + restoreHealth));
            System.out.println("You healed for " + restoreHealth);
        }
        gc.getP().getInv().remove(i);
        System.out.println("You now have " + gc.getP().getPlayerCurrentHealth() + "/" + gc.getP().getPlayerMaxHealth() + " health.");

    }

}
