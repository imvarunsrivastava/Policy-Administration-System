package com.cts.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.consumer.entity.PropertyMaster;

@Repository
public interface PropertyMasterRepository extends JpaRepository<PropertyMaster, Long>{

	public PropertyMaster findByInsuranceTypeAndPropertyType(String insuranceType,String propertyType); 
}
