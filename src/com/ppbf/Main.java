package com.ppbf;

import static com.ppbf.helpers.File.readFromFile;
import static com.ppbf.helpers.Menus.printMenu;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to the Switch Programme Exercise @Blip");

        boolean quit = false;
        int menuItem;

        do {
            printMenu();

            menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    try {
                        // 1. Write a program to search events by MarketId. (30m)
                        //    Print the result to the console

                        // Read from file
                        List<String> lines = readFromFile("resources/events.txt");

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    try {
                        // 2. Write a program to sort event/s by odd value (ascending). (45m)
                        //    Print the result to the console

                        // Read from file
                        List<String> lines = readFromFile("resources/events.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    try {
                        // 3. Write a program to place some bets given TBD money.
                        //    Using the calculateWinners function, calculate the total
                        //    profit/loss. (60m)
                        //    Print the result to the console

                        // Read from file
                        List<String> lines = readFromFile("resources/events.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

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
