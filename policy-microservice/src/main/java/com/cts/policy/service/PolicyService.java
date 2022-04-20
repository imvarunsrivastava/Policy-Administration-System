package com.cts.policy.service;

import com.cts.policy.exception.ConsumerNotFoundException;
import com.cts.policy.exception.PolicyException;
import com.cts.policy.payload.request.CreatePolicyRequest;
import com.cts.policy.payload.request.IssuePolicyRequest;
import com.cts.policy.payload.response.PolicyDetailsResponse;
import com.cts.policy.payload.response.QuotesDetailsResponse;
import com.cts.policy.payload.response.StatusResponse;

public interface PolicyService {

	public StatusResponse createPolicy(CreatePolicyRequest createPolicyRequest,String token) throws PolicyException;
	public StatusResponse issuePolicy(IssuePolicyRequest issuePolicyRequest) throws PolicyException;
	public PolicyDetailsResponse viewPolicy(Long consumerId,String policyId) throws ConsumerNotFoundException,PolicyException;
	public QuotesDetailsResponse getQuotes(String businessValue,String propertyValue,String propertyType,String token);
}
