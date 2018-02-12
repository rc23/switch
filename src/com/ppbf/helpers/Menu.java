package com.ppbf.helpers;

public class Menu {

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Write a program to search events by MarketId. Print the result to the console (30m)");
        System.out.println("2. Write a program to sort event/s by odd value (ascending). Print the result to the console (45m)");
        System.out.println("3. Write a program to place some bets given TBD money. Using the calculateWinners function, calculate the total profit/loss. Print the result to the console (60m)");
        System.out.println("0. Quit");
        System.out.print("Choose menu item: ");
    }

    public static void printSubMenu() {
        System.out.println("1. See total cash");
        System.out.println("2. Insert bet");
        System.out.println("0. Quit");
        System.out.print("Choose menu item: ");
    }
}
