package com.bineesh.stocklookup.apiservice.model;

public class StockError {
    String code;
    String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "StockError{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
