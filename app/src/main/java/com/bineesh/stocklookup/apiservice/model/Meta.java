package com.bineesh.stocklookup.apiservice.model;

import java.util.ArrayList;

public class Meta {
    public String currency;
    public String symbol;
    public String exchangeName;
    public String fullExchangeName;
    public String instrumentType;
    public int firstTradeDate;
    public int regularMarketTime;
    public boolean hasPrePostMarketData;
    public int gmtoffset;
    public String timezone;
    public String exchangeTimezoneName;
    public double regularMarketPrice;
    public double fiftyTwoWeekHigh;
    public double fiftyTwoWeekLow;
    public double regularMarketDayHigh;
    public double regularMarketDayLow;
    public int regularMarketVolume;
    public String longName;
    public String shortName;
    public double chartPreviousClose;
    public double previousClose;
    public int scale;
    public int priceHint;
    public CurrentTradingPeriod currentTradingPeriod;
    public ArrayList<ArrayList<Pre>> tradingPeriods;
    public String dataGranularity;
    public String range;
    public ArrayList<String> validRanges;

    public String getCurrency() {
        return currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getTimezone() {
        return timezone;
    }


    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public String getLongName() {
        return longName;
    }

    public double getChartPreviousClose() {
        return chartPreviousClose;
    }

    public double getPreviousClose() {
        return previousClose;
    }


}
