package com.cts.policy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="policy_master")
public class PolicyMaster {

	@Id
	@Size(max = 20)
	private String policyId;

	
	@NotBlank(message="Property Type should not be empty")
	@Size(max = 30)
	private String propertyType;
	
	@NotBlank(message="Consumer Type should not be empty")
	@Size(max = 30)
	private String consumerType;

	@NotBlank(message="Assured Sum should not be empty")
	@Size(max = 40)
	private String assuredSum;

	@NotBlank(message="Tenure should not be empty")
	@Size(max = 30)
	private String tenure;

	@NotNull(message="Business Value should not be empty")
	private Long businessValue;
	
	@NotNull(message="Property Value should not be empty")
	private Long propertyValue;
	
	@NotBlank(message="Base Location should not be empty")
	@Size(max = 30)
	private String baseLocation;
	
	@NotBlank(message="Type should not be empty")
	@Size(max = 30)
	private String Type;
}
