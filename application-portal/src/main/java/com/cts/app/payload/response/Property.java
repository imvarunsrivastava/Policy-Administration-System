package com.cts.app.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
	
	private long propertyId;

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
	private Long propertyValue;

	@NotNull
	private Long costOfTheAsset;

	@NotNull
	private Long salvageValue;

	@NotNull
	private Long usefulLifeOfTheAsset;

	public Property(@NotNull Long businessId,
			@NotNull Long consumerId,
			@NotBlank @Size(max = 30) String insuranceType,
			@NotBlank @Size(max = 30) String propertyType,
			@NotBlank @Size(max = 30) String buildingSqft,
			@NotBlank @Size(max = 7) String buildingType,
			@NotBlank @Size(max = 10) String buildingStoreys,
			@NotNull Long buildingAge,
			@NotNull Long propertyValue,
			@NotNull Long costOfTheAsset,
			@NotNull Long salvageValue,
			@NotNull Long usefulLifeOfTheAsset) {
		super();
		this.businessId = businessId;
		this.consumerId = consumerId;
		this.insuranceType = insuranceType;
		this.propertyType = propertyType;
		this.buildingSqft = buildingSqft;
		this.buildingType = buildingType;
		this.buildingStoreys = buildingStoreys;
		this.buildingAge = buildingAge;
		this.propertyValue = propertyValue;
		this.costOfTheAsset = costOfTheAsset;
		this.salvageValue = salvageValue;
		this.usefulLifeOfTheAsset = usefulLifeOfTheAsset;
	}
	

}
