package moriamines;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {

    static ArrayList<String> tempList = new ArrayList();
    static ArrayList<String> sortedList = new ArrayList();

    public static void runHighscore(Player hero) {
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);

        tempList.add("Player " + hero.getPlayerName() + " earned " + hero.getPlayerGold() + " gold, and killed " + hero.getMonstersKilled() + " monster(s).");
        fileToList();
        sortList();
        addToBuffer(bw);
        writeToFile(sw);
        printHighscore();
    }

    private static void fileToList() {
        try {
            for (String line : Files.readAllLines(Paths.get("highscore.txt"))) {
                tempList.add(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void sortList() {
        for (int i = 0; i < tempList.size(); i++) {
            int holdValue = 0;
            String holdLine = tempList.get(0);

            for (String line : tempList) {
                if (holdValue < Integer.parseInt(line.replaceAll("[\\D]", "")) && !sortedList.contains(line)) {
                    holdValue = Integer.parseInt(line.replaceAll("[\\D]", ""));
                    holdLine = line;
                }
            }

            sortedList.add(holdLine);
        }
    }

    private static void addToBuffer(BufferedWriter bw) {
        try {
            for (String line : sortedList) {
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void writeToFile(StringWriter sw) {
        try (Writer osw = (new OutputStreamWriter(new FileOutputStream("highscore.txt"), "utf-8"))) {
            osw.write(sw.getBuffer().toString());
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void printHighscore() {
        try {
            System.out.println("*** HIGHSCORES ***");

            for (String line : Files.readAllLines(Paths.get("highscore.txt"))) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
