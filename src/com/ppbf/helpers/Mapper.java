package com.ppbf.helpers;

import com.ppbf.models.Bet;
import com.ppbf.models.Event;
import com.ppbf.models.Market;

public class Mapper {

    public static Bet mapToBet(String[] splitLine) {
        return new Bet(
            new Event(splitLine[0]),
            new Market(splitLine[1],
                Long.parseLong(splitLine[2]),
                Double.parseDouble(splitLine[3])));
    }
}
