package com.ppbf.helpers;

import static com.ppbf.helpers.Mapper.mapToBet;

import com.ppbf.models.Bet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void bubbleSort(List<String> lines) {
        List<Bet> events = new ArrayList<>();

        for (String line : lines) {
            String[] strings = line.split(";");
            com.ppbf.models.Bet bet = mapToBet(strings);
            events.add(bet);
        }

        int n = events.size();
        double temp;
        double[] odds = new double[n];

        for (int i = 0; i < n; i++) {
            odds[i] = events.get(i).market.matchOdds;
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

        System.out.println(Arrays.toString(odds));
    }

    public static void easySort(List<String> lines) {
        List<Bet> events = new ArrayList<>();

        for (String line : lines) {
            String[] strings = line.split(";");
            com.ppbf.models.Bet bet = mapToBet(strings);
            events.add(bet);
        }

        int n = events.size();

        double[] odds = new double[n];

        for (int i = 0; i < n; i++) {
            odds[i] = events.get(i).market.matchOdds;
        }

        Arrays.sort(odds);

        System.out.println(Arrays.toString(odds));
    }
}
