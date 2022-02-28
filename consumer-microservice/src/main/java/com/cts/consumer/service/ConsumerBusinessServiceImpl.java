package com.cts.consumer.service;

import java.util.Optional;

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

	@Override
	public String createConsumerBusiness(ConsumerBusinessRequest consumerBusinessRequest) throws Exception {
		log.info("Start createConsumerBusiness inside ConsumerServiceImpl");

		BusinessMaster businessMaster = businessMasterRepository.findByBusinessCategoryAndBusinessType(
				consumerBusinessRequest.getBusinessCategory(), consumerBusinessRequest.getBusinessType());
		log.debug("Business Master {}", businessMaster);

		if (businessMaster != null && businessMaster.getTotalEmployees() <= consumerBusinessRequest.getTotalEmployees()
				&& businessMaster.getBusinessAge() <= consumerBusinessRequest.getBusinessAge()) {

			Consumer consumer = new Consumer(consumerBusinessRequest.getName(), consumerBusinessRequest.getDob(),
					consumerBusinessRequest.getBusinessName(), consumerBusinessRequest.getPanDetails(),
					consumerBusinessRequest.getEmail(), consumerBusinessRequest.getPhone(),
					consumerBusinessRequest.getBusinessOverview(), consumerBusinessRequest.getValidity(),
					consumerBusinessRequest.getAgentId(), consumerBusinessRequest.getAgentName());

			log.debug("Consumer: {}", consumer);
			Consumer consumersave = consumerRepository.save(consumer);

			log.debug("Consumer Save: {}", consumersave);
			Long businessvalue = calBusinessValue(consumerBusinessRequest.getBusinessTurnover(),
					consumerBusinessRequest.getCapitalInvested());
			log.debug("BusinessValue: {}", businessvalue);
			Business business = new Business(consumersave.getConsumerId(),
					consumerBusinessRequest.getBusinessCategory(), consumerBusinessRequest.getBusinessType(),
					consumerBusinessRequest.getBusinessTurnover(), consumerBusinessRequest.getCapitalInvested(),
					consumerBusinessRequest.getTotalEmployees(), businessvalue,
					consumerBusinessRequest.getBusinessAge());
			log.debug("Business: {}", business);
			Business businesssave = businessRepository.save(business);
			log.debug("Business Save: {}", businesssave);
			log.info("End createConsumerBusiness inside ConsumerServiceImpl");
			return "SuccessFully Created Consumer with Consumer ID :" + consumersave.getConsumerId()
					+ " and Business ID :" + businesssave.getBusinessId() + " . Thank you!!";
		}
		log.info("End createConsumerBusiness inside ConsumerServiceImpl");
		return "Sorry!!, Consumer is Not Eligibile for Insurance";
	}

	public Long calBusinessValue(Long businessturnover, Long capitalinvested) {
		log.info("Start CalBusinessValue");
		if (businessturnover == 0 || capitalinvested == 0 || (businessturnover == capitalinvested)) {
			throw new NullPointerException("NullPointerException in CalBusinessValue");
		}

		Double x_ratio = (double) (businessturnover / capitalinvested);
		log.debug("X_ratio: {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) businessturnover;
		Double x_min = (double) capitalinvested;
		Double range_diff = (double) (Range_max - Range_min);
		log.debug("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double businessvalue = (range_diff * sat);
		log.debug("BusinessValue: {}", businessvalue);
		log.info("End CalBusinessValue");
		return (long) Math.abs(Math.round(businessvalue));
	}

	@Override
	public String updateConsumerBusiness(ConsumerBusinessDetails consumerBusinessDetails) throws ConsumerException {
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
			log.info("End updateConsumerBusiness inside ConsumerServiceImpl");
			return "SuccessFully Updated Consumer with Consumer ID :" + consumerSave.getConsumerId()
					+ " and Business ID :" + businessSave.getBusinessId() + " . Thank you!!";
		}
		log.info("End updateConsumerBusiness inside ConsumerServiceImpl");
		return "Sorry!!, Consumer is Not Eligibile for Insurance";
	}

	@Override
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

}
