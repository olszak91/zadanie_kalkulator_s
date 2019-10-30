package com.income.calculator.config;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("income")
public class Configuration {

	private String nbpUrl;
	private BigDecimal gerCosts;
	private BigDecimal gerWithoutTax;
	private BigDecimal ukCosts;
	private BigDecimal ukWithoutTax;
	private BigDecimal plCosts;
	private BigDecimal plWithoutTax;
	private BigDecimal numberOfDays;
	
	public String getNbpUrl() {
		return nbpUrl;
	}

	public void setNbpUrl(String nbpUrl) {
		this.nbpUrl = nbpUrl;
	}

	public BigDecimal getGerCosts() {
		return gerCosts;
	}

	public void setGerCosts(BigDecimal gerCosts) {
		this.gerCosts = gerCosts;
	}

	public BigDecimal getGerWithoutTax() {
		return gerWithoutTax;
	}

	public void setGerWithoutTax(BigDecimal gerWithoutTax) {
		this.gerWithoutTax = gerWithoutTax;
	}

	public BigDecimal getUkCosts() {
		return ukCosts;
	}

	public void setUkCosts(BigDecimal ukCosts) {
		this.ukCosts = ukCosts;
	}

	public BigDecimal getUkWithoutTax() {
		return ukWithoutTax;
	}

	public void setUkWithoutTax(BigDecimal ukWithoutTax) {
		this.ukWithoutTax = ukWithoutTax;
	}

	public BigDecimal getPlCosts() {
		return plCosts;
	}

	public void setPlCosts(BigDecimal plCosts) {
		this.plCosts = plCosts;
	}

	public BigDecimal getPlWithoutTax() {
		return plWithoutTax;
	}

	public void setPlWithoutTax(BigDecimal plWithoutTax) {
		this.plWithoutTax = plWithoutTax;
	}

	public BigDecimal getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(BigDecimal numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
}
