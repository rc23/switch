package com.ppbf.helpers;

import static com.ppbf.helpers.Menus.printResults;

import com.ppbf.models.Bet;
import com.ppbf.models.Event;
import com.ppbf.models.Market;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Search {

    private static Scanner in = new Scanner(System.in);

    public static void streamSearch(List<String> lines) {
        System.out.print("\nChoose marketId: ");
        long id = in.nextLong();

        List<Bet> foundEvents = lines.stream()
            .map(line -> line.split(";"))
            .map(Search::mapToBet)
            .filter(event -> event.market.marketId == id)
            .collect(Collectors.toList());

        for (Bet event : foundEvents) {
            printResults(id, event);
        }

        if (foundEvents.size() == 0) {
            System.out.format("\nCouldn't find any event with marketId %s\n", id);
        }
    }

    public static void basicSearch(List<String> lines) {
        boolean found = false;

        System.out.print("\nChoose marketId: ");
        long id = in.nextLong();

        List<Bet> events = new ArrayList<>();

        for (String line : lines) {
            String[] strings = line.split(";");
            Bet bet = mapToBet(strings);
            events.add(bet);
        }

        for (Bet event : events) {
            if (event.market.marketId == id) {
                found = true;
                printResults(id, event);
            }
        }

        if (!found) {
            System.out.format("\nCouldn't find any event with marketId %s\n", id);
        }
    }

    private static Bet mapToBet(String[] splitLine) {
        return new Bet(
            new Event(splitLine[0]),
            new Market(splitLine[1],
                Long.parseLong(splitLine[2]),
                Double.parseDouble(splitLine[3])));
    }
}
