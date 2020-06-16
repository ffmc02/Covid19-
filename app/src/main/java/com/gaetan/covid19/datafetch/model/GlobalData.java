package com.gaetan.covid19.datafetch.model;

import androidx.annotation.NonNull;

public class GlobalData{
	private long recovered;
	private long cases;
	private long deaths;

	public long getRecovered() {
		return recovered;
	}

	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}

	public long getCases() {
		return cases;
	}

	public void setCases(long cases) {
		this.cases = cases;
	}

	public long getDeaths() {
		return deaths;
	}

	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}

	@NonNull
	@Override
	public String toString() {
		return "GlobalData{"+
				"cases : "+ cases+
				", deaths: ;"+ deaths+
				", recovered:" + recovered + "}";
	}
}
