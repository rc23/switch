package com.ppbf.helpers;

import static com.ppbf.helpers.Mapper.mapToBet;

import com.ppbf.models.Bet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Search {

    public static List<Bet> streamSearch(List<String> lines, long marketId) {
        return lines.stream()
            .map(line -> line.split(";"))
            .map(Mapper::mapToBet)
            .filter(event -> event.market.marketId == marketId)
            .collect(Collectors.toList());
    }

    public static List<Bet> getAllBets(List<String> lines) {
        return lines.stream()
            .map(line -> line.split(";"))
            .map(Mapper::mapToBet)
            .collect(Collectors.toList());
    }

    public static List<Bet> basicSearch(List<String> lines, long marketId) {
        List<Bet> events = new ArrayList<>();

        for (String line : lines) {
            String[] strings = line.split(";");
            Bet bet = mapToBet(strings);
            if (bet.market.marketId == marketId) {
                events.add(bet);
            }
        }

        return events;
    }
}
