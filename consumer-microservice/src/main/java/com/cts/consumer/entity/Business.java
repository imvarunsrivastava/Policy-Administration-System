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
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessId;

	@NotNull
	private Long consumerId;

	@NotBlank(message = "Business Category should not be empty")
	@Size(max = 40)
	private String businessCategory;

	@NotBlank(message = "BusinessType should not be empty")
	@Size(max = 40)
	private String businessType;

	@NotNull(message = "AnnualTurnover should not be empty")
	private Long businessTurnover;

	@NotNull(message = "CapitalInvested should not be empty")
	private Long capitalInvested;

	@NotNull(message = "Total Employees should not be empty")
	private Long totalEmployees;

	@NotNull(message = "Business Value should not be empty")
	private Long businessValue;

	@NotNull(message = "Business Age should not be empty")
	private Long businessAge;

	public Business(@NotNull Long consumerId,
			@NotBlank(message = "Business Category should not be empty") @Size(max = 40) String businessCategory,
			@NotBlank(message = "BusinessType should not be empty") @Size(max = 40) String businessType,
			@NotNull(message = "AnnualTurnover should not be empty") Long businessTurnover,
			@NotNull(message = "CapitalInvested should not be empty") Long capitalInvested,
			@NotNull(message = "Total Employees should not be empty") Long totalEmployees,
			@NotNull(message = "Business Value should not be empty") Long businessValue,
			@NotNull(message = "Business Age should not be empty") Long businessAge) {
		super();
		this.consumerId = consumerId;
		this.businessCategory = businessCategory;
		this.businessType = businessType;
		this.businessTurnover = businessTurnover;
		this.capitalInvested = capitalInvested;
		this.totalEmployees = totalEmployees;
		this.businessValue = businessValue;
		this.businessAge = businessAge;
	}

	
	

	
}
