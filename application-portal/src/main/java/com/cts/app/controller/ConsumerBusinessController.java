package com.cts.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.app.payload.request.BusinessPropertyRequest;
import com.cts.app.payload.request.ConsumerBusinessRequest;
import com.cts.app.payload.response.BusinessPropertyDetails;
import com.cts.app.payload.response.ConsumerBusinessDetails;
import com.cts.app.restclient.FeignAuthorizationClient;
import com.cts.app.restclient.FeignConsumerClient;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/consumer")
public class ConsumerBusinessController {

	@Autowired
	private FeignConsumerClient feignConsumerClient;

	@Autowired
	private FeignAuthorizationClient feignAuthorizationClient;

	@GetMapping("/consumerbusiness")
	public String displayConsumerBusinessForm(ModelMap model, HttpServletRequest request) {
		log.info("displayConsumerBusinessForm inside ConsumerBusinessController");
		String token = (String) request.getSession().getAttribute("token");
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			model.addAttribute("consumerBusinessRequest", new ConsumerBusinessRequest());
			return "createconsumerbusiness";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access create Consumer Business Form",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}

	}

	@PostMapping("/consumerbusiness")
	public String createConsumerBusiness(HttpServletRequest request,
			@Valid @ModelAttribute("consumerBusinessRequest") ConsumerBusinessRequest consumerBusinessRequest,
			BindingResult bindingResult, ModelMap model) {
		log.info("createConsumerBusiness inside ConsumerBusinessController");
		if (bindingResult.hasErrors())
			return "createconsumerbusiness";

		try {
			feignConsumerClient.createConsumerBusiness((String) request.getSession().getAttribute("token"),
					consumerBusinessRequest);
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to create invalid Consumer Business",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to create invalid Consumer Business");
			return "error";
		}
		model.addAttribute("status", "Consumer Business created Successfully");
		return "success";
	}

	@GetMapping("/viewconsumerbusinesslist")
	public String viewAllConsumerBusiness(HttpServletRequest request, Model model) {
		log.info("viewAllConsumerBusiness inside ConsumerBusinessController");
		try {
			List<ConsumerBusinessDetails> consumerBusinessDetails = feignConsumerClient
					.getAllConsumerBusiness((String) request.getSession().getAttribute("token"));

			model.addAttribute("consumerBusinessDetails", consumerBusinessDetails);
			log.info("{}, Information: displaying ConsumerBusinessDetails List", this.getClass().getSimpleName());
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to visit invalid ConsumerBusinessDetails",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to visit invalid ConsumerBusinessDetails");
			return "error";
		}
		return "viewconsumerbusinesslist";
	}

	@GetMapping("/viewconsumerbusiness")
	public String viewConsumerBusiness(HttpServletRequest request, Model model,
			@RequestParam("consumerId") Long consumerId) {
		log.info("viewAllConsumerBusiness inside ConsumerBusinessController");
		try {
			ConsumerBusinessDetails consumerBusinessDetails = feignConsumerClient
					.getConsumerBusiness((String) request.getSession().getAttribute("token"), consumerId);
			model.addAttribute("consumerBusinessDetails", consumerBusinessDetails);
			log.info("{}, Information: displaying ConsumerBusinessDetails", this.getClass().getSimpleName());
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to visit invalid ConsumerBusinessDetails",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to visit invalid ConsumerBusinessDetails");
			return "error";
		}
		return "viewconsumerbusiness";
	}

	@GetMapping("/updateconsumerbusiness")
	public String updateConsumerBusiness(HttpServletRequest request, Model model,
			@RequestParam("consumerId") Long consumerId) {
		log.info("updateConsumerBusiness inside ConsumerBusinessController");
		try {
			ConsumerBusinessDetails consumerBusinessDetails = feignConsumerClient
					.getConsumerBusiness((String) request.getSession().getAttribute("token"), consumerId);
			model.addAttribute("consumerBusinessDetails", consumerBusinessDetails);
			log.info("{}, Information: displaying ConsumerBusinessDetails", this.getClass().getSimpleName());
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access invalid ConsumerBusinessDetails",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to access invalid ConsumerBusinessDetails");
			return "error";
		}
		return "updateconsumerbusiness";
	}

	@PostMapping("/updateconsumerbusiness")
	public String updateConsumerBusiness(HttpServletRequest request,
			@Valid @ModelAttribute("consumerBusinessDetails") ConsumerBusinessDetails consumerBusinessDetails,
			BindingResult bindingResult, ModelMap model) {
		log.info("updateConsumerBusiness inside ConsumerBusinessController");
		if (bindingResult.hasErrors())
			return "updateconsumerbusiness";

		try {
			feignConsumerClient.updateConsumerBusiness((String) request.getSession().getAttribute("token"),
					consumerBusinessDetails).getBody();

		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to update invalid Consumer Business",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to update invalid Consumer Business");
			return "error";
		}
		model.addAttribute("status", "Consumer Business updated Successfully");
		return "success";
	}

	// Consumer Property

	@GetMapping("/consumerproperty")
	public String displayConsumerPropertyForm(ModelMap model, HttpServletRequest request) {
		log.info("displayConsumerPropertyForm inside ConsumerBusinessController");
		String token = (String) request.getSession().getAttribute("token");
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			model.addAttribute("businessPropertyRequest", new BusinessPropertyRequest());
			return "createconsumerproperty";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to create invalid Consumer Business",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}
	}

	@PostMapping("/consumerproperty")
	public String createConsumerProperty(HttpServletRequest request,
			@Valid @ModelAttribute("businessPropertyRequest") BusinessPropertyRequest businessPropertyRequest,
			BindingResult bindingResult, ModelMap model) {
		log.info("createConsumerProperty inside ConsumerBusinessController");
		if (bindingResult.hasErrors())
			return "createconsumerproperty";
		try {
			String token = (String) request.getSession().getAttribute("token");
			feignConsumerClient.createBusinessProperty(token, businessPropertyRequest);
			log.info("{}, Information: {}", this.getClass().getSimpleName());
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to create invalid Business Property",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to Create invalid ConsumerBusinessDetails");
			return "error";
		}
		model.addAttribute("status", "Business Property created Successfully");
		return "success";
	}

	@GetMapping("/viewconsumerpropertylist")
	public String viewAllConsumerProperty(HttpServletRequest request, Model model) {
		log.info("viewAllConsumerProperty inside ConsumerBusinessController");
		try {
			String token = (String) request.getSession().getAttribute("token");
			List<BusinessPropertyDetails> businessPropertyDetails = feignConsumerClient.getAllBusinessProperty(token);
			model.addAttribute("businessPropertyDetails", businessPropertyDetails);
			log.info("{}, Information: displaying BusinessPropertyDetails", this.getClass().getSimpleName());
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to visit invalid ConsumerPropertyDetails",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to visit invalid ConsumerPropertyDetails");
			return "error";
		}
		return "viewconsumerpropertylist";
	}

	@GetMapping("/viewconsumerproperty")
	public String viewConsumerProperty(HttpServletRequest request, Model model,
			@RequestParam("consumerId") Long consumerId, @RequestParam("propertyId") Long propertyId) {
		log.info("viewConsumerProperty inside ConsumerBusinessController");
		try {
			String token = (String) request.getSession().getAttribute("token");
			BusinessPropertyDetails businessPropertyDetails = feignConsumerClient.getBusinessProperty(token, consumerId,
					propertyId);
			model.addAttribute("businessPropertyDetails", businessPropertyDetails);
			log.info("{}, Information: displaying ConsumerPropertyDetails", businessPropertyDetails);

		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to visit invalid ConsumerPropertyDetails",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to visit invalid ConsumerPropertyDetails");
			return "error";
		}
		return "viewconsumerproperty";
	}

	@GetMapping("/updateconsumerproperty")
	public String updateConsumerProperty(HttpServletRequest request, Model model,
			@RequestParam("consumerId") Long consumerId, @RequestParam("propertyId") Long propertyId) {
		log.info("updateConsumerProperty inside ConsumerBusinessController");

		try {
			String token = (String) request.getSession().getAttribute("token");
			BusinessPropertyDetails businessPropertyDetails = feignConsumerClient.getBusinessProperty(token, consumerId,
					propertyId);
			model.addAttribute("businessPropertyDetails", businessPropertyDetails);
			log.info("{}, Information: displaying ConsumerPropertyDetails", businessPropertyDetails);

		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to update invalid ConsumerPropertyDetails",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to update invalid ConsumerPropertyDetails");
			return "error";
		}
		return "updateconsumerproperty";
	}

	@PostMapping("/updateconsumerproperty")
	public String updateConsumerProperty(HttpServletRequest request, Model model,
			@Valid @ModelAttribute("businessPropertyDetails") BusinessPropertyDetails businessPropertyDetails,
			BindingResult bindingResult) {
		log.info("updateConsumerProperty inside ConsumerBusinessController");

		if (bindingResult.hasErrors())
			return "updateconsumerproperty";
		try {
			String token = (String) request.getSession().getAttribute("token");
			feignConsumerClient.updateBusinessProperty(token, businessPropertyDetails);
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to update invalid Business Property",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to update invalid Business Property");
			return "error";
		}
		model.addAttribute("status", "Business Property updated Successfully");
		return "success";
	}
}
