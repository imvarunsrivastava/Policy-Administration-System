package com.cts.consumer.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerBusinessRequest {

	@NotBlank
	@Size(max = 50)
	private String name;

	@NotBlank
	@Size(max = 20)
	private String dob;

	@NotBlank
	@Size(max = 50)
	private String businessName;

	@NotBlank
	@Size(max = 10)
	private String panDetails;

	@NotBlank
	@Size(max = 50)
	private String email;

	@NotBlank
	@Size(max = 10)
	private String phone;

	@NotBlank
	@Size(max = 150)
	private String businessOverview;

	@NotBlank
	@Size(max = 30)
	private String validity;

	@NotBlank
	@Size(max = 50)
	private String agentName;

	@NotNull
	private Long agentId;

	@NotBlank
	@Size(max = 40)
	private String businessCategory;

	@NotBlank
	@Size(max = 40)
	private String businessType;

	@NotNull
	private Long businessTurnover;

	@NotNull
	private Long capitalInvested;

	@NotNull
	private Long totalEmployees;

	@NotNull
	private Long businessAge;

}
