package com.ppbf;

import static com.ppbf.helpers.Common.basicSearch;
import static com.ppbf.helpers.Common.bubbleSort;
import static com.ppbf.helpers.Common.getAllBets;
import static com.ppbf.helpers.File.readFromFile;
import static com.ppbf.helpers.Menu.printMenu;
import static com.ppbf.helpers.Menu.printSubMenu;

import com.ppbf.models.Bet;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    //  throws clause vs try-catch block
    //  throws clause    - used to indicate that particular exception is possibly thrown from
    //                     executing method at run-time
    //  try-catch block  - used to handle exception scenario
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Welcome to the Switch Programme Exercise @Blip");

        boolean quit = false;

        do {
            printMenu();

            int menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    // readFromFile returns a List with each entry representing a line of the file.
                    List<String> lines = readFromFile("resources/eventsWithDuplicates.csv");

                    // CODE HERE
                    ex1(lines);

                    break;
                case 2:
                    // readFromFile returns a List with each entry representing a line of the file.
                    lines = readFromFile("resources/eventsWithDuplicates.csv");

                    // CODE HERE
                    ex2(lines);

                    break;
                case 3:
                    // readFromFile returns a List with each entry representing a line of the file.
                    lines = readFromFile("resources/eventsWithDuplicates.csv");

                    // CODE HERE
                    ex3(lines);

                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!quit);

        System.out.println("Bye-bye!");
    }

    private static void ex1(List<String> lines) {
        System.out.print("Choose marketId:");
        long marketId = in.nextLong();

        List<Bet> foundEvents = basicSearch(lines, marketId);

        if (foundEvents.isEmpty()) {
            System.out.format("marketId %s not found", marketId);
            return;
        }

        System.out.println(foundEvents);
    }

    private static void ex2(List<String> lines) {
        double[] sortedOdds = bubbleSort(lines);

        if (sortedOdds.length == 0) {
            System.out.println("Zero markets found");
            return;
        }

        System.out.println(Arrays.toString(sortedOdds));
    }

    private static void ex3(List<String> lines) {
        BigDecimal TOTAL_CASH = new BigDecimal("200.1");

        boolean exit = false;

        do {
            printSubMenu();

            int selection = in.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Total cash:" + TOTAL_CASH + "€");
                    break;
                case 2:
                    System.out.println("Total cash:" + TOTAL_CASH + "€");

                    List<Bet> allEvents = getAllBets(lines);

                    do {
                        System.out.println(allEvents);

                        System.out.println("Choose marketId to bet:");
                        long marketId = in.nextLong();

                        for (Bet event : allEvents) {
                            if (event.market.marketId == marketId) {
                                System.out.print("Choose amount to bet:");

                                BigDecimal amount = in.nextBigDecimal();

                                HashMap<Long, BigDecimal> bets = new HashMap<>();

                                if (TOTAL_CASH.subtract(amount)
                                    .compareTo(BigDecimal.ZERO) >= 0) {

                                    bets.put(marketId, amount);
                                    TOTAL_CASH = TOTAL_CASH.subtract(amount);
                                } else {
                                    System.out.println("Not enough cash in wallet");
                                }
                            }
                        }

                        System.out.println("Total cash:" + TOTAL_CASH + "€");

                    } while (TOTAL_CASH.compareTo(BigDecimal.ZERO) > 0);

                    break;
                default:
                    exit = true;
                    break;
            }
        } while (!exit);
    }
}
