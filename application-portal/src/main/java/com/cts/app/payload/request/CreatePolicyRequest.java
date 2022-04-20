package com.cts.app.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePolicyRequest {

	@NotNull
	private Long consumerId;

	@NotBlank(message = "Accepted Quotes Should not be empty.")
	private String acceptedQuotes;

}
