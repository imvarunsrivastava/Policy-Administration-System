package com.cts.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.app.dto.AuthenticationResponseDTO;
import com.cts.app.model.LoginModel;
import com.cts.app.restclient.FeignAuthorizationClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired
	private FeignAuthorizationClient authClient;
	
	@Override
	public AuthenticationResponseDTO login(LoginModel login) {
		log.info("LoginServiceImpl [login Method]");
		return authClient.createAuthenticationToken(login);
	}

}
