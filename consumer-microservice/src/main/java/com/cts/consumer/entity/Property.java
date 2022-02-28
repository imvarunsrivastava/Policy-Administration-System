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
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@NotBlank(message = "BuildingSqft is not be empty")
	@Size(max = 30)
	private String buildingSqft;

	@NotBlank(message = "BuildingType is not be empty")
	@Size(max = 7)
	private String buildingType;

	@NotBlank(message = "BuildingStoreys is not be empty")
	@Size(max = 10)
	private String buildingStoreys;

	@NotNull(message = "BuildingAge is not be empty")
	private Long buildingAge;

	@NotNull
	private Long propertyValue;

	@NotNull
	private Long costOfTheAsset;

	@NotNull
	private Long salvageValue;

	@NotNull
	private Long usefulLifeOfTheAsset;
}
