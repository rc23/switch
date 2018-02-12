package com.ppbf.models;

public class Bet {

    public Event event;
    public Market market;

    public Bet(String[] stringArray) {
        this(
            new Event(stringArray[0]),
            new Market(
                stringArray[1],
                Long.parseLong(stringArray[2]),
                Double.parseDouble(stringArray[3]))
        );
    }

    public Bet(Event event, Market market) {
        this.event = event;
        this.market = market;
    }

    @Override
    public String toString() {
        return "Bet{" + "event=" + event + ", market=" + market + '}';
    }
}
