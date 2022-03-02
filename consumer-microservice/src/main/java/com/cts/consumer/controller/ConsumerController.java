package com.cts.consumer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.consumer.client.AuthClient;
import com.cts.consumer.entity.Property;
import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.BusinessPropertyRequest;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;
import com.cts.consumer.service.BusinessPropertyService;
import com.cts.consumer.service.ConsumerBusinessService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "ConsumerDetails", description = "Consumer details for Agent")
public class ConsumerController {

	@Autowired
	private ConsumerBusinessService consumerService;

	@Autowired
	private BusinessPropertyService businessPropertyService;

	@Autowired
	private AuthClient authClient;

	@PostMapping("/createConsumerBusiness")
	public ResponseEntity<String> createConsumerBusiness(
			@Valid @RequestBody ConsumerBusinessRequest consumerBusinessRequest,
			@RequestHeader("Authorization") String token) throws Exception {
		log.info("Start createConsumerBusiness inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End createConsumerBusiness inside ConsumerController");
			return new ResponseEntity<>(consumerService.createConsumerBusiness(consumerBusinessRequest), HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End createConsumerBusiness inside ConsumerController");
		return new ResponseEntity<String>("Token is invalid.", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateConsumerBusiness")
	public ResponseEntity<String> updateConsumerBusiness(@RequestBody ConsumerBusinessDetails consumerBusinessDetails,
			@RequestHeader("Authorization") String token) {
		log.info("Start updateConsumerBusiness inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End updateConsumerBusiness inside ConsumerController");
			return new ResponseEntity<>(consumerService.updateConsumerBusiness(consumerBusinessDetails), HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End updateConsumerBusiness inside ConsumerController");
		return new ResponseEntity<String>("Token is invalid.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/viewConsumerBusiness/{consumerId}")
	public ResponseEntity<?> getConsumerBusiness(@PathVariable("consumerId") long consumerId,
			@RequestHeader("Authorization") String token) {
		log.info("Start getConsumerBusiness inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			ConsumerBusinessDetails consumerBusinessDetails = consumerService.getConsumerBusiness(consumerId);
			log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
			log.info("End getConsumerBusiness inside ConsumerController");
			return ResponseEntity.ok(consumerBusinessDetails);
		}
		log.debug("Token is invalid.");
		log.info("End getConsumerBusiness inside ConsumerController");
		return new ResponseEntity<String>("Token is invalid.", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/createBusinessProperty")
	public ResponseEntity<String> createBusinessProperty(
			@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest,
			@RequestHeader("Authorization") String token) throws Exception {
		log.info("Start createBusinessProperty inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			String response = businessPropertyService.createBusinessProperty(businessPropertyRequest);
			log.debug(response);
			log.info("End createBusinessProperty inside ConsumerController");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End createBusinessProperty inside ConsumerController");
		return new ResponseEntity<String>("Token is invalid.", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateBusinessProperty")
	public ResponseEntity<String> updateBusinessProperty(
			@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest,
			@RequestHeader("Authorization") String token) throws ConsumerException {
		log.info("Start updateBusinessProperty inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			String response = businessPropertyService.updateBusinessProperty(businessPropertyRequest);
			log.debug(response);
			log.info("End updateBusinessProperty inside ConsumerController");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End updateBusinessProperty inside ConsumerController");
		return new ResponseEntity<String>("Token is invalid.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/viewConsumerProperty/{consumerId}/{propertyId}")
	public ResponseEntity<?> getBusinessProperty(@PathVariable("consumerId") long consumerId,
			@PathVariable("propertyId") long propertyId, @RequestHeader("Authorization") String token)
			throws ConsumerException {
		log.info("Start getBusinessProperty inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			Property property = businessPropertyService.getBusinessProperty(consumerId, propertyId);
			log.debug("Property Details : {}", property);
			log.info("End getBusinessProperty inside ConsumerController");
			return new ResponseEntity<>(property, HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End updateBusinessProperty inside ConsumerController");
		return new ResponseEntity<String>("Token is invalid.", HttpStatus.BAD_REQUEST);
	}

}
