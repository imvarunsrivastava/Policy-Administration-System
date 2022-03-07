package com.cts.consumer.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.consumer.client.AuthClient;
import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.exception.InvalidTokenException;
import com.cts.consumer.payload.request.BusinessPropertyRequest;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.BusinessPropertyDetails;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;
import com.cts.consumer.service.BusinessPropertyService;
import com.cts.consumer.service.ConsumerBusinessService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/consumer")
@Api(value = "ConsumerDetails", description = "Consumer details for Agent")
public class ConsumerController {

	@Autowired
	private ConsumerBusinessService consumerService;

	@Autowired
	private BusinessPropertyService businessPropertyService;

	@Autowired
	private AuthClient authClient;

	@PostMapping("/consumerbusiness")
	public ResponseEntity<?> createConsumerBusiness(@Valid @RequestBody ConsumerBusinessRequest consumerBusinessRequest,
			@RequestHeader("Authorization") String token) throws ConsumerException,InvalidTokenException {
		log.info("Start createConsumerBusiness inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End createConsumerBusiness inside ConsumerController");
			ConsumerBusinessDetails consumerBusinessDetails = consumerService
					.createConsumerBusiness(consumerBusinessRequest);
			return new ResponseEntity<>(consumerBusinessDetails, HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End createConsumerBusiness inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}

	@PutMapping("/consumerbusiness")
	public ResponseEntity<?> updateConsumerBusiness(@RequestBody ConsumerBusinessDetails consumerBusinessDetails,
			@RequestHeader("Authorization") String token) throws ConsumerException,InvalidTokenException {
		log.info("Start updateConsumerBusiness inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End updateConsumerBusiness inside ConsumerController");
			consumerBusinessDetails = consumerService.updateConsumerBusiness(consumerBusinessDetails);
			if (consumerBusinessDetails != null)
				return new ResponseEntity<>(consumerBusinessDetails, HttpStatus.OK);
			throw new ConsumerException("Sorry!!, Consumer is Not Eligibile for Insurance");
		}
		log.debug("Token is invalid.");
		log.info("End updateConsumerBusiness inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}

	@GetMapping("/consumerbusiness")
	public ResponseEntity<?> getAllConsumerBusiness(@RequestHeader("Authorization") String token) throws InvalidTokenException {
		log.info("Start getAllConsumerBusiness inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			List<ConsumerBusinessDetails> consumerBusinessDetails = consumerService.getAllConsumerBusiness();
			log.debug("ConsumerBusiness  List : {}", consumerBusinessDetails);
			log.info("End getAllConsumerBusiness inside ConsumerController");
			return ResponseEntity.ok(consumerBusinessDetails);
		}
		log.debug("Token is invalid.");
		log.info("End getAllConsumerBusiness inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}
	
	@GetMapping("/consumerbusiness/{consumerId}")
	public ResponseEntity<?> getConsumerBusiness(@PathVariable("consumerId") long consumerId,
			@RequestHeader("Authorization") String token) throws InvalidTokenException {
		log.info("Start getConsumerBusiness inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			ConsumerBusinessDetails consumerBusinessDetails = consumerService.getConsumerBusiness(consumerId);
			log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
			log.info("End getConsumerBusiness inside ConsumerController");
			return ResponseEntity.ok(consumerBusinessDetails);
		}
		log.debug("Token is invalid.");
		log.info("End getConsumerBusiness inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}

	@PostMapping("/consumerproperty")
	public ResponseEntity<?> createBusinessProperty(@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest,
			@RequestHeader("Authorization") String token) throws ConsumerException,InvalidTokenException  {
		log.info("Start createBusinessProperty inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			BusinessPropertyDetails businessPropertyDetails = businessPropertyService
					.createBusinessProperty(businessPropertyRequest);
			log.debug("BusinessPropertyDetails :{}", businessPropertyDetails);
			log.info("End createBusinessProperty inside ConsumerController");
			if (businessPropertyDetails != null)
				return new ResponseEntity<>(businessPropertyDetails, HttpStatus.OK);
			throw new ConsumerException("Sorry!!, Your Business Property is Not Eligibile for Insurance.");
		}
		log.debug("Token is invalid.");
		log.info("End createBusinessProperty inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}

	@PutMapping("/consumerproperty")
	public ResponseEntity<?> updateBusinessProperty(@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest,
			@RequestHeader("Authorization") String token) throws ConsumerException,InvalidTokenException  {
		log.info("Start updateBusinessProperty inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			BusinessPropertyDetails businessPropertyDetails = businessPropertyService
					.updateBusinessProperty(businessPropertyRequest);
			log.info("End updateBusinessProperty inside ConsumerController");
			if (businessPropertyDetails != null)
				return new ResponseEntity<>(businessPropertyDetails, HttpStatus.OK);
			throw new ConsumerException("Sorry!!, Your Business Property is Not Eligibile for Insurance.");
		}
		log.debug("Token is invalid.");
		log.info("End updateBusinessProperty inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}
	
	@GetMapping("/consumerproperty")
	public ResponseEntity<?> getAllBusinessProperty(@RequestHeader("Authorization") String token)throws InvalidTokenException 
		{
		log.info("Start getAllBusinessProperty inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			List<BusinessPropertyDetails> businessPropertyDetails = businessPropertyService.getAllBusinessProperty();
			log.debug("BusinessPropertyDetails : {}", businessPropertyDetails);
			log.info("End getBusinessProperty inside ConsumerController");
			return new ResponseEntity<>(businessPropertyDetails, HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End getAllBusinessProperty inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}

	@GetMapping("/consumerproperty/{consumerId}/{propertyId}")
	public ResponseEntity<?> getBusinessProperty(@PathVariable("consumerId") long consumerId,
			@PathVariable("propertyId") long propertyId, @RequestHeader("Authorization") String token)
			throws ConsumerException,InvalidTokenException {
		log.info("Start getBusinessProperty inside ConsumerController");
		if (authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			BusinessPropertyDetails businessPropertyDetails = businessPropertyService.getBusinessProperty(consumerId,
					propertyId);
			log.debug("BusinessPropertyDetails : {}", businessPropertyDetails);
			log.info("End getBusinessProperty inside ConsumerController");
			return new ResponseEntity<>(businessPropertyDetails, HttpStatus.OK);
		}
		log.debug("Token is invalid.");
		log.info("End getBusinessProperty inside ConsumerController");
		throw new InvalidTokenException("Token is invalid.");
	}
	
	

}
