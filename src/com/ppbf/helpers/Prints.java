package com.ppbf.helpers;

import com.ppbf.models.Bet;

public class Prints {

    public static void printMenu() {
        System.out.println("\n1. Write a program to search events by MarketId. (30m)"
            + "\nPrint the result to the console");
        System.out.println("\n2. Write a program to sort event/s by odd value (ascending). (45m)"
            + "\nPrint the result to the console");
        System.out.println("\n3. Write a program to place some bets given TBD money. "
            + "Using the calculateWinners function, calculate the total profit/loss. (60m)"
            + "\nPrint the result to the console");
        System.out.println("\n0. Quit");
        System.out.print("\nChoose menu item: ");
    }

    public static void printResults(long id, Bet foundEvent) {
        System.out.format("\nmarketId - %s \n"
                + "eventName - %s \n"
                + "marketName - %s \n"
                + "matchOdds - %s \n",
            id,
            foundEvent.event.eventName,
            foundEvent.market.marketName,
            foundEvent.market.matchOdds);
    }
}
