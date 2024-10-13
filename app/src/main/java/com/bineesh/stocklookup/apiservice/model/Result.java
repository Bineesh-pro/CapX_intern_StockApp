package com.bineesh.stocklookup.apiservice.model;

import java.util.ArrayList;

public class Result {
    public Meta meta;
    public ArrayList<Integer> timestamp;
    public Indicators indicators;

    public Meta getMeta() {
        return meta;
    }

}
