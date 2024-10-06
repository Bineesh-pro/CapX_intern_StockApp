package com.bineesh.stocklookup.apiservice;

import com.bineesh.stocklookup.apiservice.model.Stock;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface StockAPI {
    String BASE_URL = "https://query1.finance.yahoo.com/v8/finance/";

    @GET("chart/{symbol}")
    Call<Stock> getStockData(@Path("symbol") String symbol);
}
