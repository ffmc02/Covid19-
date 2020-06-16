package com.gaetan.covid19.datafetch;

import com.gaetan.covid19.datafetch.model.ContryData;
import com.gaetan.covid19.datafetch.model.GlobalData;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidApi {

        // la requête get pour avoir toutes les infos
        @GET("https://coronavirus-19-api.herokuapp.com/all")
        Call<GlobalData> getGlobalData();
        //La requête pour avoir uniquement le pays qui nous intéresse
        @GET("https://coronavirus-19-api.herokuapp.com/countries/{countryName}")
        Call<ContryData> getCountryData(@Path(value="countryName") String countryName);


       // Call<JsonObject> getCountryData();
}

