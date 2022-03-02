package com.cts.policy.payload.request;



import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuotesRequest {

	@NotNull(message="Business value should not be empty")
	private Long businessValue;
	
	@NotNull(message="Property value should not be empty")
	private Long propertyValue;
	
	@NotNull(message="Property Type should not be empty")
	private String propertyType;
}
