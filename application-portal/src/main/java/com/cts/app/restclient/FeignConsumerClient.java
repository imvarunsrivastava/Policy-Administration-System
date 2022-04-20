package com.cts.app.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.app.payload.request.BusinessPropertyRequest;
import com.cts.app.payload.request.ConsumerBusinessRequest;
import com.cts.app.payload.response.BusinessPropertyDetails;
import com.cts.app.payload.response.ConsumerBusinessDetails;

import feign.Headers;

@Headers("Content-Type: application/json")
@FeignClient(name = "consumer-microservice")
public interface FeignConsumerClient {

	@PostMapping("/consumer/consumerbusiness")
	public ResponseEntity<?> createConsumerBusiness(@RequestHeader("Authorization") String token,
			@RequestBody ConsumerBusinessRequest consumerBusinessRequest);

	@PutMapping("/consumer/consumerbusiness")
	public ResponseEntity<?> updateConsumerBusiness(@RequestHeader("Authorization") String token,
			@RequestBody ConsumerBusinessDetails consumerBusinessDetails);

	@GetMapping("/consumer/consumerbusiness/{consumerId}")
	public ConsumerBusinessDetails getConsumerBusiness(@RequestHeader("Authorization") String token,
			@PathVariable("consumerId") Long consumerid);

	@GetMapping("/consumer/consumerbusiness")
	public List<ConsumerBusinessDetails> getAllConsumerBusiness(@RequestHeader("Authorization") String token);

	@PostMapping("/consumer/consumerproperty")
	public ResponseEntity<?> createBusinessProperty(@RequestHeader("Authorization") String token,
			@RequestBody BusinessPropertyRequest businessPropertyRequest);

	@PutMapping("/consumer/consumerproperty")
	public ResponseEntity<?> updateBusinessProperty(@RequestHeader("Authorization") String token,
			@RequestBody BusinessPropertyDetails businessPropertyDetails);

	@GetMapping("/consumer/consumerproperty/{consumerId}/{propertyId}")
	public BusinessPropertyDetails getBusinessProperty(@RequestHeader("Authorization") String token,
			@PathVariable Long consumerId, @PathVariable Long propertyId);

	@GetMapping("/consumer/consumerproperty")
	public List<BusinessPropertyDetails> getAllBusinessProperty(@RequestHeader("Authorization") String token);

}
