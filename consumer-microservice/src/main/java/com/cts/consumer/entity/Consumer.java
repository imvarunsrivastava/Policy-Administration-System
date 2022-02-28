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
public class Consumer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long consumerId;

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
	@Size(max = 10)
	private String panDetails;

	@NotBlank(message = "Email should not be empty")
	@Size(max = 50)
	private String email;

	@NotBlank(message = "Phone should not be empty.")
	@Size(min = 10, max = 10)
	private String phone;

	@NotBlank(message = "Business Overview should not be empty")
	@Size(max = 150)
	private String businessOverview;

	@NotBlank(message = "Validity should not be empty.")
	@Size(max = 30)
	private String validity;

	@NotNull(message = "Agent Id should not be empty.")
	private Long agentId;

	@NotBlank(message = "Agent Name should not be empty")
	@Size(max = 50)
	private String agentName;

	public Consumer(@NotBlank(message = "Name should not be empty.") @Size(max = 50) String name,
			@NotBlank(message = "Date of Birth should not be empty.") @Size(max = 20) String dob,
			@NotBlank(message = "Business Name should not be empty.") @Size(max = 50) String businessName,
			@NotBlank(message = "Pan Details should not be empty") @Size(max = 10) String panDetails,
			@NotBlank(message = "Email should not be empty") @Size(max = 50) String email,
			@NotBlank(message = "Phone should not be empty.") @Size(min = 10, max = 10) String phone,
			@NotBlank(message = "Business Overview should not be empty") @Size(max = 150) String businessOverview,
			@NotBlank(message = "Validity should not be empty.") @Size(max = 30) String validity,
			@NotNull(message = "Agent Id should not be empty.") Long agentId,
			@NotBlank(message = "Agent Name should not be empty") @Size(max = 50) String agentName) {
		super();
		this.name = name;
		this.dob = dob;
		this.businessName = businessName;
		this.panDetails = panDetails;
		this.email = email;
		this.phone = phone;
		this.businessOverview = businessOverview;
		this.validity = validity;
		this.agentId = agentId;
		this.agentName = agentName;
	}

	

}
