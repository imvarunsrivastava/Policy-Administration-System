package com.cts.app.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerPolicyResponse {

	@NotNull(message="Consumer Id should not be empty")
	private Long consumerId;

	@NotNull(message="Policy Id should not be empty")
	private String policyId;

	@NotBlank(message="AcceptedQuote should not be empty")
	private String acceptedQuotes;
}
