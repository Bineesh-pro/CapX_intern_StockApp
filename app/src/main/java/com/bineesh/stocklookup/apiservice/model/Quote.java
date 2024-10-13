package com.bineesh.stocklookup.apiservice.model;

import java.util.ArrayList;

public class Quote {
    public ArrayList<Integer> volume;

    public ArrayList<Double> open;
    public ArrayList<Double> low;
    public ArrayList<Double> close;
    public ArrayList<Double> high;

    public ArrayList<Integer> getVolume() {
        return volume;
    }

    public ArrayList<Double> getOpen() {
        return open;
    }

    public ArrayList<Double> getLow() {
        return low;
    }

    public ArrayList<Double> getClose() {
        return close;
    }

    public ArrayList<Double> getHigh() {
        return high;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "volume=" + volume +
                ", myopen=" + open +
                ", low=" + low +
                ", close=" + close +
                ", high=" + high +
                '}';
    }
}
