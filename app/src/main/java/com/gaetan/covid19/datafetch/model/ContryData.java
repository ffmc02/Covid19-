package com.gaetan.covid19.datafetch.model;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class ContryData{

	@SerializedName("country")
	private String country;

	@SerializedName("recovered")
	private long recovered;

	@SerializedName("cases")
	private long cases;

	@SerializedName("critical")
	private long critical;

	@SerializedName("deathsPerOneMillion")
	private long deathsPerOneMillion;

	@SerializedName("active")
	private int active;

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

	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}

	public void setCases(long cases) {
		this.cases = cases;
	}

	public void setCritical(long critical) {
		this.critical = critical;
	}

	public void setDeathsPerOneMillion(long deathsPerOneMillion) {
		this.deathsPerOneMillion = deathsPerOneMillion;
	}

	public void setCasesPerOneMillion(long casesPerOneMillion) {
		this.casesPerOneMillion = casesPerOneMillion;
	}

	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}

	public void setTestsPerOneMillion(long testsPerOneMillion) {
		this.testsPerOneMillion = testsPerOneMillion;
	}

	public void setTodayCases(long todayCases) {
		this.todayCases = todayCases;
	}

	public void setTodayDeaths(long todayDeaths) {
		this.todayDeaths = todayDeaths;
	}

	public void setTotalTests(long totalTests) {
		this.totalTests = totalTests;
	}

	@NonNull
	@Override
	public String toString() {
		return
				"CountryData{" +
						"Contry =" +country + '\''+
						", recorvered ='" + recovered +'\''+
						", cases='" + cases +'\''+
				"Critical = '" +critical +'\''+
						", Actove = '" + active  +'\''+
				", deathsPerOneMillion=" + deathsPerOneMillion +'\''+
				", deaths= '"+ deaths  +'\''+
				", testesPerMillion ='"	+ testsPerOneMillion  +'\''+
						",todayCases ='" + todayCases+'\''+
						", todayDeaths'" +todayDeaths +'\''+
						", totalTests'" + totalTests+ '\''+
				"}";
	}
}