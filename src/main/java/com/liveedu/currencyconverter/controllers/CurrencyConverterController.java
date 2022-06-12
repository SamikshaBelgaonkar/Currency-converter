package com.liveedu.currencyconverter.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import com.liveedu.currencyconverter.models.ConversionCurrency;
import com.liveedu.currencyconverter.models.Currency;
import com.liveedu.currencyconverter.services.CurrencyService;

@RestController
@RequestMapping("/api")
@Slf4j
public class CurrencyConverterController {
private static final Logger log = LoggerFactory.getLogger(CurrencyConverterController.class);
	private CurrencyService currencyService;

	@Autowired
	public CurrencyConverterController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	/**
	 * Below method fetchesAllCurrencies
	 *  @author SAMIKSHA
	 *
	 */
	@GetMapping(path = "/v1/currencies")
	public ResponseEntity<List<Currency>> retrieveAllCurrencies() {
		log.debug("Currency Converter App: Inside retrieveAllCurrencies()");
		return new ResponseEntity<>(this.currencyService.getAllCurrencies(), HttpStatus.OK);
	}

	// converts between two currency
	@PostMapping("/v1/currency-converter")
	public ResponseEntity<Double> convertCurrency(@RequestBody ConversionCurrency conversionCurrency) {
		log.debug("Currency Converter App: Inside convertCurrency()");
		Optional<Double> resultOptional = this.currencyService.convert(conversionCurrency);
		if (resultOptional.isPresent()) {
			return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}

