package com.liveedu.currencyconverter.models;

import java.util.Map;

public class CurrencyDTO {

	private String base;
	private Map<String, Double> rates;

	public CurrencyDTO() {
	}

	public CurrencyDTO(String base, Map<String, Double> rates) {
		super();
		this.base = base;
		this.rates = rates;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "CurrencyDTO [base=" + base + ", rates=" + rates + "]";
	}
	
}
