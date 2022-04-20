package com.cts.app.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IssuePolicyRequest {
	
	@NotNull
	private Long consumerId;
	
	@NotBlank(message = "Payment Details should not be empty")
	private String paymentDetails;
	
	@NotBlank(message = "Acceptance Status should not be empty")
	private String acceptanceStatus;

}
