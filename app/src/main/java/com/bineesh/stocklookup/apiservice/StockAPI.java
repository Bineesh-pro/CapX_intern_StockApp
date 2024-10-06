package com.bineesh.stocklookup.apiservice;

import retrofit2.http.GET;
import java.util.List;

public interface StockAPI {
    String BASE_URL = "Bineesh";

    @GET("Bineesh")
    List<String> getStockData(String symbol);
}
