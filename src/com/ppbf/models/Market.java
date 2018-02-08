package com.ppbf.models;

public class Market {

    public String marketName;
    public long marketId;
    public double matchOdds;

    public Market(String marketName, long marketId, double matchOdds) {
        this.marketName = marketName;
        this.marketId = marketId;
        this.matchOdds = matchOdds;
    }

    @Override
    public String toString() {
        return "Market{" + "marketName='" + marketName + '\'' + ", marketId=" + marketId
            + ", matchOdds=" + matchOdds + '}';
    }
}
