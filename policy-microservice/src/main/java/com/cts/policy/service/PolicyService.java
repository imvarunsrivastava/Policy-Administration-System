package com.cts.policy.service;

import com.cts.policy.exception.ConsumerNotFoundException;
import com.cts.policy.exception.PolicyNotFoundException;
import com.cts.policy.payload.request.CreatePolicyRequest;
import com.cts.policy.payload.request.IssuePolicyRequest;
import com.cts.policy.payload.request.QuotesRequest;
import com.cts.policy.payload.response.PolicyDetailsResponse;
import com.cts.policy.payload.response.QuotesDetailsResponse;
import com.cts.policy.payload.response.StatusResponse;

public interface PolicyService {

	public StatusResponse createPolicy(CreatePolicyRequest createPolicyRequest);
	public StatusResponse issuePolicy(IssuePolicyRequest issuePolicyRequest) throws PolicyNotFoundException;
	public PolicyDetailsResponse viewPolicy(Long consumerId,String policyId) throws ConsumerNotFoundException,PolicyNotFoundException;
	public QuotesDetailsResponse getQuotes(QuotesRequest quotesRequest);
}
