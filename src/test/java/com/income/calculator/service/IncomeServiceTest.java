package com.income.calculator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.income.calculator.utils.CurrencyType;


@SpringBootTest
class IncomeServiceTest {

	@Autowired
	private IncomeService service;
	
	@Test
	void testGetRate() {

		assertNotNull(service.getRate(CurrencyType.EUR));
		assertNotNull(service.getRate(CurrencyType.GBP));
	}

	@Test
	void testGetIncome() {
		
		assertEquals(new BigDecimal(16848.00).setScale(2, RoundingMode.CEILING), 
				service.getIncome(CurrencyType.PLN, new BigDecimal(1000)));
	}

	@Test
	void testGetDeIncome() {
		
		IncomeService mockedService = Mockito.spy(service);
		Mockito.doReturn(new BigDecimal(4.2757)).when(mockedService).getRate(CurrencyType.EUR);
		assertEquals(new BigDecimal(72515.87).setScale(2, RoundingMode.CEILING), 
				service.getIncome(CurrencyType.EUR, new BigDecimal(1000)));
	}
	
	@Test
	void testGetUkIncome() {
		
		IncomeService mockedService = Mockito.spy(service);
		Mockito.doReturn(new BigDecimal(4.9472)).when(mockedService).getRate(CurrencyType.GBP);
		assertEquals(new BigDecimal(79402.56).setScale(2, RoundingMode.CEILING), 
				service.getIncome(CurrencyType.GBP, new BigDecimal(1000)));
	}
	
}
