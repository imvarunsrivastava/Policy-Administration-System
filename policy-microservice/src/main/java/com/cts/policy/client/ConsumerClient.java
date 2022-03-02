package com.cts.policy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.policy.dto.ConsumerBusinessDetails;

@FeignClient(name="CONSUMER-MICROSERVICE")
public interface ConsumerClient {

	@GetMapping("/viewConsumerBusiness/{consumerId}")
	public ResponseEntity<ConsumerBusinessDetails> getConsumerBusiness(@PathVariable("consumerId") long consumerId);
}
