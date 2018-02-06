package com.ppbf.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Helpers {

    private static final String SEPARATOR = ";";
    private static final String TREE_LEAF = "^";
    private static final String TREE_BASE = "|";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static String createChristmasTree(int size) {
        String tree = "";

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                tree = concatSpaces(size, tree, i);
                tree = concatHashtag(tree, i);
                tree = tree.concat(NEW_LINE);
            }

            tree = concatSpaces(size, tree, 0);
            tree = tree.concat(TREE_BASE);
            tree = tree.concat(NEW_LINE);
        }

        return tree;
    }

    private static String concatSpaces(int size, String tree, int i) {
        for (int j = i + 1; j < size; j++) {
            tree = tree.concat(SPACE);
        }

        return tree;
    }

    private static String concatHashtag(String tree, int i) {
        for (int j = 0; j <= 2 * i; j++) {
            tree = tree.concat(TREE_LEAF);
        }

        return tree;
    }

    public static ArrayList<Integer> getSizesOfTrees(ArrayList<String> lines) {
        ArrayList<Integer> sizeOfTrees = new ArrayList<>();

        for (String line : lines) {
            String[] strings = line.split(SEPARATOR);
            for (String res : strings) {
                sizeOfTrees.add(Integer.parseInt(res));
            }
        }

        return sizeOfTrees;
    }

    public static ArrayList<String> readFromFile() throws FileNotFoundException {
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

    public static void writeToFile(String content) throws IOException {
        FileWriter writer = new FileWriter("resources/dst.txt", true);
        PrintWriter printer = new PrintWriter(writer);

        printer.print(content);
        printer.print("\n");

        printer.close();
    }

    public int sum(Integer i, Integer j) {
        return i + j;
    }

    public int sum(Integer n) {
        Integer sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int factorial(Integer n) {
        int factorial = n;
        for (int j = n - 1; j > 0; j--) {
            factorial = factorial * j;
        }
        return factorial;
    }

    public int search(Integer n, Integer[] list) {
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(n)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Integer maximum(Integer[] list) {
        int maximum = list[0];
        for (int i : list) {
            if (i > maximum) {
                maximum = i;
            }
        }
        return maximum;
    }

    public Boolean isPrime(Integer n) {
        boolean isPrime = true;
        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public Integer fibonacci(Integer n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public boolean isPalindrome(String word) {
        int i1 = 0;
        int i2 = word.length() - 1;
        while (i2 > i1) {
            if (word.charAt(i1) != word.charAt(i2)) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
