package com.cts.app.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PolicyDetailsResponse {
	
	@NotNull
	private Long consumerId;
	
	@Size(max = 10)
	private String policyId;
	
	@NotBlank
	@Size(max = 30)
	private String propertyType;
	
	@NotBlank
	@Size(max = 30)
	private String consumerType;

	@NotBlank
	@Size(max = 40)
	private String assuredSum;

	@NotBlank
	@Size(max = 30)
	private String tenure;

	@NotNull
	private Long businessValue;

	@NotNull
	private Long propertyValue;

	@NotBlank
	@Size(max = 30)
	private String baseLocation;
	
	@NotBlank
	@Size(max = 30)
	private String type;
	
	@NotNull
	private Long businessId;
	
	@NotBlank
	@Size(max = 10)
	private String paymentDetails;
	
	@NotBlank
	@Size(max = 10)
	private String acceptanceStatus;
	
	@NotBlank
	@Size(max = 10)
	private String policyStatus;
	
	@NotBlank
	@Size(max = 15)
	private String effectiveDate;
	
	@NotBlank
	@Size(max = 15)
	private String coveredSum;
	
	@NotBlank
	@Size(max = 15)
	private String duration;
	
	@NotBlank
	@Size(max = 15)
	private String acceptedQuote;

}
