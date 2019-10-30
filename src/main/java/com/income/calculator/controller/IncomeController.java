package com.income.calculator.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.income.calculator.config.Configuration;
import com.income.calculator.model.Rate;
import com.income.calculator.service.IncomeService;
import com.income.calculator.utils.CurrencyType;

@Controller
public class IncomeController {

	@Autowired
	private IncomeService service;
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/income")
	public String getIncomePage(Model model) {
		model.addAttribute("rate", new Rate());
		return "insert-income-page";
	}
	
	@PostMapping("/processForm")
	public String showIncomes(@Valid @ModelAttribute("rate") Rate income, BindingResult theBindingResult, Model model) {
		
		if (theBindingResult.hasErrors()) {
			return "insert-income-page";
		}
		
		BigDecimal dailyIncome = income.getMid();
		
		model.addAttribute("deIncome", service.getIncome(CurrencyType.EUR, dailyIncome));
		model.addAttribute("ukIncome", service.getIncome(CurrencyType.GBP, dailyIncome));
		model.addAttribute("plIncome", service.getIncome(CurrencyType.PLN, dailyIncome));
		
		return "output-page";
	}
	
}
