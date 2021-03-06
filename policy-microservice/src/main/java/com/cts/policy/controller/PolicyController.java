package com.cts.policy.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.policy.client.AuthClient;
import com.cts.policy.exception.ConsumerNotFoundException;
import com.cts.policy.exception.InvalidTokenException;
import com.cts.policy.exception.PolicyException;
import com.cts.policy.payload.request.CreatePolicyRequest;
import com.cts.policy.payload.request.IssuePolicyRequest;
import com.cts.policy.service.PolicyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/policyapi")
@Slf4j
@Api(value = "Policy Details", description = "Policy Details for Agent")
public class PolicyController {

	@Autowired
	private PolicyServiceImpl policyServiceImpl;

	@Autowired
	private AuthClient authClient;

	@ApiOperation(value = "Create policy for consumer")
	@PostMapping("/createPolicy")
	public ResponseEntity<?> createPolicy(@Valid @RequestBody CreatePolicyRequest createPolicyRequest,
			@RequestHeader("Authorization") String token) throws PolicyException,InvalidTokenException{
		log.info("Start Create Policy inside Policy Controller");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End Create Policy inside Policy Controller");
			return new ResponseEntity<>(policyServiceImpl.createPolicy(createPolicyRequest, token), HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End Create Policy inside Policy Controller");
		throw new InvalidTokenException("Token is invalid.");
	}

	@ApiOperation(value = "Issue policy for consumer")
	@PostMapping("/issuePolicy")
	public ResponseEntity<?> issuePolicy(@Valid @RequestBody IssuePolicyRequest issuePolicyRequest,
			@RequestHeader("Authorization") String token) throws PolicyException,InvalidTokenException {
		log.info("Start Issue Policy inside Policy Controller");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End Issue Policy inside Policy Controller");
			return new ResponseEntity<>(policyServiceImpl.issuePolicy(issuePolicyRequest), HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End Issue Policy inside Policy Controller");
		throw new InvalidTokenException("Token is invalid.");
	}

	@ApiOperation(value = "View policy of consumer")
	@GetMapping("/viewPolicy/{consumerId}/{policyId}")
	public ResponseEntity<?> viewPolicy(@PathVariable("consumerId") Long consumerId,
			@PathVariable("policyId") String policyId, @RequestHeader("Authorization") String token)
			throws ConsumerNotFoundException, PolicyException,InvalidTokenException {
		log.info("Start View Policy inside Policy Controller");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End View Policy inside Policy Controller");
			return new ResponseEntity<>(policyServiceImpl.viewPolicy(consumerId, policyId), HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End View Policy inside Policy Controller");
		throw new InvalidTokenException("Token is invalid.");
	}

	@ApiOperation(value = "Get policy Quotes for consumer")
	@GetMapping("/getQuotes")
	public ResponseEntity<?> getQuotes(String businessValue, String propertyValue, String propertyType,
			@RequestHeader("Authorization") String token) throws InvalidTokenException {
		log.info("Start Get Quotes inside Policy Controller");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End Get Quotes inside Policy Controller");
			return new ResponseEntity<>(policyServiceImpl.getQuotes(businessValue, propertyValue, propertyType, token),
					HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End Get Quotes inside Policy Controller");
		throw new InvalidTokenException("Token is invalid.");

	}
}
