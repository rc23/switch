package com.ppbf;

import com.ppbf.helpers.Helpers;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            createTrees();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createTrees() throws IOException {
        ArrayList<String> lines = Helpers.readFromFile();

        ArrayList<Integer> sizesOfTrees = Helpers.getSizesOfTrees(lines);

        for (Integer size : sizesOfTrees) {
            String tree = Helpers.createChristmasTree(size);

            Helpers.writeToFile(tree);
        }
    }
}
