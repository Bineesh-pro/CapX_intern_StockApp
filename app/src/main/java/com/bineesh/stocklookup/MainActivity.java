package com.bineesh.stocklookup;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.bineesh.stocklookup.apiservice.model.Meta;
import com.bineesh.stocklookup.apiservice.model.Result;
import com.bineesh.stocklookup.apiservice.model.Stock;
import com.bineesh.stocklookup.apiservice.model.StockChart;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView searchButton, companyName, price, changeAndPercent, stockInfoData, currency, timeZone, preClose, daysRange, fiftyTwoWeeksRange;
    EditText searchQuery;
    CardView stockCard;
    ImageView stockInfoImage;
    ProgressBar progressBar;
    LinearLayout stockInfoLayout;

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
        stockInfoData = findViewById(R.id.info_text);
        stockInfoImage = findViewById(R.id.info_img);
        progressBar = findViewById(R.id.progress_bar);
        stockInfoLayout = findViewById(R.id.info_layout);
        currency = findViewById(R.id.currency);
        timeZone = findViewById(R.id.timezone);
        preClose = findViewById(R.id.pre_close);
        daysRange = findViewById(R.id.days_range);
        fiftyTwoWeeksRange = findViewById(R.id.fifty_two_weeks_range);
        setDefault();

        searchButton.setOnClickListener(v -> {

            String query = searchQuery.getText().toString();
            if(query.isEmpty()){
                setDefault();
                Toast.makeText(this,"Please provide Stock Symbol",Toast.LENGTH_LONG).show();
            }else {
                progressBar.setVisibility(View.VISIBLE);
                stockCard.setVisibility(View.GONE);
                stockInfoLayout.setVisibility(View.GONE);
                Retrofit retrofit = RetrofitClient.getRetrofitInstance();
                StockAPI stockAPI = retrofit.create(StockAPI.class);

                Call<Stock> stockDetails = stockAPI.getStockData(query);
                stockDetails.enqueue(new Callback<Stock>() {
                    @Override
                    public void onResponse(@NonNull Call<Stock> call, @NonNull Response<Stock> response) {
                        progressBar.setVisibility(View.GONE);
                        if(response.body() != null){
                            Stock stock = response.body();
                            if(stock.getChart() != null){
                                StockChart stockChart = stock.getChart();
                                if(stockChart.getStockError() != null){
                                    Toast.makeText(getApplicationContext(),stockChart.getStockError().getDescription(),Toast.LENGTH_LONG).show();
                                    setStockInfo(stockChart.getStockError().getDescription());
                                }else{
                                    Result stockResult = stockChart.getResult().get(0);
                                    Meta meta = stockResult.getMeta();
                                    String compName = meta.getLongName();
                                    if(compName == null || compName.isEmpty()){
                                        compName = meta.getSymbol();
                                    }
                                    companyName.setText(compName);
                                    double amtPre = meta.getChartPreviousClose();
                                    double amtNow = meta.getRegularMarketPrice();
                                    price.setText(String.valueOf(amtNow));
                                    double diff = amtNow - amtPre;
                                    double diffPercent = diff / amtNow * 100;
                                    if(diff > 0){
                                        String s = String.format("+%.2f (+%.2f",diff,diffPercent)+"%)";
                                        changeAndPercent.setText(s);
                                        changeAndPercent.setTextColor(getResources().getColor(R.color.green,getTheme()));
                                    }else{
                                        String s = String.format("%.2f (%.2f",diff,diffPercent)+"%)";
                                        changeAndPercent.setTextColor(getResources().getColor(R.color.red,getTheme()));
                                        changeAndPercent.setText(s);
                                    }

                                    currency.setText(meta.getCurrency());
                                    timeZone.setText(meta.getTimezone());
                                    preClose.setText(String.valueOf(meta.getPreviousClose()));
                                    String dr = meta.getRegularMarketDayLow()+" - "+meta.getRegularMarketDayHigh();
                                    daysRange.setText(dr);
                                    String fw = meta.getFiftyTwoWeekLow()+" - "+meta.getFiftyTwoWeekHigh();
                                    fiftyTwoWeeksRange.setText(fw);

                                    stockCard.setVisibility(View.VISIBLE);
                                }
                            }else{
                                setStockInfo("No Data Found !");
                            }
                        }else{
                            Toast.makeText(getApplicationContext(),"Some thing went wrong",Toast.LENGTH_LONG).show();
                            setStockInfo("Verify input Symbol");
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<Stock> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void setDefault(){
        progressBar.setVisibility(View.GONE);
        stockCard.setVisibility(View.GONE);
        stockInfoImage.setImageResource(R.drawable.stock);
        stockInfoData.setText("Search Stock Details");
        stockInfoLayout.setVisibility(View.VISIBLE);
    }

    private void setStockInfo(String msg){
        progressBar.setVisibility(View.GONE);
        stockCard.setVisibility(View.GONE);
        stockInfoImage.setImageResource(R.drawable.no_data);
        stockInfoData.setText(msg);
        stockInfoLayout.setVisibility(View.VISIBLE);
    }
}