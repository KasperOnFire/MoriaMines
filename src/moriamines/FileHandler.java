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

    //Runs all the methods that makes the highscorelist.
    public static void runHighscore(Player p) {
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);

        tempList.add("Player " + p.getPlayerName() + " earned " + p.getPlayerGold() + " Gold.");
        fileToList();
        sortList();
        addToBuffer(bw);
        writeToFile(sw);

        printHighscore();
    }

    //Reads highscore.txt and adds each line to templist.
    private static void fileToList() {
        try {
            for (String line : Files.readAllLines(Paths.get("highscore.txt"))) {
                tempList.add(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /*Sorts the templist by order of the first int the sentence - playerGold. 
    Adds the highest int first, and then repeats
    could potentially be a RAMkiller if highscorelist was ~10mill lines long or something.
    */
    private static void sortList() {
        for (int i = 0; i < tempList.size(); i++) {
            int holdValue = 0;
            String holdLine = tempList.get(0);

            for (String line2 : tempList) {
                if (holdValue <= Integer.parseInt(line2.replaceAll("[\\D]", "")) && !sortedList.contains(line2)) {
                    holdValue = Integer.parseInt(line2.replaceAll("[\\D]", ""));
                    holdLine = line2;
                }
            }

            sortedList.add(holdLine);
        }
    }

    //Adds the lines in sorted list to a buffer, so they can be written later.
    private static void addToBuffer(BufferedWriter bw) {
        try {
            for (String line3 : sortedList) {
                bw.write(line3);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    //Writes the sorted highscore file
    private static void writeToFile(StringWriter sw) {
        try (Writer osw = (new OutputStreamWriter(new FileOutputStream("highscore.txt"), "utf-8"))) {
            osw.write(sw.getBuffer().toString());
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    //Prints the sorted highscore to the console.
    public static void printHighscore() {
        try {
            System.out.println("*** HIGHSCORES ***");
            for (String highscore : Files.readAllLines(Paths.get("highscore.txt"))) {
                System.out.println(highscore);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
