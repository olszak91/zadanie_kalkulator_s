package com.income.calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.income.calculator.config.Configuration;
import com.income.calculator.exception.NbpResponseException;
import com.income.calculator.model.ExchangeRatesSeries;
import com.income.calculator.utils.CurrencyType;

@Service
public class IncomeService {
	
	private Configuration parameters;
	
	@Autowired
	public IncomeService(Configuration parameters){
	    this.parameters = parameters;
	}
	
	public BigDecimal getRate(CurrencyType currencyType) {
		
		RestTemplateBuilder builder = new RestTemplateBuilder();
		RestTemplate restTemplate = builder.build();
		String currency = "";
		final String requestUrl; 
		
		switch (currencyType) {
			case EUR:
				currency = "eur";
				break;
			case GBP:
				currency = "gbp";
				break;
		}
		
		requestUrl = parameters.getNbpUrl() + currency + "?format=json";
		
		try {
			ExchangeRatesSeries rate = restTemplate.getForObject(requestUrl, ExchangeRatesSeries.class);
			return rate.getRates().get(0).getMid();
		} catch (Exception e) {
			throw new NbpResponseException("Nbp Api doesn't respond");
		}
		
	}
	
	public BigDecimal getIncome(CurrencyType currencyType, BigDecimal dailyIncome) {
		
		BigDecimal income = new BigDecimal(0);
		
		switch (currencyType) {
			case EUR:
				income = ((dailyIncome.multiply(parameters.getNumberOfDays())).subtract(parameters.getGerCosts()))
					.multiply(parameters.getGerWithoutTax()).multiply(getRate(CurrencyType.EUR));
				break;
			case GBP:
				income = ((dailyIncome.multiply(parameters.getNumberOfDays())).subtract(parameters.getUkCosts()))
					.multiply(parameters.getUkWithoutTax()).multiply(getRate(CurrencyType.GBP));
				break;
			case PLN:
				income = ((dailyIncome.multiply(parameters.getNumberOfDays())).subtract(parameters.getPlCosts()))
					.multiply(parameters.getPlWithoutTax());
				break;
		}
		
		return income.setScale(2, RoundingMode.CEILING);
		
	}

	public Configuration getParameters() {
		return parameters;
	}

	
}
