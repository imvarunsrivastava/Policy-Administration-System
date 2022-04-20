package com.cts.quotes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.quotes.entity.QuotesMaster;



@Repository
public interface QuotesRepository extends JpaRepository<QuotesMaster,Long> {

	QuotesMaster findByBusinessValueAndPropertyValueAndPropertyType(Long businessValue,Long propertyValue,String propertyType);
}

