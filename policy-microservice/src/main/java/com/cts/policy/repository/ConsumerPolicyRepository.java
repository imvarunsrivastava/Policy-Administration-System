package com.cts.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.policy.entity.ConsumerPolicy;

@Repository
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy,Long> {

	ConsumerPolicy findByConsumerIdAndBusinessId(Long consumerId,Long businessId);
	
	boolean existsByConsumerId(Long consumerId);
	
	boolean existsByConsumerIdAndBusinessId(Long consumerId,Long businessId);
}
