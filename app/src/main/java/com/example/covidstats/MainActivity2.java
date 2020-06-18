package com.example.covidstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.covidstats.datafetch.CovidApi;
import com.example.covidstats.datafetch.model.CountryData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView, textView2, casesNumber, critical, deaths, totalTests, todayCases, todayDeaths, textview3, today;
    String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressBar= findViewById(R.id.ProgressCity);
        textView = findViewById(R.id.textview4);
        today = findViewById(R.id.Today);
        textView2 = findViewById(R.id.textview3);
        casesNumber= findViewById(R.id.casesNumber);
        critical=findViewById(R.id.critical);
        deaths=findViewById(R.id.deaths);
        totalTests=findViewById(R.id.totalTests);
        todayCases=findViewById(R.id.todayCases);
        todayDeaths=findViewById(R.id.todayDeaths);
        textview3=findViewById(R.id.textview3);
        Intent intent = getIntent();
        country = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi covidApi = retrofit.create(CovidApi.class);
        covidApi.getCountryData(country)
                .enqueue(new Callback<CountryData>() {
                    @Override
                    public void onResponse(Call<CountryData> call, Response<CountryData> response) {
                      textView.setText(response.body().getCountry() );
                      casesNumber.setVisibility(View.VISIBLE);
                        casesNumber.setText("nombre de cas "+response.body().getCases() );
                        critical.setVisibility(View.VISIBLE);
                        critical.setText("nombre de personnes en réanimations "+ response.body().getCritical());
                        deaths.setVisibility(View.VISIBLE);
                        deaths.setText("nombre de personnes décédées dans le pays "+ response.body().getDeaths());
                        totalTests.setVisibility(View.VISIBLE);
                        totalTests.setText("nombre de tests effectués "+response.body().getTotalTests());
                        todayCases.setVisibility(View.VISIBLE);
                        todayCases.setText("Nombre de cas  " + response.body().getTodayCases());
                        todayDeaths.setVisibility(View.VISIBLE);
                        todayDeaths.setText("nombre de décès "+response.body().getTodayDeaths());
                        progressBar.setVisibility(View.GONE);
                        textview3.setVisibility(View.GONE);
                        today.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onFailure(Call<CountryData> call, Throwable t) {
                        System.out.println(t);
                    }
                });
    }
}