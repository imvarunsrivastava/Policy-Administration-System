package com.cts.consumer.service;

import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;

public interface ConsumerBusinessService {

	public ConsumerBusinessDetails createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) throws ConsumerException;
	
	public ConsumerBusinessDetails updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails) throws ConsumerException;
	
	public ConsumerBusinessDetails getConsumerBusiness(long consumerId) throws ConsumerException;

	
}
