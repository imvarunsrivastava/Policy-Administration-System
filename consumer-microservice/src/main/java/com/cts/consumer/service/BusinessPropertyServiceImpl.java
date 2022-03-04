package com.cts.consumer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.consumer.entity.Property;
import com.cts.consumer.entity.PropertyMaster;
import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.BusinessPropertyRequest;
import com.cts.consumer.payload.response.BusinessPropertyDetails;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;
import com.cts.consumer.repository.PropertyMasterRepository;
import com.cts.consumer.repository.PropertyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BusinessPropertyServiceImpl implements BusinessPropertyService {

	@Autowired
	private PropertyMasterRepository propertyMasterRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private ConsumerBusinessService consumerBusinessService;

	@Transactional
	public BusinessPropertyDetails createBusinessProperty(BusinessPropertyRequest businessPropertyRequest)
			throws ConsumerException {
		log.info("Start createBusinessProperty inside BusinessPropertyImpl");

		BusinessPropertyDetails businessPropertyDetails;

		PropertyMaster propertyMaster = propertyMasterRepository.findByInsuranceTypeAndPropertyType(
				businessPropertyRequest.getInsuranceType(), businessPropertyRequest.getPropertyType());
		log.debug("Property Master {}", propertyMaster);
		if (propertyMaster != null
				&& businessPropertyRequest.getBuildingType().equalsIgnoreCase(propertyMaster.getBuildingType())
				&& propertyMaster.getBuildingAge() <= businessPropertyRequest.getBuildingAge()) {

			long propertyValue = calPropertyValue(businessPropertyRequest.getCostOfTheAsset(),
					businessPropertyRequest.getSalvageValue(), businessPropertyRequest.getUsefulLifeOfTheAsset());

			Property property = new Property(businessPropertyRequest.getBusinessId(),
					businessPropertyRequest.getConsumerId(), businessPropertyRequest.getInsuranceType(),
					businessPropertyRequest.getPropertyType(), businessPropertyRequest.getBuildingSqft(),
					businessPropertyRequest.getBuildingType(), businessPropertyRequest.getBuildingStoreys(),
					businessPropertyRequest.getBuildingAge(), propertyValue,
					businessPropertyRequest.getCostOfTheAsset(), businessPropertyRequest.getSalvageValue(),
					businessPropertyRequest.getUsefulLifeOfTheAsset());
			Property propertySave = propertyRepository.save(property);

			log.debug("Property save : {}", propertySave);

			ConsumerBusinessDetails consumerBusinessDetails = consumerBusinessService
					.getConsumerBusiness(businessPropertyRequest.getConsumerId());

			businessPropertyDetails = new BusinessPropertyDetails(propertySave.getPropertyId(),
					businessPropertyRequest.getBusinessId(), businessPropertyRequest.getConsumerId(),
					consumerBusinessDetails.getName(), businessPropertyRequest.getInsuranceType(),
					businessPropertyRequest.getPropertyType(), businessPropertyRequest.getBuildingSqft(),
					businessPropertyRequest.getBuildingType(), businessPropertyRequest.getBuildingStoreys(),
					businessPropertyRequest.getBuildingAge(), propertyValue,
					businessPropertyRequest.getCostOfTheAsset(), businessPropertyRequest.getSalvageValue(),
					businessPropertyRequest.getUsefulLifeOfTheAsset());
			log.debug("BusinessPropertyDetails : {}", businessPropertyDetails);
			log.info("End createBusinessProperty inside BusinessPropertyImpl");
			return businessPropertyDetails;
		}
		log.info("End createBusinessProperty inside BusinessPropertyImpl");
		throw new ConsumerException("Sorry!!, Your Business Property is Not Eligibile for Insurance.");
	}

	@Transactional
	public BusinessPropertyDetails updateBusinessProperty(BusinessPropertyRequest businessPropertyRequest)
			throws ConsumerException {
		log.info("Start updateBusinessProperty inside BusinessPropertyImpl");
		BusinessPropertyDetails businessPropertyDetails;

		Optional<Property> optionalProperty = Optional.ofNullable(propertyRepository
				.findByConsumerIdAndBusinessId(businessPropertyRequest.getConsumerId(),
						businessPropertyRequest.getBusinessId())
				.orElseThrow(() -> new ConsumerException("Consumer Id or Business Id is not found.")));

		PropertyMaster propertyMaster = propertyMasterRepository.findByInsuranceTypeAndPropertyType(
				businessPropertyRequest.getInsuranceType(), businessPropertyRequest.getPropertyType());
		log.debug("Property Master {}", propertyMaster);
		if (propertyMaster != null
				&& businessPropertyRequest.getBuildingType().equalsIgnoreCase(propertyMaster.getBuildingType())
				&& propertyMaster.getBuildingAge() <= businessPropertyRequest.getBuildingAge()) {

			long propertyValue = calPropertyValue(businessPropertyRequest.getCostOfTheAsset(),
					businessPropertyRequest.getSalvageValue(), businessPropertyRequest.getUsefulLifeOfTheAsset());

			Property property = optionalProperty.get();

			property.setBuildingAge(businessPropertyRequest.getBuildingAge());
			property.setBuildingSqft(businessPropertyRequest.getBuildingSqft());
			property.setBuildingStoreys(businessPropertyRequest.getBuildingStoreys());
			property.setBuildingType(businessPropertyRequest.getBuildingType());
			property.setCostOfTheAsset(businessPropertyRequest.getCostOfTheAsset());
			property.setPropertyValue(propertyValue);
			property.setSalvageValue(businessPropertyRequest.getSalvageValue());
			property.setUsefulLifeOfTheAsset(businessPropertyRequest.getUsefulLifeOfTheAsset());

			Property propertySave = propertyRepository.save(property);
			log.debug("Update Property Details : {}", propertySave);

			ConsumerBusinessDetails consumerBusinessDetails = consumerBusinessService
					.getConsumerBusiness(businessPropertyRequest.getConsumerId());

			businessPropertyDetails = new BusinessPropertyDetails(propertySave.getPropertyId(),
					businessPropertyRequest.getBusinessId(), businessPropertyRequest.getConsumerId(),
					consumerBusinessDetails.getName(), businessPropertyRequest.getInsuranceType(),
					businessPropertyRequest.getPropertyType(), businessPropertyRequest.getBuildingSqft(),
					businessPropertyRequest.getBuildingType(), businessPropertyRequest.getBuildingStoreys(),
					businessPropertyRequest.getBuildingAge(), propertyValue,
					businessPropertyRequest.getCostOfTheAsset(), businessPropertyRequest.getSalvageValue(),
					businessPropertyRequest.getUsefulLifeOfTheAsset());
			log.debug("BusinessPropertyDetails : {}", businessPropertyDetails);
			log.info("End updateBusinessProperty inside BusinessPropertyImpl");
			return businessPropertyDetails;
		}
		log.info("End updateBusinessProperty inside BusinessPropertyImpl");
		throw new ConsumerException("Sorry!!, Your Business Property is Not Eligibile for Insurance.");
	}

	@Transactional
	public BusinessPropertyDetails getBusinessProperty(long consumerId, long propertyId) throws ConsumerException {
		log.info("Start getBusinessProperty inside BusinessPropertyImpl");
		BusinessPropertyDetails businessPropertyDetails = null;

		Optional<Property> optionalProperty = Optional
				.ofNullable(propertyRepository.findByConsumerIdAndPropertyId(consumerId, propertyId))
				.orElseThrow(() -> new ConsumerException("Consumer Id or Property Id is not found."));
		Property property = optionalProperty.get();
		log.debug("Business Property Details : {}", property);

		ConsumerBusinessDetails consumerBusinessDetails = consumerBusinessService.getConsumerBusiness(consumerId);

		businessPropertyDetails = new BusinessPropertyDetails(property.getPropertyId(), property.getBusinessId(),
				property.getConsumerId(), consumerBusinessDetails.getName(), property.getInsuranceType(),
				property.getPropertyType(), property.getBuildingSqft(), property.getBuildingType(),
				property.getBuildingStoreys(), property.getBuildingAge(), property.getPropertyValue(),
				property.getCostOfTheAsset(), property.getSalvageValue(), property.getUsefulLifeOfTheAsset());
		log.debug("BusinessPropertyDetails : {}", businessPropertyDetails);
		log.info("End updateBusinessProperty inside BusinessPropertyImpl");
		return businessPropertyDetails;
	}

	@Transactional
	public List<BusinessPropertyDetails> getAllBusinessProperty() {
		log.info("Start getAllBusinessProperty inside BusinessPropertyImpl");
		List<BusinessPropertyDetails> businessPropertyDetails = new ArrayList<>();
		List<Property> propertyList = propertyRepository.findAll();

		for (int i = 0; i < propertyList.size(); i++) {
			ConsumerBusinessDetails consumerBusinessDetails = consumerBusinessService
					.getConsumerBusiness(propertyList.get(i).getConsumerId());
			businessPropertyDetails.add(new BusinessPropertyDetails(propertyList.get(i).getPropertyId(),
					propertyList.get(i).getBusinessId(), propertyList.get(i).getConsumerId(),
					consumerBusinessDetails.getName(), propertyList.get(i).getInsuranceType(),
					propertyList.get(i).getPropertyType(), propertyList.get(i).getBuildingSqft(),
					propertyList.get(i).getBuildingType(), propertyList.get(i).getBuildingStoreys(),
					propertyList.get(i).getBuildingAge(), propertyList.get(i).getPropertyValue(),
					propertyList.get(i).getCostOfTheAsset(), propertyList.get(i).getSalvageValue(),
					propertyList.get(i).getUsefulLifeOfTheAsset())

			);
		}
		log.debug("Business Property Details List : {}", businessPropertyDetails);
		log.info("End getAllBusinessProperty inside BusinessPropertyImpl");
		return businessPropertyDetails;
	}

	public Long calPropertyValue(Long costoftheasset, Long salvagevalue, Long usefullifeoftheAsset) {
		log.info("Start calPropertyValue");
		if (usefullifeoftheAsset == 0 || salvagevalue == 0 || costoftheasset == 0 || (costoftheasset == salvagevalue)) {
			throw new NullPointerException("NullPointerException in calPropertyValue");
		}
		Double x_ratio = (double) ((costoftheasset - salvagevalue) / usefullifeoftheAsset);
		log.debug("x_ratio : {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) (costoftheasset / usefullifeoftheAsset);
		log.debug("x_max : {}", x_max);
		Double x_min = (double) (salvagevalue / usefullifeoftheAsset);
		log.debug("x_min : {}", x_min);
		Double range_diff = (Range_max - Range_min);
		log.debug("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double propertyvalue = range_diff * sat;
		log.debug("propertyvalue  : {}", propertyvalue);
		log.info("End calPropertyValue");
		return (long) Math.abs(Math.round(propertyvalue));
	}

}
