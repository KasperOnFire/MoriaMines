package moriamines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Highscore {

    private Player p;

    public Highscore(Player pl) {
        p = pl;
    }

    public void writeToFile() throws FileNotFoundException {
        String text = "Player " + p.getPlayerName() + " Earned " + p.getPlayerGold() + " gold"; //evt add monsters killed senere
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("highscore.txt"), true));
            pw.println(text);
            pw.close();
        } catch (FileNotFoundException f) {
            PrintWriter out = new PrintWriter("highscore.txt");
            out.println(text);
            out.close();
        }
        System.out.println("A highscore file has been saved in GameDirectory\\highscore.txt.");
    }
}
