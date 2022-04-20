package com.cts.app.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.app.dto.AuthenticationResponseDTO;
import com.cts.app.dto.ValidatingDTO;
import com.cts.app.model.LoginModel;

@FeignClient(name = "authorization-microservice")
public interface FeignAuthorizationClient {
	@PostMapping(value = "/authenticate")
	public AuthenticationResponseDTO createAuthenticationToken(
			@RequestBody LoginModel login);
	
	@GetMapping(value = "/validate")
	public ResponseEntity<ValidatingDTO> validatingAuthorizationToken(@RequestHeader(name = "Authorization", required = true) String tokenDup);
}
