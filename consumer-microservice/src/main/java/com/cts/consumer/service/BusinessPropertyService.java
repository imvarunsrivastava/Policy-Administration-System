package com.cts.consumer.service;

import com.cts.consumer.entity.Property;
import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.BusinessPropertyRequest;

public interface BusinessPropertyService {

	public String createBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws Exception;

	public String updateBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws ConsumerException;

	public Property getBusinessProperty(long consumerId, long propertyId) throws ConsumerException;
}
