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
	@Column(name = "valueInUsd",nullable =false)
	private double valueInUsd;
	
	public Currency() {}

	public Currency(String name, double valueInUsd) {
		super();
		this.name = name;
		this.valueInUsd = valueInUsd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValueInUsd() {
		return valueInUsd;
	}

	public void setValueInUsd(double valueInUsd) {
		this.valueInUsd = valueInUsd;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", valueInUsd=" + valueInUsd + "]";
	}
	
}
