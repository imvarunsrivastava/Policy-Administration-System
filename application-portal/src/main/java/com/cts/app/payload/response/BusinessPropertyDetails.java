package com.cts.app.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.cts.app.payload.response.BusinessPropertyDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessPropertyDetails {

	@NotNull
	private Long propertyId;
	
	@NotNull(message = "Business ID not be empty.")
	private Long businessId;
	
	@NotNull(message = "Consumer ID should not be empty.")
	private Long consumerId;
	
	@NotNull(message = "Consumer Name should not be empty.")
	private String consumerName;
	
	@NotBlank(message = "Insurance Type should not be empty")
	@Size(max = 30)
	private String insuranceType;
	
	@NotBlank(message = "Property Type should not be empty")
	@Size(max = 30)
	private String propertyType;
	
	@NotBlank(message = "Building Sqft should not be empty")
	@Size(max = 30)
	private String buildingSqft;
	
	@NotBlank(message = "Building Type should not be empty")
	@Size(max = 7)
	private String buildingType;
	
	@NotBlank(message = "Building Storeys should not be empty")
	@Size(max = 10)
	private String buildingStoreys;
	
	@NotNull(message = "Building Age should not be empty")
	private Long buildingAge;

	@NotNull
	private Long propertyValue;
	
	@NotNull(message = "Cost Of The Asset should not be empty")
	private Long costOfTheAsset;
	
	@NotNull(message = "Salvage Value should not be empty")
	private Long salvageValue;
	
	@NotNull(message = "Useful Life Of The Asset should not be empty")
	private Long usefulLifeOfTheAsset;

}
