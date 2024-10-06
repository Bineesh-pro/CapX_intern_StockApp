package com.bineesh.stocklookup.apiservice.model;

import java.util.ArrayList;

public class StockChart {
    public ArrayList<Result> result;
    public Object error;

    public ArrayList<Result> getResult() {
        return result;
    }

    public Object getError() {
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

