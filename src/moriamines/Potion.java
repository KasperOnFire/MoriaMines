package moriamines;

public class Potion extends Item {

    private int restoreHealth;

    public int getRestoreHealth() {
        return restoreHealth;
    }

    public Potion(String desc, int restore) {
        super(desc);
        restoreHealth = restore;
    }

    public void restoreHealth(Item i) {
        if ((gc.getP().getPlayerHealth() + restoreHealth) > 100) {
            gc.getP().setPlayerHealth(100);
        } else {
            gc.getP().setPlayerHealth((gc.getP().getPlayerHealth() + restoreHealth));
        }
        gc.p.inv.remove(i);
        System.out.println("You now have " + gc.p.getPlayerHealth() + " health.");

    }

}
