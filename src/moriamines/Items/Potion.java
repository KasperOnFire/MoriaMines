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
        if ((gc.getP().getPlayerHealth() + restoreHealth) > 100) {
            gc.getP().setPlayerHealth(100);
            System.out.println("You healed for " + (100-gc.getP().getPlayerHealth()));
        } else {
            gc.getP().setPlayerHealth((gc.getP().getPlayerHealth() + restoreHealth));
            System.out.println("You healed for " + restoreHealth);
        }
        gc.getP().getInv().remove(i);
        System.out.println("You now have " + gc.getP().getPlayerHealth() + " health.");

    }

}
