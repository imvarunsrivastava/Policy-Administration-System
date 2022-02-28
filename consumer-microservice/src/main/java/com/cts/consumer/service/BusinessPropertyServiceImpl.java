package com.cts.consumer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.consumer.entity.Property;
import com.cts.consumer.entity.PropertyMaster;
import com.cts.consumer.exception.ConsumerException;
import com.cts.consumer.payload.request.BusinessPropertyRequest;
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

	@Override
	public String createBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws Exception {
		log.info("Start createBusinessProperty inside BusinessPropertyImpl");

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
			log.info("End createBusinessProperty inside BusinessPropertyImpl");
			return "SuccessFully Created Business Property with Property ID :" + propertySave.getPropertyId()
					+ " and Business ID :" + propertySave.getBusinessId() + " . Thank you!!";
		}
		log.info("End createBusinessProperty inside BusinessPropertyImpl");
		return "Sorry!!, Your Business Property is Not Eligibile for Insurance.";
	}

	@Override
	public String updateBusinessProperty(BusinessPropertyRequest businessPropertyRequest) throws ConsumerException {
		log.info("Start updateBusinessProperty inside BusinessPropertyImpl");
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

			log.info("End updateBusinessProperty inside BusinessPropertyImpl");
			return "SuccessFully Updated Business Property with Consumer ID :" + propertySave.getConsumerId()
					+ " and Business ID :" + propertySave.getBusinessId() + " . Thank you!!";
		}
		log.info("End updateBusinessProperty inside BusinessPropertyImpl");
		return "Sorry!!, Your Business Property is Not Eligibile for Insurance.";
	}

	@Override
	public Property getBusinessProperty(long consumerId, long propertyId) throws ConsumerException {
		log.info("Start getBusinessProperty inside BusinessPropertyImpl");
		
		Optional<Property> optionalProperty = Optional.ofNullable(
				propertyRepository.findByConsumerIdAndPropertyId(consumerId, propertyId))
				.orElseThrow(() -> new ConsumerException("Consumer Id or Property Id is not found."));
		
		log.debug("Business Property Details : {}",optionalProperty.get());
		log.info("End getBusinessProperty inside BusinessPropertyImpl");
		return optionalProperty.get();
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
