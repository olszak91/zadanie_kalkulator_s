package com.income.calculator.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

public class Rate {
	
	@DecimalMin(value = "0.01", message = "The income must be positive!")
	private BigDecimal mid;
	
	public Rate() {
		
	}

	public BigDecimal getMid() {
		return mid;
	}

	public void setMid(BigDecimal mid) {
		this.mid = mid;
	}
	
}
