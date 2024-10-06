package com.bineesh.stocklookup.apiservice.model;

import java.util.ArrayList;

public class Result {
    public Meta meta;
    public ArrayList<Integer> timestamp;
    public Indicators indicators;

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "Result{" +
                "meta=" + meta +
                ", timestamp=" + timestamp +
                ", indicators=" + indicators +
                '}';
    }

    public ArrayList<Integer> getTimestamp() {
        return timestamp;
    }

    public Indicators getIndicators() {
        return indicators;
    }
}
