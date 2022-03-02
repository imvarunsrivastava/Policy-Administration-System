package com.cts.policy.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePolicyRequest {

	@NotNull(message="Consumer Id should not be empty")
	private Long consumerId;
	
	@NotBlank(message="AcceptedQuote should not be empty")
	private String acceptedQuotes;
}
