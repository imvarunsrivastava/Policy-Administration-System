package com.cts.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.consumer.dto.ValidatingDTO;

@FeignClient(name = "AUTHORIZATION-MICROSERVICE")
public interface AuthClient {

	@GetMapping("/validate")
	public ResponseEntity<ValidatingDTO> validatingAuthorizationToken(
			@RequestHeader(name = "Authorization") String token);

}
