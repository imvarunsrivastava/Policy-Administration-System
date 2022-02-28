package com.cts.consumer.service;

import com.cts.consumer.exception.ConsumerNotFoundException;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;

public interface ConsumerService {

	public String createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) throws Exception;
	
	public String updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails);
	
	public ConsumerBusinessDetails getConsumerBusiness(long consumerId) throws ConsumerNotFoundException;
}
