package com.liveedu.currencyconverter.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.liveedu.currencyconverter.models.ConversionCurrency;
import com.liveedu.currencyconverter.models.Currency;
import com.liveedu.currencyconverter.models.CurrencyDTO;
import com.liveedu.currencyconverter.repository.CurrencyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CurrencyService {
	private static final Logger log = LoggerFactory.getLogger(CurrencyService.class);
	@Autowired
	private CurrencyRepository currencyRepository;
	@Value("${api-key}")
	private String url;

	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}

	/**
	 * Below method fetchesAllCurrencies
	 * calls to exchangeRateApi(http://localhost:8090/api/currencies')
	 * Enabled default caching.
	 * @author SAMIKSHA
	 *
	 */
	@Cacheable("currency")
	public List<Currency> getAllCurrencies() {
		log.debug("Currency Converter App : Inside getAllCurrencies");
		try {
			//just to ensure we are making use of cache.
			 System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
		      Thread.sleep(1000*5);
			RestTemplate restTemplate = new RestTemplate();
			CurrencyDTO forObject = restTemplate.getForObject("http://data.fixer.io/api/latest?access_key=0a5f28039a528338c606d27c78c40e3b", CurrencyDTO.class);
			forObject.getRates().forEach((key,value)->{
				Currency currency = new Currency(key,value);
				this.currencyRepository.save(currency);
			});
			
		}catch(RestClientException | InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
		
		return this.currencyRepository.findAll();
	}
	

	/**
	 * Below method is responsible for converting currency.
	 * call repo and converts amount.
	 * @author SAMIKSHA
	 *
	 */
	public Optional<Double> convert(ConversionCurrency conversionCurrency) {
		log.debug("Currency Converter App : Inside convert()");
		Optional<Currency> toOptional = this.currencyRepository.findById(conversionCurrency.getTo().toUpperCase());
		Optional<Currency> fromOptional = this.currencyRepository.findById(conversionCurrency.getFrom().toUpperCase());
		if (toOptional.isPresent() && fromOptional.isPresent()) {
			if (conversionCurrency.getValue() < 0) {
				log.info("Currency Converter App : Currency provided is invalid");
				return Optional.empty();
			}
			Double result = toOptional.get().getValueInEuros() * conversionCurrency.getValue()
					/ fromOptional.get().getValueInEuros();
			return Optional.of(result);
		}
		return Optional.empty();
	}

	private void callExchangeRateApi() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate = new RestTemplateBuilder().build();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		try {
			log.debug("Currency Converter App : Calling exchangeRateAPI - http://localhost:8090/api/currencies(Forex)");
			CurrencyDTO response = restTemplate.getForObject(url, CurrencyDTO.class);
			response.getRates().forEach((name, valueInEuros) -> {
				Currency currency = new Currency(name, valueInEuros);
				this.currencyRepository.save(currency);
			});
		} catch (RestClientException ex) {
			log.error("Currency Converter App : Error calling exchangeRateAPI", ex.getMessage());
			throw new RuntimeException("Currency Converter App : Error calling exchangeRateAPI");
		}
	}
	
}
