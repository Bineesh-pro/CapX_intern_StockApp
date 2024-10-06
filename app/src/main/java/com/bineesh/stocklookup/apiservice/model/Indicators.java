package com.bineesh.stocklookup.apiservice.model;

import java.util.ArrayList;

public class Indicators {
    public ArrayList<Quote> quote;

    public ArrayList<Quote> getQuote() {
        return quote;
    }

    @Override
    public String toString() {
        return "Indicators{" +
                "quote=" + quote +
                '}';
    }
}
