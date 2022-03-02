package com.cts.policy.entity;

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
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ConsumerPolicy {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;

	@NotNull(message="Consumer Id should not be empty")
	private Long consumerId;

	
	@Size(max = 10)
	private String policyId;

	@NotNull(message="Business Id should not be empty")
	private Long businessId;

	
	@Size(max = 10)
	private String paymentDetails;

	
	@Size(max = 10)
	private String acceptanceStatus;

	@NotBlank(message="Policy Status should not be empty")
	@Size(max = 10)
	private String policyStatus;

	@Size(max = 20)
	private String effectiveDate;

	
	@Size(max = 15)
	private String coveredSum;

	
	@Size(max = 15)
	private String duration;

	@NotBlank(message="AcceptedQuote should not be empty")
	@Size(max = 15)
	private String acceptedQuote;



    public ConsumerPolicy(@NotNull(message="Consumer Id should not be empty") Long consumerId, 
    		@NotNull(message="Business Id should not be empty") Long businessId,
		    @NotBlank(message="Policy Status should not be empty") @Size(max = 10) String policyStatus, 
		    @NotBlank(message="AcceptedQuote should not be empty") @Size(max = 15) String acceptedQuote) {
		super();
		this.consumerId= consumerId;
		this.businessId= businessId;
		this.policyStatus= policyStatus;
		this.acceptedQuote= acceptedQuote;
		}
}
