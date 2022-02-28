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

	@NotBlank
	@Size(max = 40)
	private String businessCategory;

	@NotBlank
	@Size(max = 40)
	private String businessType;

	@NotNull
	private Long totalEmployees;

	@NotNull
	private Long businessAge;

}
