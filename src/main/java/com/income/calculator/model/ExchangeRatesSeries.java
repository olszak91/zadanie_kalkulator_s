package com.income.calculator.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesSeries {

	private String currency;
	private String code;
	private List<Rate> rates;
	
	public ExchangeRatesSeries() {
		
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	
}
