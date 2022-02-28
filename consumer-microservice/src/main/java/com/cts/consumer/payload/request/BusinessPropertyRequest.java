package com.cts.consumer.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessPropertyRequest {
	
	@NotNull
	private Long businessId;
	
	@NotNull
	private Long consumerId;
	
	@NotBlank
	@Size(max = 30)
	private String insuranceType;
	
	@NotBlank
	@Size(max = 30)
	private String propertyType;
	
	@NotBlank
	@Size(max = 30)
	private String buildingSqft;
	
	@NotBlank
	@Size(max = 7)
	private String buildingType;
	
	@NotBlank
	@Size(max = 10)
	private String buildingStoreys;
	
	@NotNull
	private Long buildingAge;

	@NotNull
	private Long costOfTheAsset;
	
	@NotNull
	private Long salvageValue;
	
	@NotNull
	private Long usefulLifeOfTheAsset;
	

}
