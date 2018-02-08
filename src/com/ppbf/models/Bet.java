package com.ppbf.models;

public class Bet {

    public Event event;
    public Market market;

    public Bet(Event event, Market market) {
        this.event = event;
        this.market = market;
    }

    @Override
    public String toString() {
        return "Bet{" + "event=" + event + ", market=" + market + '}';
    }
}
