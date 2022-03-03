package com.cts.consumer.service;

import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.BusinessPropertyRequest;
import com.cts.consumer.payload.response.BusinessPropertyDetails;

public interface BusinessPropertyService {

	public BusinessPropertyDetails createBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws Exception;

	public BusinessPropertyDetails updateBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws ConsumerException;

	public BusinessPropertyDetails getBusinessProperty(long consumerId, long propertyId) throws ConsumerException;
}
