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
import org.springframework.web.bind.annotation.RestController;

import com.cts.consumer.entity.Property;
import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.BusinessPropertyRequest;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;
import com.cts.consumer.service.BusinessPropertyService;
import com.cts.consumer.service.ConsumerBusinessService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConsumerController {

	@Autowired
	private ConsumerBusinessService consumerService;

	@Autowired
	private BusinessPropertyService businessPropertyService;

	@PostMapping("/createConsumerBusiness")
	public ResponseEntity<String> createConsumerBusiness(
			@Valid @RequestBody ConsumerBusinessRequest consumerBusinessRequest) throws Exception {
		log.info("Start createConsumerBusiness inside ConsumerController");
		return new ResponseEntity<>(consumerService.createConsumerBusiness(consumerBusinessRequest), HttpStatus.OK);
	}

	@PutMapping("/updateConsumerBusiness")
	public ResponseEntity<String> updateConsumerBusiness(@RequestBody ConsumerBusinessDetails consumerBusinessDetails) {
		log.info("Start updateConsumerBusiness inside ConsumerController");
		log.info("End updateConsumerBusiness inside ConsumerController");
		return new ResponseEntity<>(consumerService.updateConsumerBusiness(consumerBusinessDetails), HttpStatus.OK);

	}

	@GetMapping("/viewConsumerBusiness/{consumerId}")
	public ResponseEntity<?> getConsumerBusiness(@PathVariable("consumerId") long consumerId) {
		log.info("Start getConsumerBusiness inside ConsumerController");

		ConsumerBusinessDetails consumerBusinessDetails = consumerService.getConsumerBusiness(consumerId);
		log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
		log.info("End getConsumerBusiness inside ConsumerController");
		return ResponseEntity.ok(consumerBusinessDetails);
	}

	@PostMapping("/createBusinessProperty")
	public ResponseEntity<String> createBusinessProperty(
			@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest) throws Exception {
		log.info("Start createBusinessProperty inside ConsumerController");
		String response = businessPropertyService.createBusinessProperty(businessPropertyRequest);
		log.debug(response);
		log.info("End createBusinessProperty inside ConsumerController");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/updateBusinessProperty")
	public ResponseEntity<String> updateBusinessProperty(
			@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest) throws ConsumerException {
		log.info("Start updateBusinessProperty inside ConsumerController");
		String response = businessPropertyService.updateBusinessProperty(businessPropertyRequest);
		log.debug(response);
		log.info("End updateBusinessProperty inside ConsumerController");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/viewConsumerProperty/{consumerId}/{propertyId}")
	public Property getBusinessProperty(@PathVariable("consumerId") long consumerId,
			@PathVariable("propertyId") long propertyId) throws ConsumerException {
		log.info("Start getBusinessProperty inside ConsumerController");
		Property property = businessPropertyService.getBusinessProperty(consumerId, propertyId);
		log.debug("Property Details : {}", property);
		log.info("End getBusinessProperty inside ConsumerController");
		return property;
	}

}
