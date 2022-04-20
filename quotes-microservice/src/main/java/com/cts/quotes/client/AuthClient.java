package com.cts.quotes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cts.quotes.dto.ValidatingDTO;

@FeignClient(name = "AUTHORIZATION-MICROSERVICE")
public interface AuthClient {

	@GetMapping("/validate")
	public ResponseEntity<ValidatingDTO> validatingAuthorizationToken(@RequestHeader(name = "Authorization") String token);

}
