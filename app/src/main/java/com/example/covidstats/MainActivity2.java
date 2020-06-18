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
    TextView textView, textView2;
    String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressBar= findViewById(R.id.ProgressCity);
        textView = findViewById(R.id.textview4);
        textView2 = findViewById(R.id.textview3);
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
                        textView2.setText(response.body().toString());
                        textView.setText(country);
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<CountryData> call, Throwable t) {
                        System.out.println(t);
                    }
                });
    }
}