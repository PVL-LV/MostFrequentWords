package ua.pvl;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderAndWriter {

    private static  String inPath;
    private static String outPath;
    private static int numberOfChar;
    private static int numberOfWords;

    private static String fullBook = "";

    private static Map<String, Integer> listOfWords = new HashMap<>();

    public FileReaderAndWriter(List<UserParameters> userCommandList) {

        CommandGetter comGetter = new CommandGetter(userCommandList);

        inPath = comGetter.getInPath();
        outPath = comGetter.getOutPath();
        numberOfChar = comGetter.getNumberOfChar();
        numberOfWords = comGetter.getNumberOfWords();

    }

    public void readFile() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inPath));
            String line;

            while ((line = br.readLine()) != null) {
                br.lines();
                fullBook += line + "\r\n";
            }
        } catch (Exception e) {
            System.out.println("Some mistake");
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile()  throws IOException  {

        String[] words = fullBook.split(" ");

        for (String i : words) {
            AddToMap atm = new AddToMap();
            i = i.replaceAll("[^A-Za-zА-Яа-я]", " ");
            i = i.trim();
            i = i.toLowerCase();
            atm.addWordToMap(listOfWords, i);
        }

        MapSort mapSort = new MapSort();
        listOfWords = mapSort.sortByValue(listOfWords);
        listOfWords = mapSort.leftOnlyGivenNumberOfWords(listOfWords, numberOfWords);

        String wfp;
        PrintWriter pw;

        if (outPath != null) {
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(outPath), true), StandardCharsets.UTF_8));

        } else {
            pw = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        }

        try {
            for (Map.Entry<String, Integer> entry : listOfWords.entrySet()) {
                wfp = (entry.getKey() + " = " + entry.getValue() + "\r\n");

                pw.write(wfp);
            }
        }finally {
            pw.flush();
            pw.close();
        }
    }

    public static int getNumberOfChar() {
        return numberOfChar;
    }

}