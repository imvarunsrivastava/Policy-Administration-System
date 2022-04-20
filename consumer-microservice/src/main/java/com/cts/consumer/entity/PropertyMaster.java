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
public class PropertyMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long propertyMasterId;

	@NotBlank(message = "Insurance Type should not be empty")
	@Size(max = 30)
	private String insuranceType;

	@NotBlank(message = "Property Type should not be empty")
	@Size(max = 30)
	private String propertyType;

	@NotBlank(message = "Building Type should not be empty")
	@Size(max = 7)
	private String buildingType;

	@NotNull(message = "Building Age should not be empty")
	private Long buildingAge;

}
