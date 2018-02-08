package com.ppbf.helpers;

import com.ppbf.models.Bet;

public class Menus {

    public static void printMenu() {
        System.out.println("\n1. Write a program that uses the readFromFile function. "
            + "It should receive an id and return the corresponding MarketName/s (30m)");
        System.out.println("\n2. TBD");
        System.out.println("\n3. TBD");
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
