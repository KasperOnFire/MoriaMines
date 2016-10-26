package moriamines;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Highscore {

    private GameControl gc;

    public Highscore(GameControl gac) {
        gc = gac;

    }
    String text = gc.p.getPlayerName() + "Earned" + gc.p.getPlayerGold();
    public void writeToFile() throws FileNotFoundException, IOException {
        try {
            // Files.write(Paths.get("highscore.txt"), text.getBytes(), StandardOpenOption.APPEND);
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("C:\\highscore.txt"), true));
        } catch (FileNotFoundException fnf) {
            PrintWriter out = new PrintWriter("highscore.txt");
            out.println(text);
            out.close();
        }
        System.out.println("A highscore file has been saved in C:\\highscore.txt.");
    }
}
