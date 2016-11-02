package moriamines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Highscore {

    private Player p;

    public Highscore(Player pl) {
        p = pl;
    }

    public void writeToFile() throws FileNotFoundException {
        String text = p.getPlayerGold() + " Gold earned and " + p.getMonstersKilled() + " monsters killed by Player " + p.getPlayerName() + ".";

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

    public void readFromFile() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get("highscore.txt"))) {
            stream.forEach(System.out::println);

        }
    }

    // reads from highscorefile, adds to arraylist
    public void sortFile() throws FileNotFoundException, IOException {

        List<String> highscoreList = new ArrayList<>();
        Scanner reader = new Scanner(Paths.get("highscore.txt"));

        while (reader.hasNext()) {
            highscoreList.add(reader.nextLine());
        }

        Collections.sort(highscoreList.subList(1, highscoreList.size()));
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("highscore.txt"), true));
            for (String i : highscoreList) {
                pw.println(i);
                pw.close();
            }
        } catch (FileNotFoundException f) {
            System.out.println("no existing highscorefile.");
        }

    }
}
