package com.ppbf;

import static com.ppbf.helpers.File.readFromFile;
import static com.ppbf.helpers.Prints.printMenu;
import static com.ppbf.helpers.Prints.printResults;
import static com.ppbf.helpers.Search.getAllBets;
import static com.ppbf.helpers.Search.streamSearch;
import static com.ppbf.helpers.Sort.easySort;

import com.ppbf.models.Bet;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to the Switch Programme Exercise @Blip");

        boolean quit = false;

        do {
            printMenu();

            int menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    try {
                        // 1. Write a program to search events by MarketId. (45m)
                        //    Print the result to the console

                        // Read from file
                        List<String> lines = readFromFile("resources/eventsWithDuplicates.csv");

                        System.out.print("\nChoose marketId: ");
                        long marketId = in.nextLong();

                        List<Bet> foundEvents = streamSearch(lines, marketId);

                        if (foundEvents.isEmpty()) {
                            System.out
                                .format("\nCouldn't find any event with marketId %s\n", marketId);
                        } else {
                            for (Bet event : foundEvents) {
                                printResults(marketId, event);
                            }
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    try {
                        // 2. Write a program to sort event/s by odd value (ascending).
                        //    Custom sorting mechanism brings added value (30m)
                        //    Print the result to the console

                        // Read from file
                        List<String> lines = readFromFile("resources/eventsWithDuplicates.csv");

                        easySort(lines);

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
                        List<String> lines = readFromFile("resources/eventsWithDuplicates.csv");

                        double totalAmount = 200.1;

                        System.out.print("\nChoose marketId to bet: ");
                        long marketId = in.nextLong();

                        List<Bet> foundEvents = getAllBets(lines);

                        for (Bet foundEvent : foundEvents) {
                            if (foundEvent.market.marketId == marketId) {

                                System.out.print("\nChoose amount to bet: ");
                                double amount = in.nextDouble();

                                HashMap<Long, Double> bets = new HashMap<>();

                                if (totalAmount - amount > 0) {
                                    bets.put(marketId, amount);
                                    totalAmount -= amount;
                                }
                            }
                        }

                        System.out.println(totalAmount);

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
