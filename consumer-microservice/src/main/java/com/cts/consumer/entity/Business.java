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

	@NotBlank
	@Size(max = 40)
	private String businessCategory;

	@NotBlank(message = "BusinessType is not be empty")
	@Size(max = 40)
	private String businessType;

	@NotNull(message = "AnnualTurnover is not be empty")
	private Long businessTurnover;

	@NotNull
	private Long capitalInvested;

	@NotNull
	private Long totalEmployees;

	@NotNull
	private Long businessValue;

	@NotNull
	private Long businessAge;

	public Business(@NotNull Long consumerId, @NotBlank @Size(max = 40) String businessCategory,
			@NotBlank(message = "BusinessType is not be empty") @Size(max = 40) String businessType,
			@NotNull(message = "AnnualTurnover is not be empty") Long businessTurnover, @NotNull Long capitalInvested,
			@NotNull Long totalEmployees, @NotNull Long businessValue, @NotNull Long businessAge) {
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
