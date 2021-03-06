package com.cts.consumer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.consumer.entity.Business;
import com.cts.consumer.entity.BusinessMaster;
import com.cts.consumer.entity.Consumer;
import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;
import com.cts.consumer.repository.BusinessMasterRepository;
import com.cts.consumer.repository.BusinessRepository;
import com.cts.consumer.repository.ConsumerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerBusinessServiceImpl implements ConsumerBusinessService {

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private BusinessMasterRepository businessMasterRepository;

	@Transactional
	public ConsumerBusinessDetails createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest)
			throws ConsumerException {
		log.info("Start createConsumerBusiness inside ConsumerServiceImpl");

		if (!consumerRepository.existsByBusinessName(consumerBusinessRequest.getBusinessName())) {

			ConsumerBusinessDetails consumerBusinessDetails;

			BusinessMaster businessMaster = businessMasterRepository.findByBusinessCategoryAndBusinessType(
					consumerBusinessRequest.getBusinessCategory(), consumerBusinessRequest.getBusinessType());
			log.debug("Business Master {}", businessMaster);

			if (businessMaster != null
					&& businessMaster.getTotalEmployees() <= consumerBusinessRequest.getTotalEmployees()
					&& businessMaster.getBusinessAge() <= consumerBusinessRequest.getBusinessAge()) {

				Consumer consumer = new Consumer(consumerBusinessRequest.getName(), consumerBusinessRequest.getDob(),
						consumerBusinessRequest.getBusinessName(), consumerBusinessRequest.getPanDetails(),
						consumerBusinessRequest.getEmail(), consumerBusinessRequest.getPhone(),
						consumerBusinessRequest.getBusinessOverview(), consumerBusinessRequest.getValidity(),
						consumerBusinessRequest.getAgentId(), consumerBusinessRequest.getAgentName());

				log.debug("Consumer: {}", consumer);
				Consumer consumerSave = consumerRepository.save(consumer);

				log.debug("Consumer Save: {}", consumerSave);
				Long businessvalue = calBusinessValue(consumerBusinessRequest.getBusinessTurnover(),
						consumerBusinessRequest.getCapitalInvested());
				log.debug("BusinessValue: {}", businessvalue);
				Business business = new Business(consumerSave.getConsumerId(),
						consumerBusinessRequest.getBusinessCategory(), consumerBusinessRequest.getBusinessType(),
						consumerBusinessRequest.getBusinessTurnover(), consumerBusinessRequest.getCapitalInvested(),
						consumerBusinessRequest.getTotalEmployees(), businessvalue,
						consumerBusinessRequest.getBusinessAge());
				log.debug("Business: {}", business);
				Business businessSave = businessRepository.save(business);
				log.debug("Business Save: {}", businessSave);
				consumerBusinessDetails = new ConsumerBusinessDetails(consumerSave.getName(), consumerSave.getDob(),
						consumerSave.getBusinessName(), consumerSave.getPanDetails(), consumerSave.getEmail(),
						consumerSave.getPhone(), consumerSave.getBusinessOverview(), consumerSave.getValidity(),
						consumerSave.getAgentName(), consumerSave.getAgentId(), businessSave.getBusinessId(),
						businessSave.getConsumerId(), businessSave.getBusinessCategory(),
						businessSave.getBusinessType(), businessSave.getBusinessTurnover(),
						businessSave.getCapitalInvested(), businessSave.getTotalEmployees(),
						businessSave.getBusinessValue(), businessSave.getBusinessAge());
				log.debug("ConsumerBusinessDetails Save: {}", consumerBusinessDetails);
				log.info("End createConsumerBusiness inside ConsumerServiceImpl");
				return consumerBusinessDetails;
			}
			log.info("End createConsumerBusiness inside ConsumerServiceImpl");
			throw new ConsumerException("Sorry!!, Consumer is Not Eligibile for Insurance.");
		}
		log.info("End createConsumerBusiness inside ConsumerServiceImpl");
		throw new ConsumerException("Sorry!!, Consumer Business is already Exists.");

	}

	public Long calBusinessValue(Long businessturnover, Long capitalinvested) {
		log.info("Start CalBusinessValue");
		if (businessturnover == 0 || capitalinvested == 0 || (businessturnover == capitalinvested)) {
			throw new NullPointerException("NullPointerException in CalBusinessValue");
		}
		double bt = businessturnover.doubleValue();
		double ci = capitalinvested.doubleValue();
		double bv = (double) (bt - ci) / (ci);

		bv = bv * 10;
		Long businessValue = Math.round(bv);
		log.debug("BusinessValue: {}", businessValue);
		log.info("End CalBusinessValue");
		return businessValue;
	}

	@Transactional
	public ConsumerBusinessDetails updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails)
			throws ConsumerException {
		log.info("Start updateConsumerBusiness inside ConsumerServiceImpl");

		Optional<Consumer> optionalConsumer = Optional
				.ofNullable(consumerRepository.findById(consumerBusinessDetails.getConsumerId())
						.orElseThrow(() -> new ConsumerException("Consumer is not Found.")));
		Optional<Business> optionalBusiness = Optional
				.ofNullable(businessRepository.findById(consumerBusinessDetails.getConsumerId())
						.orElseThrow(() -> new ConsumerException("Consumer is not Found.")));
		Consumer consumer = optionalConsumer.get();
		Business business = optionalBusiness.get();

		BusinessMaster businessMaster = businessMasterRepository.findByBusinessCategoryAndBusinessType(
				consumerBusinessDetails.getBusinessCategory(), consumerBusinessDetails.getBusinessType());
		log.debug("Business Master {}", businessMaster);

		if (businessMaster != null && businessMaster.getTotalEmployees() <= consumerBusinessDetails.getTotalEmployees()
				&& businessMaster.getBusinessAge() <= consumerBusinessDetails.getBusinessAge()) {

			consumer.setName(consumerBusinessDetails.getName());
			consumer.setAgentId(consumerBusinessDetails.getAgentId());
			consumer.setAgentName(consumerBusinessDetails.getAgentName());
			consumer.setBusinessName(consumerBusinessDetails.getBusinessName());
			consumer.setBusinessOverview(consumerBusinessDetails.getBusinessOverview());
			consumer.setDob(consumerBusinessDetails.getDob());
			consumer.setEmail(consumerBusinessDetails.getEmail());
			consumer.setPanDetails(consumerBusinessDetails.getPanDetails());
			consumer.setPhone(consumerBusinessDetails.getPhone());
			consumer.setValidity(consumerBusinessDetails.getValidity());

			business.setBusinessAge(consumerBusinessDetails.getBusinessAge());
			business.setBusinessTurnover(consumerBusinessDetails.getBusinessTurnover());
			business.setBusinessValue(consumerBusinessDetails.getBusinessValue());
			business.setCapitalInvested(consumerBusinessDetails.getCapitalInvested());
			business.setTotalEmployees(consumerBusinessDetails.getTotalEmployees());

			Consumer consumerSave = consumerRepository.save(consumer);
			log.debug("Consumer saved : {}", consumerSave);
			Business businessSave = businessRepository.save(business);
			log.debug("Business saved : {}", businessSave);

			log.debug("ConsumerBusinessDetails Updated: {}", consumerBusinessDetails);
			log.info("End updateConsumerBusiness inside ConsumerServiceImpl");
			return consumerBusinessDetails;
		}
		log.info("End updateConsumerBusiness inside ConsumerServiceImpl");
		throw new ConsumerException("Sorry!!, Consumer is Not Eligibile for Insurance.");
	}

	@Transactional
	public ConsumerBusinessDetails getConsumerBusiness(long consumerId) throws ConsumerException {
		log.info("Start getConsumerBusiness inside ConsumerServiceImpl");

		Optional<Consumer> consumer = Optional.ofNullable(consumerRepository.findById(consumerId)
				.orElseThrow(() -> new ConsumerException("Consumer is not Found.")));
		Consumer consumers = consumer.get();
		log.debug("Consumer : {}", consumers);

		Optional<Business> optionalBusiness = Optional.ofNullable(businessRepository.findById(consumerId)
				.orElseThrow(() -> new ConsumerException("Consumer is not Found.")));
		Business business = optionalBusiness.get();
		log.debug("Business : {}", business);

		ConsumerBusinessDetails consumerBusinessDetails = new ConsumerBusinessDetails(consumers.getName(),
				consumers.getDob(), consumers.getBusinessName(), consumers.getPanDetails(), consumers.getEmail(),
				consumers.getPhone(), consumers.getBusinessOverview(), consumers.getValidity(),
				consumers.getAgentName(), consumers.getAgentId(), business.getBusinessId(), business.getConsumerId(),
				business.getBusinessCategory(), business.getBusinessType(), business.getBusinessTurnover(),
				business.getCapitalInvested(), business.getTotalEmployees(), business.getBusinessValue(),
				business.getBusinessAge()

		);
		log.debug("ConsumerBusinessDetails : {}", consumerBusinessDetails);
		log.info("End getConsumerBusiness with  inside ConsumerServiceImpl");
		return consumerBusinessDetails;
	}

	@Transactional
	public List<ConsumerBusinessDetails> getAllConsumerBusiness() {
		log.info("Start getAllConsumerBusiness inside ConsumerServiceImpl");
		List<Consumer> consumerList = consumerRepository.findAll();
		List<Business> businessList = businessRepository.findAll();
		List<ConsumerBusinessDetails> consumerBusinessDetailList = new ArrayList<>();
		for (int i = 0; i < consumerList.size(); i++) {
			consumerBusinessDetailList.add(new ConsumerBusinessDetails(consumerList.get(i).getName(),
					consumerList.get(i).getDob(), consumerList.get(i).getBusinessName(),
					consumerList.get(i).getPanDetails(), consumerList.get(i).getEmail(), consumerList.get(i).getPhone(),
					consumerList.get(i).getBusinessOverview(), consumerList.get(i).getValidity(),
					consumerList.get(i).getAgentName(), consumerList.get(i).getAgentId(),
					businessList.get(i).getBusinessId(), businessList.get(i).getConsumerId(),
					businessList.get(i).getBusinessCategory(), businessList.get(i).getBusinessType(),
					businessList.get(i).getBusinessTurnover(), businessList.get(i).getCapitalInvested(),
					businessList.get(i).getTotalEmployees(), businessList.get(i).getBusinessValue(),
					businessList.get(i).getBusinessAge()

			));
		}
		log.debug("ConsumerBusinessDetails List : {}", consumerBusinessDetailList);
		log.info("End getAllConsumerBusiness with  inside ConsumerServiceImpl");
		return consumerBusinessDetailList;
	}

}
