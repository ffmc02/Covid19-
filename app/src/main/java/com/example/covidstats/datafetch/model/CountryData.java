package com.example.covidstats.datafetch.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class CountryData{

    @SerializedName("country")
    private String country;

    @SerializedName("recovered")
    private int recovered;

    @SerializedName("cases")
    private long cases;

    @SerializedName("critical")
    private long critical;

    @SerializedName("deathsPerOneMillion")
    private long deathsPerOneMillion;

    @SerializedName("active")
    private long active;

    @SerializedName("casesPerOneMillion")
    private long casesPerOneMillion;

    @SerializedName("deaths")
    private long deaths;

    @SerializedName("testsPerOneMillion")
    private long testsPerOneMillion;

    @SerializedName("todayCases")
    private long todayCases;

    @SerializedName("todayDeaths")
    private long todayDeaths;

    @SerializedName("totalTests")
    private long totalTests;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(long deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(long casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(long testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(long todayCases) {
        this.todayCases = todayCases;
    }

    public long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(long totalTests) {
        this.totalTests = totalTests;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "\nPays = '" + country +  '\'' +
                "\n nombre de personne rétablie = " + recovered + "Personnes" +
                "\n nombre de cas en " + country +" = " + cases + "Cas" +
                "\n nombre de cas en réanimation  = " + critical + "Cas" +
                "\n décès par million = " + deathsPerOneMillion + "personne décédé" +
                "\nCas par millions = " + casesPerOneMillion
              +" \n"   + deaths +" Décès " +
                "\n Nombre de teste positif   = " + testsPerOneMillion + "testes"+
                "\n nombre de cas AUjourd'hui = " + todayCases +  "Cas" +
                "\n Nombre de décé aujourd'hui = " + todayDeaths + "Décés" +
                "\n Nombre de teste réalisé au total " + totalTests ;
    }
}