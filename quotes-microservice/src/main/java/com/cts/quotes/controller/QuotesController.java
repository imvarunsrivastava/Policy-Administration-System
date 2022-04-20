package com.cts.quotes.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.quotes.client.AuthClient;
import com.cts.quotes.request.QuotesRequest;
import com.cts.quotes.service.QuotesServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/quotesapi")
@Slf4j
@Api(value="Quotes Details",description="Quotes Details for Agent")
public class QuotesController {
	
	@Autowired
	private QuotesServiceImpl quotesServiceImpl;
	
	@Autowired
	private AuthClient authClient;
	
	@ApiOperation(value="Get the Quotes for Policies")
	@PostMapping("/getQuotesForPolicy")
	public ResponseEntity<?> getQuotesForPolicy(@Valid @RequestBody QuotesRequest quotesRequest,
			@RequestHeader("Authorization") String token){
		log.info("Start Get Quotes For Policy inside Quotes Controller");
		if(authClient.validatingAuthorizationToken(token).getBody().isValidStatus()) {
			log.info("End Get Quotes For Policy inside Quotes Controller");
			return new ResponseEntity<>(quotesServiceImpl.getQuotesForPolicy(quotesRequest.getBusinessValue(),quotesRequest.getPropertyValue(),quotesRequest.getPropertyType()),HttpStatus.OK);
		}
		
		log.debug("Token is invalid.");
		log.info("End Get Quotes For Policy inside Quotes Controller");
		return new ResponseEntity<String>("Token is invalid.",HttpStatus.BAD_REQUEST);
	}
	

}
