package com.cts.consumer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.consumer.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

	public Optional<Property> findByConsumerIdAndBusinessId(Long consumerId,Long businessId);
	
	public Optional<Property> findByConsumerIdAndPropertyId(Long consumerId,Long propertyId);
	
	boolean existsByInsuranceTypeAndPropertyType(String insuranceType,String propertyType);
}
