package com.cts.consumer.entity;

import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long propertyMasterId;

	@NotBlank
	@Size(max = 30)
	@Column(name = "Insurance_Type")
	private String insurancetype;

	@NotBlank(message = "PropertyType is not be empty")
	@Size(max = 30)
	private String propertyType;

	@NotBlank
	@Size(max = 7)
	private String buildingType;

	@NotNull
	private Long buildingAge;

}
