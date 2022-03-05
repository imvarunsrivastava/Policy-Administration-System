package com.cts.policy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.policy.payload.response.QuotesResponse;

@FeignClient(name="QUOTES-MICROSERVICE")
public interface QuotesClient {

	@GetMapping("/quotesapi/getQuotesForPolicy")
	public  ResponseEntity<QuotesResponse> getQuotesForPolicy(@RequestParam("businessValue") String businessValue, 
			@RequestParam("propertyValue") String propertyValue, @RequestParam("propertyType") String propertyType,
			@RequestHeader("Authorization") String token);
}
