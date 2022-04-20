package com.cts.policy.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsumerBusinessDetails {

	@NotBlank(message="Name should not be empty")
	@Size(max = 50)
	private String name;

	@NotBlank(message="Date Of Birth should not be empty")
	@Size(max = 20)
	private String dob;

	@NotBlank(message="Business Name should not be empty")
	@Size(max = 50)
	private String businessName;

	@NotBlank(message="Pan Details should not be empty")
	@Size(max = 12)
	private String panDetails;

	@NotBlank(message="Email should not be empty")
	@Size(max = 50)
	private String email;

	@NotBlank(message="Phone Number should not be empty")
	@Size(max = 10)
	private String phone;

	@NotBlank(message="Business Overview should not be empty")
	@Size(max = 150)
	private String businessOverview;

	@NotBlank(message="Validity should not be empty")
	@Size(max = 30)
	private String validity;

	@NotBlank(message="Agent Name should not be empty")
	@Size(max = 50)
	private String agentName;

	@NotNull(message="Agent Id should not be empty")
	private Long agentId;

	@NotNull(message="Business Id should not be empty")
	private Long businessId;

	@NotNull(message="Consumer Id should not be empty")
	private Long consumerId;

	@NotBlank(message="Business Category should not be empty")
	@Size(max = 40)
	private String businessCategory;

	@NotBlank(message="Business Type should not be empty")
	@Size(max = 40)
	private String businessType;

	@NotNull(message="Business Turnover should not be empty")
	private Long businessTurnover;

	@NotNull(message="Capital Invested should not be empty")
	private Long capitalInvested;

	@NotNull(message="Total Employees should not be empty")
	private Long totalEmployees;

	@NotNull(message="Business Value should not be empty")
	private Long businessValue;

	@NotNull(message="Business Age should not be empty")
	private Long businessAge;
}
