package com.bineesh.stocklookup;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bineesh.stocklookup.apiservice.RetrofitClient;
import com.bineesh.stocklookup.apiservice.StockAPI;
import com.bineesh.stocklookup.apiservice.model.Result;
import com.bineesh.stocklookup.apiservice.model.Stock;
import com.bineesh.stocklookup.apiservice.model.StockChart;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView searchButton, companyName, price, changeAndPercent;
    EditText searchQuery;
    CardView stockCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        searchButton = findViewById(R.id.search_click);
        companyName = findViewById(R.id.company_name);
        price = findViewById(R.id.price);
        changeAndPercent = findViewById(R.id.change_and_percent);
        searchQuery = findViewById(R.id.query);
        stockCard = findViewById(R.id.stock_details_card);

        searchButton.setOnClickListener(v -> {

            String query = searchQuery.getText().toString();
            if(query.isEmpty()){
                Toast.makeText(this,"Please provide Stock Symbol",Toast.LENGTH_LONG).show();
            }else {
                Retrofit retrofit = RetrofitClient.getRetrofitInstance();
                StockAPI stockAPI = retrofit.create(StockAPI.class);

                Call<Stock> stockDetails = stockAPI.getStockData(query);
                stockDetails.enqueue(new Callback<Stock>() {
                    @Override
                    public void onResponse(@NonNull Call<Stock> call, @NonNull Response<Stock> response) {
                        System.out.println(call.request().url());
                        Stock stock = response.body();
                        System.out.println(stock);
                    }

                    @Override
                    public void onFailure(@NonNull Call<Stock> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}