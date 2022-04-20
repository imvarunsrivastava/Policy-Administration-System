package com.cts.app.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.app.payload.request.CreatePolicyRequest;
import com.cts.app.payload.request.IssuePolicyRequest;
import com.cts.app.payload.response.ConsumerPolicyResponse;
import com.cts.app.payload.response.PolicyDetailsResponse;

import feign.Headers;

@Headers("Content-Type: app/json")
@FeignClient(name = "policy-microservice")
public interface FeignPolicyClient {

	@PostMapping("/policyapi/createPolicy")
	public ResponseEntity<?> createPolicy(@RequestHeader("Authorization") String token,
			@RequestBody CreatePolicyRequest createPolicyRequest);

	@PostMapping("/policyapi/issuePolicy")
	public ResponseEntity<?> issuePolicy(@RequestHeader("Authorization") String token,
			@RequestBody IssuePolicyRequest issuePolicyRequest);

	@GetMapping("/policyapi/viewPolicy/{consumerId}/{policyId}")
	public PolicyDetailsResponse viewPolicy(@RequestHeader("Authorization") String token,
			@PathVariable("consumerId") Long consumerId, @PathVariable("policyId") String policyId);

	@GetMapping("/policyapi/viewPolicy/{consumerId}")
	public ConsumerPolicyResponse viewPolicy(@PathVariable("consumerId") Long consumerId,
			@RequestHeader("Authorization") String token);
}
