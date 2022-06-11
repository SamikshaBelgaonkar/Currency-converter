//package com.liveedu.currencyconverter.tasks;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import com.liveedu.currencyconverter.models.Currency;
//import com.liveedu.currencyconverter.models.CurrencyDTO;
//import com.liveedu.currencyconverter.repository.CurrencyRepository;
//
//
//@Component
//public class CurrencyTask {
//
//	@Autowired
//	private CurrencyRepository currencyRepository;
//	
//	//Runs every 5 hour
//	@Scheduled(fixedRate = 5 * 1000 * 60* 60)
//	private void getTaskRates() {
//		try {
//			RestTemplate restTemplate = new RestTemplate();
//			CurrencyDTO forObject = restTemplate.getForObject("http://data.fixer.io/api/latest?access_key=0a5f28039a528338c606d27c78c40e3b", CurrencyDTO.class);
//			forObject.getRates().forEach((key,value)->{
//				Currency currency = new Currency(key,value);
//				this.currencyRepository.save(currency);
//			});
//		}catch(RestClientException ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//}
