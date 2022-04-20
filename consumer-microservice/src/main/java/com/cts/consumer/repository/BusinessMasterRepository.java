package com.cts.consumer.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.consumer.entity.BusinessMaster;

@Repository
@Transactional
@DynamicUpdate
public interface BusinessMasterRepository extends JpaRepository<BusinessMaster, Long> {

	BusinessMaster findByBusinessCategoryAndBusinessType(String businessCategory, String businessType);

}
