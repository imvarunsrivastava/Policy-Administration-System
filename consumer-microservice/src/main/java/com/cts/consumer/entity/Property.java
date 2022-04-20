package com.cts.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long propertyId;

	@NotNull(message = "Business Id should not be empty")
	private Long businessId;

	@NotNull(message = "Consumer Id should not be empty")
	private Long consumerId;

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

	@NotNull(message = "Property Value should not be empty")
	private Long propertyValue;

	@NotNull(message = "Cost Of The Asset should not be empty")
	private Long costOfTheAsset;

	@NotNull(message = "Salvage Value should not be empty")
	private Long salvageValue;

	@NotNull(message = "Useful Life Of The Asset should not be empty")
	private Long usefulLifeOfTheAsset;

	public Property(@NotNull(message = "Business Id should not be empty") Long businessId,
			@NotNull(message = "Consumer Id should not be empty") Long consumerId,
			@NotBlank(message = "Insurance Type should not be empty") @Size(max = 30) String insuranceType,
			@NotBlank(message = "Property Type should not be empty") @Size(max = 30) String propertyType,
			@NotBlank(message = "Building Sqft should not be empty") @Size(max = 30) String buildingSqft,
			@NotBlank(message = "Building Type should not be empty") @Size(max = 7) String buildingType,
			@NotBlank(message = "Building Storeys should not be empty") @Size(max = 10) String buildingStoreys,
			@NotNull(message = "Building Age should not be empty") Long buildingAge,
			@NotNull(message = "Property Value should not be empty") Long propertyValue,
			@NotNull(message = "Cost Of The Asset should not be empty") Long costOfTheAsset,
			@NotNull(message = "Salvage Value should not be empty") Long salvageValue,
			@NotNull(message = "Useful Life Of The Asset should not be empty") Long usefulLifeOfTheAsset) {
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
