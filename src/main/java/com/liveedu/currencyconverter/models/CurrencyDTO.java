package com.liveedu.currencyconverter.models;

import java.util.Map;

public class CurrencyDTO {

	private boolean success;
	private long timstamp;
	private String base;
	private String date;
	private Map<String, Double> rates;
	
	public CurrencyDTO() {}
	
	public CurrencyDTO(boolean success, long timstamp, String base, String date, Map<String, Double> rates) {
		super();
		this.success = success;
		this.timstamp = timstamp;
		this.base = base;
		this.date = date;
		this.rates = rates;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTimstamp() {
		return timstamp;
	}

	public void setTimstamp(long timstamp) {
		this.timstamp = timstamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "CurrencyDTO [success=" + success + ", timstamp=" + timstamp + ", base=" + base + ", date=" + date
				+ ", rates=" + rates + "]";
	}
	
}
