package com.ppbf.helpers;

import com.ppbf.models.Bet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Common {

    public static List<Bet> streamSearch(List<String> lines, long marketId) {
        return getAllBets(lines).stream()
            .filter(bet -> bet.market.marketId == marketId)
            .collect(Collectors.toList());
    }

    public static List<Bet> getAllBets(List<String> lines) {
        return lines.stream()
            .map(line -> line.split(";"))
            .map(stringArray -> new Bet(stringArray))
            .collect(Collectors.toList());
    }

    public static List<Bet> basicSearch(List<String> lines, long marketId) {
        List<Bet> allBets = getAllBets(lines);
        List<Bet> foundMarkets = new ArrayList<>();

        System.out.println(allBets);

        for (Bet bet : allBets) {
            if (bet.market.marketId == marketId) {
                foundMarkets.add(bet);
            }
        }

        return foundMarkets;
    }

    public static double[] bubbleSort(List<String> lines) {
        List<Bet> allBets = getAllBets(lines);

        int n = allBets.size();
        double temp;
        double[] odds = new double[n];

        for (int i = 0; i < n; i++) {
            odds[i] = allBets.get(i).market.matchOdds;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (odds[j - 1] > odds[j]) {
                    temp = odds[j - 1];
                    odds[j - 1] = odds[j];
                    odds[j] = temp;
                }
            }
        }

        return odds;
    }

    public static double[] easySort(List<String> lines) {
        List<Bet> allBets = getAllBets(lines);

        int n = allBets.size();

        double[] odds = new double[n];

        for (int i = 0; i < n; i++) {
            odds[i] = allBets.get(i).market.matchOdds;
        }

        Arrays.sort(odds);

        return odds;
    }
}
