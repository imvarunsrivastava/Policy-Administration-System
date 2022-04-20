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
public class BusinessMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessMasterId;

	@NotBlank(message = "Business Category should not be empty")
	@Size(max = 40)
	private String businessCategory;

	@NotBlank(message = "BusinessType should not be empty")
	@Size(max = 40)
	private String businessType;

	@NotNull(message = "Total Employees should not be empty")
	private Long totalEmployees;

	@NotNull(message = "Business Age should not be empty")
	private Long businessAge;

}
