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

    public String getExchangeName() {
        return exchangeName;
    }

    public String getFullExchangeName() {
        return fullExchangeName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public int getFirstTradeDate() {
        return firstTradeDate;
    }

    public int getRegularMarketTime() {
        return regularMarketTime;
    }

    public boolean isHasPrePostMarketData() {
        return hasPrePostMarketData;
    }

    public int getGmtoffset() {
        return gmtoffset;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
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

    public int getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }

    public double getChartPreviousClose() {
        return chartPreviousClose;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public int getScale() {
        return scale;
    }

    public int getPriceHint() {
        return priceHint;
    }

    public CurrentTradingPeriod getCurrentTradingPeriod() {
        return currentTradingPeriod;
    }

    public ArrayList<ArrayList<Pre>> getTradingPeriods() {
        return tradingPeriods;
    }

    public String getDataGranularity() {
        return dataGranularity;
    }

    public String getRange() {
        return range;
    }

    public ArrayList<String> getValidRanges() {
        return validRanges;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "currency='" + currency + '\'' +
                ", symbol='" + symbol + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", fullExchangeName='" + fullExchangeName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", firstTradeDate=" + firstTradeDate +
                ", regularMarketTime=" + regularMarketTime +
                ", hasPrePostMarketData=" + hasPrePostMarketData +
                ", gmtoffset=" + gmtoffset +
                ", timezone='" + timezone + '\'' +
                ", exchangeTimezoneName='" + exchangeTimezoneName + '\'' +
                ", regularMarketPrice=" + regularMarketPrice +
                ", fiftyTwoWeekHigh=" + fiftyTwoWeekHigh +
                ", fiftyTwoWeekLow=" + fiftyTwoWeekLow +
                ", regularMarketDayHigh=" + regularMarketDayHigh +
                ", regularMarketDayLow=" + regularMarketDayLow +
                ", regularMarketVolume=" + regularMarketVolume +
                ", longName='" + longName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", chartPreviousClose=" + chartPreviousClose +
                ", previousClose=" + previousClose +
                ", scale=" + scale +
                ", priceHint=" + priceHint +
                ", currentTradingPeriod=" + currentTradingPeriod +
                ", tradingPeriods=" + tradingPeriods +
                ", dataGranularity='" + dataGranularity + '\'' +
                ", range='" + range + '\'' +
                ", validRanges=" + validRanges +
                '}';
    }
}
