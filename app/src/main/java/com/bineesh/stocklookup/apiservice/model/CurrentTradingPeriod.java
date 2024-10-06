package com.bineesh.stocklookup.apiservice.model;

public class CurrentTradingPeriod {
    public Pre pre;
    public Regular regular;
    public Post post;

    public Pre getPre() {
        return pre;
    }

    public Regular getRegular() {
        return regular;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "CurrentTradingPeriod{" +
                "pre=" + pre +
                ", regular=" + regular +
                ", post=" + post +
                '}';
    }
}
