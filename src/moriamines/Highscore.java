package moriamines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Highscore {

    private Player p;
    private static ArrayList<String> highscoreList = new ArrayList<>();
    private static ArrayList<String> tempList = new ArrayList<>();

    public Highscore(Player pl) {
        p = pl;
    }

    public void printHs() {
        //writeToFile();
        readFromFile();
        sortFile();
        writeSortedFile();
        printSortedFile();
    }

    //writes the players name, gold earned and monsters killed to the file.
    public void writeToFile() {
        String text = "Player " + p.getPlayerName() + " earned " + p.getPlayerGold() + " gold and killed " + p.getMonstersKilled() + " monsters.";

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("highscore.txt"), true));
            pw.println(text);
            pw.close();
        } catch (FileNotFoundException f) {
            PrintWriter out;
            try {
                out = new PrintWriter("highscore.txt");
                out.println(text);
                out.close();
            } catch (FileNotFoundException ex) {
                System.err.println("error: " + ex);;
            }

        }
        System.out.println("A highscore file has been saved in GameDirectory\\highscore.txt.");
    }

    // reads from highscorefile, adds to arraylist
    private static void readFromFile() {

        try {
            for (String line : Files.readAllLines(Paths.get("highscore.txt"))) {
                tempList.add(line);
            }
        } catch (IOException ex) {
            System.out.println("fail");;
        }
    }

    //sorts content of arraylist
    private static void sortFile() {
        for (int i = 0; i < tempList.size(); i++) {
            int holdValue = 0;
            String holdLine = tempList.get(0);

            for (String line : tempList) {
                try {
                    if (holdValue < Integer.parseInt(line.replaceAll("[\\D]", "")) && !highscoreList.contains(line)) {
                        holdValue = Integer.parseInt(line.replaceAll("[\\D]", ""));
                        holdLine = line;
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("error: " + ex);
                }
            }
            highscoreList.add(holdLine);
        }
    }

    //writes the sorted content to the file
    private void writeSortedFile() {
        for (String line : highscoreList) {
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(new File("highscore.txt"), true));
                pw.println(line);
                pw.close();
            } catch (FileNotFoundException f) {
                PrintWriter out;
                try {
                    out = new PrintWriter("highscore.txt");
                    out.println(line);
                    out.close();
                } catch (FileNotFoundException ex) {
                    System.err.println("error: " + ex);
                }
            }
        }
    }

    // prints the sorted highscorelist to the console
    private void printSortedFile() {
        for (String line : highscoreList) {
            System.out.println(line);
        }
    }
}
