package com.gaetan.covid19.datafetch;

import com.gaetan.covid19.datafetch.model.ContryData;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataProviderService {
    public final String URL = "https://coronavirus-19-api.herokuapp.com/";
    public void getData(String countryName) {
        //creation d'un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi covidApi = retrofit.create(CovidApi.class);
        covidApi.getCountryData("France")
                .enqueue(new Callback<ContryData>() {
                    @Override
                    public void onResponse(Call<ContryData> call, Response<ContryData> response) {
                        System.out.println(response.body());
                    }

                    @Override
                    public void onFailure(Call<ContryData> call, Throwable t) {

                    }
                });
    }
}
