package com.gaetan.covid19;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;

import com.gaetan.covid19.datafetch.DataProviderService;
import com.gaetan.covid19.datafetch.model.CovidDataModel;

public class MainActivity extends AppCompatActivity {
    public final String URL = "https://coronavirus-19-api.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/
        CovidDataModel DataModel= new DataProviderService().getData("France");
        System.out.println(DataModel);
    }
}