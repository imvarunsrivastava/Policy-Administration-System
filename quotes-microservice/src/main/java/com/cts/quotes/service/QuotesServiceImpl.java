package com.cts.quotes.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.quotes.entity.QuotesMaster;
import com.cts.quotes.repository.QuotesRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class QuotesServiceImpl implements QuotesService{

	@Autowired
	private QuotesRepository quotesRepository;
	
	@Transactional
	public String getQuotesForPolicy(Long businessValue, Long propertyValue,String propertyType) {
		log.info("Start Get Quotes For Policy inside Quotes Service");
		String quotes;
		try
        {
		QuotesMaster quotesMaster=quotesRepository
				.findByBusinessValueAndPropertyValueAndPropertyType(businessValue, propertyValue, propertyType);
		log.debug("QuotesMaster: {}", quotesMaster);
		quotes=quotesMaster.getQuotes();
		log.info("End Get Quotes For Policy inside Quotes Service");
        }catch(NullPointerException e) 
        { 
        	quotes= "No Quotes, Contact Insurance Provider";
        	return quotes;  
        } 
		log.info("End");
		return quotes; 
	}
}
