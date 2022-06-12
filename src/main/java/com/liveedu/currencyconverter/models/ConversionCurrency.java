package com.liveedu.currencyconverter.models;
/**
 * TODO: Need to make use of lombok annotations
 * in order to get rid of getters, settes
 * @author SAMIKSHA
 *
 */
public class ConversionCurrency {

	private String to;
	private String from;
	private double value;
	public ConversionCurrency() {
		super();
	}
	public ConversionCurrency(String to, String from, double value) {
		super();
		this.to = to;
		this.from = from;
		this.value = value;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ConversionCurrency [to=" + to + ", from=" + from + ", value=" + value + "]";
	}
	
}
