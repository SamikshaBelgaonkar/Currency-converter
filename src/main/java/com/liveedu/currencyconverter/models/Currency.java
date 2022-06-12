package com.liveedu.currencyconverter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Currency")
public class Currency {

	@Id
	private String name;
	@Column(name = "valueInEuros", nullable = false)
	private double valueInEuros;

	public Currency() {
	}

	public Currency(String name, double valueInEuros) {
		super();
		this.name = name;
		this.valueInEuros = valueInEuros;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValueInEuros() {
		return valueInEuros;
	}

	public void setValueInEuros(double valueInUsd) {
		this.valueInEuros = valueInUsd;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", valueInEuros=" + valueInEuros + "]";
	}
	
}
