package moriamines;

public class MoriaMines {

    public static void main(String[] args) {
        GameControl gc = new GameControl();
        
        gc.startGame();
        gc.endGame();
        FileHandler.runHighscore(gc.getP());
    }

}
