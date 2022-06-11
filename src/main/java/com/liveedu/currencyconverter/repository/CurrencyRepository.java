package com.liveedu.currencyconverter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.liveedu.currencyconverter.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String>{

	List<Currency> findAll();
}
