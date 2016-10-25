package moriamines;

import java.io.IOException;

public class MoriaMines {

    public static void main(String[] args) throws IOException {
        GameControl gc = new GameControl();
        
        System.out.println("Welcome to the Mines of Moria!");
        gc.gameSetup();
        gc.gameRun();
    }

}
