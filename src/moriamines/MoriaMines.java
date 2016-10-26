package moriamines;

public class MoriaMines {

    public static void main(String[] args) {
        GameControl gc = new GameControl();

        System.out.println("Welcome to the Mines of Moria!");
        gc.gameSetup();
        gc.gameRun();
    }

}
