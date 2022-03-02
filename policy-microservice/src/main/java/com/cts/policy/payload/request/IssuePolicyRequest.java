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
public class IssuePolicyRequest {

	@NotBlank(message="Policy Id should not be empty")
	private String policyId;
	
	@NotNull(message="Consumer Id should not be empty")
	private Long consumerId;
	
	@NotNull(message="Business Id should not be empty")
	private Long businessId;
	
	@NotBlank(message="Payment Details should not be empty")
	private String paymentDetails;
	
	@NotBlank(message="Accepted Status should not be empty")
	private String acceptanceStatus;
}
