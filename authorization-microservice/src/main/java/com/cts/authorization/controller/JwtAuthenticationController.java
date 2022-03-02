package com.cts.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorization.config.JwtTokenUtil;
import com.cts.authorization.dto.ValidatingDTO;
import com.cts.authorization.exception.AuthorizeException;
import com.cts.authorization.model.JwtRequest;
import com.cts.authorization.model.JwtResponse;
import com.cts.authorization.model.MyUserDetails;

import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@Api(value = "authenticationdetails", description = "Authentication details for users")
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private ValidatingDTO vaildatingDTO;

	@PostMapping(value = "/authenticate")
	@ApiOperation(value = "authenticating user", notes = "authenticating user for service")
	public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws AuthorizeException {
		log.info("before authenticate createAuthenticationToken method");
		authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
		final MyUserDetails userDetails = (MyUserDetails) userDetailsService
				.loadUserByUsername(authenticationRequest.getUserName());
		String token = jwtTokenUtil.generateToken(userDetails);
		log.info("Inside auth controller createAuthenticationToken method");
		return new JwtResponse(authenticationRequest.getUserName(), token, userDetails.getUser().getRole());

	}

	private Authentication authenticate(String userName, String password) throws AuthorizeException {

		try {
			log.info("before authenticationManager authenticate method");
			Authentication auth = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			log.info("after found" + auth.getCredentials());
			return auth;
		} catch (DisabledException e) {
			throw new AuthorizeException("USER_DISABLED");
		} catch (BadCredentialsException e) {
			log.error("Invalid Credential");
			throw new AuthorizeException("Invalid credential");
		}
	}

	@PostMapping(value = "/authorize")
	@ApiOperation(value = "Autherized user", notes = "Autherized user for service")
	public boolean authorizeRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
		String jwtToken = null;
		String username = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				return false;
			} catch (ExpiredJwtException e) {
				return false;
			}
		}
		return username != null;

	}

	@GetMapping(path = "/validate")
	@ApiOperation(value = "tokenValidation", notes = "returns boolean after validating JWT", httpMethod = "GET", response = ResponseEntity.class)
	public ResponseEntity<ValidatingDTO> validatingAuthorizationToken(
				@RequestHeader(name = "Authorization") String tokenDup) {
		log.info("BEGIN - [validatingAuthorizationToken(JWT-token)] validatingAuthorizationToken method");
		String token = tokenDup.substring(7);

		try {
			UserDetails user = userDetailsService.loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));
			if (Boolean.TRUE.equals(jwtTokenUtil.validateToken(token, user))) {
				log.debug("Token matched is Valid");
				log.info("Token matched is Valid");
				log.info("END - validate()");
				vaildatingDTO.setValidStatus(true);
				return new ResponseEntity<>(vaildatingDTO, HttpStatus.OK);
			} else {
				log.debug("Token matched is Invalid");
				log.info("END Else Part- validatingAuthorizationToken() validatingAuthorizationToken method");
				vaildatingDTO.setValidStatus(false);
				return new ResponseEntity<>(vaildatingDTO, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			log.debug("Invalid token - Bad Credentials Exception");
			log.info("END Exception - validatingAuthorizationToken()");
			vaildatingDTO.setValidStatus(false);
			return new ResponseEntity<>(vaildatingDTO, HttpStatus.FORBIDDEN);
		}
	}

}
