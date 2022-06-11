package com.liveedu.currencyconverter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liveedu.currencyconverter.models.Currency;
import com.liveedu.currencyconverter.services.CurrencyService;

@RestController
public class CurrencyConverterController {

	
	CurrencyService currencyService;
	@Autowired
	public CurrencyConverterController(CurrencyService currencyService)
	{
		this.currencyService = currencyService;
	}
	
	@GetMapping(path="/currencies")
	public ResponseEntity<List<Currency>> convertCurrency(){
		return new ResponseEntity<>(this.currencyService.getAllCurrencies(),HttpStatus.OK);
	}
}

