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

	@NotBlank(message = "Name should not be empty.")
	@Size(max = 50)
	private String name;

	@NotBlank(message = "Date of Birth should not be empty.")
	@Size(max = 20)
	private String dob;

	@NotBlank(message = "Business Name should not be empty.")
	@Size(max = 50)
	private String businessName;

	@NotBlank(message = "Pan Details should not be empty")
	@Size(max = 12)
	private String panDetails;

	@NotBlank(message = "Email should not be empty")
	@Size(max = 50)
	private String email;

	@NotBlank(message = "Phone should not be empty.")
	@Size(max = 10)
	private String phone;

	@NotBlank(message = "Business Overview should not be empty")
	@Size(max = 150)
	private String businessOverview;

	@NotBlank(message = "Validity should not be empty.")
	@Size(max = 30)
	private String validity;

	@NotBlank(message = "Agent Name should not be empty.")
	@Size(max = 50)
	private String agentName;

	@NotNull(message = "Agent Id should not be empty")
	private Long agentId;

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

	@NotNull(message = "Business Age should not be empty")
	private Long businessAge;

}
