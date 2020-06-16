package com.gaetan.covid19.datafetch;

import com.gaetan.covid19.datafetch.model.ContryData;
import com.gaetan.covid19.datafetch.model.CovidDataModel;
import com.gaetan.covid19.datafetch.model.GlobalData;
import com.google.gson.JsonObject;

import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataProviderService {
    public CovidDataModel getData(String countryName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CovidApi covidApi = retrofit.create(CovidApi.class);
// premier Future
        CompletableFuture<GlobalData> callback1 = new CompletableFuture<>();

        covidApi.getGlobalData()
                .enqueue(new Callback<GlobalData>() {
                    @Override
                    public void onResponse(Call<GlobalData> call, Response<GlobalData> response) {
                        callback1.complete(response.body());
                    }

                    @Override
                    public void onFailure(Call<GlobalData> call, Throwable t) {
                        callback1.completeExceptionally(t);
                    }
                });
        // Deuxième Future
        CompletableFuture<ContryData> callback2 = new CompletableFuture<>();

        covidApi.getCountryData(countryName)
                .enqueue(new Callback<ContryData>() {
                    @Override
                    public void onResponse(Call<ContryData> call, Response<ContryData > response) {
                        callback2.complete(response.body());
                    }

                    @Override
                    public void onFailure(Call<ContryData> call, Throwable t) {
                        callback2.completeExceptionally(t);
                    }
                });
// L'obtention des Futures
        GlobalData globalData = callback1.join();
        ContryData contryData = callback2.join();
// retour du model
        return new CovidDataModel(globalData,contryData);
    }
}

