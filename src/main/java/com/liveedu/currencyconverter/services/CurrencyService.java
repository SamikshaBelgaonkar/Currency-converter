package com.liveedu.currencyconverter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.liveedu.currencyconverter.models.Currency;
import com.liveedu.currencyconverter.models.CurrencyDTO;
import com.liveedu.currencyconverter.repository.CurrencyRepository;

@Service
public class CurrencyService {
	private CurrencyRepository currencyRepository;
	@Autowired
	public CurrencyService(CurrencyRepository currencyRepository) {
		
		this.currencyRepository = currencyRepository;
	}
	
	@Cacheable("currency")
	public List<Currency> getAllCurrencies() {
		try {
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

	
}
