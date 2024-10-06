package com.bineesh.stocklookup.apiservice.model;

public class Stock {
    StockChart chart;

    public StockChart getChart() {
        return chart;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "chart=" + chart +
                '}';
    }
}
