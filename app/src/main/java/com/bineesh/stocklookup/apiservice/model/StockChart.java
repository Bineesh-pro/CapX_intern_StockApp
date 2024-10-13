package com.bineesh.stocklookup.apiservice.model;

import java.util.ArrayList;

public class StockChart {
    public ArrayList<Result> result;
    public StockError error;

    public ArrayList<Result> getResult() {
        return result;
    }

    public StockError getStockError() {
        return error;
    }

    @Override
    public String toString() {
        return "StockChart{" +
                "result=" + result +
                ", error=" + error +
                '}';
    }
}

