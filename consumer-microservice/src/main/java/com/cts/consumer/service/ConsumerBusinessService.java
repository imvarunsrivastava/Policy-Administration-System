package com.cts.consumer.service;

import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;

public interface ConsumerBusinessService {

	public String createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) throws Exception;
	
	public String updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails) throws ConsumerException;
	
	public ConsumerBusinessDetails getConsumerBusiness(long consumerId) throws ConsumerException;

	
}
