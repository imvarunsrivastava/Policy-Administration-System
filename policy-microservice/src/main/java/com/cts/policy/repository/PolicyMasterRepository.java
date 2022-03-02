package com.cts.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.policy.entity.PolicyMaster;

@Repository
public interface PolicyMasterRepository extends JpaRepository<PolicyMaster,Long>{

	PolicyMaster findByBusinessValue(Long businessValue);
	
	PolicyMaster findByPolicyId(String policyId);
		
	boolean existsByPolicyId(String policyId);
}
