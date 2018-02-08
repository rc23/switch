package com.ppbf;

import static com.ppbf.helpers.File.readFromFile;
import static com.ppbf.helpers.Menus.printMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to the Switch Programme Exercise @Blip\n");

        boolean quit = false;
        int menuItem;

        do {
            printMenu();

            menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    try {
                        // Write a program to search events by MarketId and print its info. (30m)

                        // Read from file
                        List<String> lines = readFromFile("resources/events.txt");

                        // Search by marketId
                        // TODO

                        // Print the results
                        // TODO

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("\nInvalid choice.");
            }
        } while (!quit);

        System.out.println("\nBye-bye!");
    }
}
