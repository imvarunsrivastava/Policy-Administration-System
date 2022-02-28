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

import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;
import com.cts.consumer.repository.BusinessRepository;
import com.cts.consumer.repository.ConsumerRepository;
import com.cts.consumer.service.ConsumerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@PostMapping("/createConsumerBusiness")
	public ResponseEntity<String> createConsumerBusiness(
			@Valid @RequestBody ConsumerBusinessRequest consumerBusinessRequest) throws Exception {
		log.info("Start createConsumerBusiness inside ConsumerController");
		return new ResponseEntity<>(consumerService.createConsumerBusiness(consumerBusinessRequest), HttpStatus.OK);
	}

	@PutMapping("/updateConsumerBusiness")
	public ResponseEntity<String> updateConsumerBusiness(@RequestBody ConsumerBusinessDetails consumerBusinessDetails) {
		log.info("Start updateConsumerBusiness inside ConsumerController");

		if (!consumerRepository.existsById(consumerBusinessDetails.getConsumerId())) {
			return new ResponseEntity<>("Sorry!!, No Consumer Found!!", HttpStatus.OK);
		}
		if (!businessRepository.existsByConsumerId(consumerBusinessDetails.getConsumerId())) {
			return new ResponseEntity<>("Sorry!!, No Business Found!!", HttpStatus.OK);
		}
		if (!businessRepository.existsById(consumerBusinessDetails.getBusinessId())) {
			return new ResponseEntity<>("Sorry!!, No Business Found!!", HttpStatus.OK);
		}
		log.info("End updateConsumerBusiness inside ConsumerController");
		return new ResponseEntity<>(consumerService.updateConsumerBusiness(consumerBusinessDetails), HttpStatus.OK);

	}

	@GetMapping("/viewConsumerBusiness/{consumerId}")
	public ResponseEntity<?> getConsumerBusiness(@PathVariable("consumerId") long consumerId) {
		log.info("Start getConsumerBusiness inside ConsumerController");
		if (!consumerRepository.existsById(consumerId)) {
			return ResponseEntity.badRequest().body("Sorry!!, No Consumer Found!!");
		}
		if (!businessRepository.existsByConsumerId(consumerId)) {
			return ResponseEntity.badRequest().body("Sorry!!, No Business Found!!");
		}
		ConsumerBusinessDetails consumerBusinessDetails = consumerService.getConsumerBusiness(consumerId);
		log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
		log.info("End getConsumerBusiness inside ConsumerController");
		return ResponseEntity.ok(consumerBusinessDetails);
	}

}
