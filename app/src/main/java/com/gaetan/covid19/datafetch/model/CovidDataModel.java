package com.gaetan.covid19.datafetch.model;

import androidx.annotation.NonNull;

public class CovidDataModel {
    private GlobalData globalData;
    private ContryData contryData;

    public CovidDataModel(GlobalData globalData, ContryData contryData) {
        this.globalData= globalData;
        this.contryData=contryData;
    }

    public GlobalData getGlobalData() {

        return globalData;
    }

    @NonNull
    @Override
    public String toString() {
        return"CovidDataModel{\n" +
                "globalData="+ globalData +
                "\n contryData= "+contryData +'}';

    }

    public ContryData getContryData() {

        return contryData;
    }
}
