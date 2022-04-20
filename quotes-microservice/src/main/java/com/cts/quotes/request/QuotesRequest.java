package com.cts.quotes.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuotesRequest {

	private Long businessValue;
	private Long propertyValue;
	private String propertyType;
	
	
}
