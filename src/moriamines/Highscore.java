package moriamines;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Highscore {

    private GameControl gc;

    public Highscore(GameControl gac) {
        gc = gac;

    }

    String text = gc.p.getPlayerName() + "Earned" + gc.p.getPlayerGold();
    BufferedWriter output = null;

    public void writeToFile() throws IOException {
        try {
            File file = new File("Highscore.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}
