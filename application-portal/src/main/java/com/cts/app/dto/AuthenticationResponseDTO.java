package com.cts.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AuthenticationResponseDTO {

	@JsonProperty
	private String userName;
	@JsonProperty
	private String role;
	@JsonProperty
	private String jwtAuthToken;
}
