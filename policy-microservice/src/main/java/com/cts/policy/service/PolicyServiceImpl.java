package com.cts.policy.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.policy.client.ConsumerClient;
import com.cts.policy.client.QuotesClient;
import com.cts.policy.dto.ConsumerBusinessDetails;
import com.cts.policy.entity.ConsumerPolicy;
import com.cts.policy.entity.PolicyMaster;
import com.cts.policy.exception.ConsumerNotFoundException;
import com.cts.policy.exception.PolicyNotFoundException;
import com.cts.policy.payload.request.CreatePolicyRequest;
import com.cts.policy.payload.request.IssuePolicyRequest;
import com.cts.policy.payload.request.QuotesRequest;
import com.cts.policy.payload.response.PolicyDetailsResponse;
import com.cts.policy.payload.response.QuotesDetailsResponse;
import com.cts.policy.repository.ConsumerPolicyRepository;
import com.cts.policy.repository.PolicyMasterRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyServiceImpl implements PolicyService{

	@Autowired
	private ConsumerPolicyRepository consumerPolicyRepository;
	
	@Autowired
	private PolicyMasterRepository policyMasterRepository;
	
	@Autowired
	private ConsumerClient consumerClient;
	
	@Autowired
	private QuotesClient quotesCilent;
	
	@Transactional
	public String createPolicy(CreatePolicyRequest createPolicyRequest)  {
	  
		log.info("Start Create Policy inside Policy Service");
		ResponseEntity<ConsumerBusinessDetails> consumerDetails=consumerClient.getConsumerBusiness(createPolicyRequest.getConsumerId());

		if(consumerPolicyRepository.existsByConsumerIdAndBusinessId(createPolicyRequest.getConsumerId(),consumerDetails.getBody().getBusinessId())) {
			return "Policy already created for this consumer with same business details";
		}
		else {
			log.debug("Consumer Business Details :{}",consumerDetails);
			PolicyMaster policyMaster=policyMasterRepository.findByBusinessValue(consumerDetails.getBody().getBusinessValue());
			log.debug("Policy Master Details :{}",policyMaster);
			if(policyMaster!=null) {
					ConsumerPolicy consumerCreatePolicySave=new ConsumerPolicy(createPolicyRequest.getConsumerId(),
							consumerDetails.getBody().getBusinessId(),"Initiated",createPolicyRequest.getAcceptedQuotes());
					consumerPolicyRepository.save(consumerCreatePolicySave);
					log.info("End Create Policy inside Policy Service");
					return "Policy created Successfully.";	
			  
			}
			else {
				log.info("End Create Policy inside Policy Service");
				return "Sorry! The policy you are Creating is not available.";
			}
		}
		
	}
	
	@Transactional
	public String issuePolicy(IssuePolicyRequest issuePolicyRequest) throws PolicyNotFoundException{
		
		log.info("Start Issue Policy inside Policy Service");
		
		if (!consumerPolicyRepository.existsByConsumerId(issuePolicyRequest.getConsumerId())) {
			return "Sorry!!, No Consumer Found!!";
		}
		
		if (!policyMasterRepository.existsByPolicyId(issuePolicyRequest.getPolicyId())) {
			return "Sorry!!, No Policy Found!!";
		}
		
		if (!(issuePolicyRequest.getPaymentDetails().equals("Success"))) {
			return "Sorry!!, Payment Failed!! Try Again";
		}
		if (!(issuePolicyRequest.getAcceptanceStatus().equals("Accepted"))) {
			return "Sorry!!, Accepted Failed !! Try Again";
		}
		
		ConsumerPolicy consumerPolicy=consumerPolicyRepository.findByConsumerIdAndBusinessId(issuePolicyRequest.getConsumerId(),issuePolicyRequest.getBusinessId());
		if(consumerPolicy!=null) {
			PolicyMaster policy=policyMasterRepository.findByPolicyId(issuePolicyRequest.getPolicyId());
	        if(policy!=null) {
	        	 consumerPolicy.setCoveredSum(policy.getAssuredSum());
	        	 consumerPolicy.setDuration(policy.getTenure());
	         }
	        else {
	        	return "Please enter Valid Policy id";
	        }
	        consumerPolicy.setPolicyId(issuePolicyRequest.getPolicyId());
	        consumerPolicy.setPaymentDetails(issuePolicyRequest.getPaymentDetails());
	        consumerPolicy.setAcceptanceStatus(issuePolicyRequest.getAcceptanceStatus());
	        consumerPolicy.setPolicyStatus("Issued");
	        Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            String strDate = dateFormat.format(date);
            consumerPolicy.setEffectiveDate(strDate);
            consumerPolicyRepository.save(consumerPolicy);
            log.debug("Issue Policy Details :{}",consumerPolicy);
            log.info("End Issue Policy inside Policy Service");
            return "Policy Issued Successfully.";
		}
		else {
			log.info("End Issue Policy inside Policy Service");
			return  "Policy is not created for this consumer.";
		}
	   
	}
	
	@Transactional
	public PolicyDetailsResponse viewPolicy(Long consumerId,String policyId) throws ConsumerNotFoundException,PolicyNotFoundException{
	
	   log.info("Start View Policy inside Policy Service");
	   Optional<ConsumerPolicy> consumerDetails = Optional.ofNullable(consumerPolicyRepository.findById(consumerId)
				.orElseThrow(() -> new ConsumerNotFoundException("Consumer is not Found.")));
		
	   ConsumerPolicy consumerDetailsObj=consumerDetails.get();
	   log.debug("Consumer Policy Details :{}",consumerDetailsObj);
	   PolicyMaster policyDetails =policyMasterRepository.findByPolicyId(policyId);
	   log.debug("Policy Master Details :{}",policyDetails);
	   if(policyDetails!=null) {
		   PolicyDetailsResponse policyDetailsResponse=new PolicyDetailsResponse(consumerDetailsObj.getConsumerId(),
					 consumerDetailsObj.getPolicyId(),policyDetails.getPropertyType(),policyDetails.getConsumerType(),
					 policyDetails.getAssuredSum(),policyDetails.getTenure(),policyDetails.getBusinessValue(),
					 policyDetails.getPropertyValue(),policyDetails.getBaseLocation(),policyDetails.getType(),
					 consumerDetailsObj.getBusinessId(),consumerDetailsObj.getPaymentDetails(),consumerDetailsObj.getAcceptanceStatus(),
					 consumerDetailsObj.getPolicyStatus(),consumerDetailsObj.getEffectiveDate(),consumerDetailsObj.getCoveredSum(),
					 consumerDetailsObj.getDuration(),consumerDetailsObj.getAcceptedQuote());
		log.debug("Policy Details Response :{}",policyDetailsResponse);  	
		log.info("End View Policy inside Policy Service");
	    return policyDetailsResponse;
	   }
	   else {
		   log.info("End View Policy inside Policy Service");
		   throw new PolicyNotFoundException("Policy is not created or issued for consumer");
		   
	   }
		
	   
	}
	
	
	@Transactional
	public QuotesDetailsResponse getQuotes(QuotesRequest quotesRequest) {
		log.info("Start Get Quotes inside Policy Service");
		log.info("Start Get Quotes Client");
		String quote=quotesCilent.getQuotesForPolicy(quotesRequest);
		log.debug(quote);
		log.info("End Get Quotes Client");
		QuotesDetailsResponse quotesDetailsResponse=new QuotesDetailsResponse(quote);
		log.debug("Quotes Details Response :{}",quotesDetailsResponse);
		log.info("End Get Quotes inside Policy Service");
		return quotesDetailsResponse;
	}
	
}
