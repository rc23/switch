package com.ppbf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String SEPARATOR = ";";

    public static void main(String[] args) {
        try {
            ArrayList<String> lines = readFromFile();
            ArrayList<Integer> sizeOfTrees = new ArrayList<>();

            for (String dataLine : lines) {
                String[] strings = dataLine.split(SEPARATOR);
                for (String res : strings) {
                    sizeOfTrees.add(Integer.parseInt(res));
                }
            }

            // Create one christmas tree per entry in the file with the size of its value

            for (Integer size : sizeOfTrees) {
                String tree = generateChristmasTree(size);

                writeToFile(tree);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> readFromFile() throws FileNotFoundException {
        FileReader reader = new FileReader("resources/src.txt");
        Scanner scanner = new Scanner(reader);

        ArrayList<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        scanner.close();

        return lines;
    }

    private static String generateChristmasTree(int size) {
        String tree = "";

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    tree = tree.concat(" ");
                }
                for (int j = 0; j <= 2 * i; j++) {
                    tree = tree.concat("*");
                }
                tree = tree.concat("\n");
            }
        }

        return tree;
    }

    private static void writeToFile(String content) throws IOException {
        FileWriter writer = new FileWriter("resources/dst.txt", true);
        PrintWriter printer = new PrintWriter(writer);

        printer.print(content);

        printer.close();
    }
}
