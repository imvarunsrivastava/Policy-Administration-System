package com.cts.authorization.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtResponse implements Serializable {
	private String userName;
	private String jwtAuthToken;
	private String role;

}
