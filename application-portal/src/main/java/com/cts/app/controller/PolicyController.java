package com.cts.app.controller;

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

import com.cts.app.payload.request.CreatePolicyRequest;
import com.cts.app.payload.request.IssuePolicyRequest;
import com.cts.app.payload.response.PolicyDetailsResponse;
import com.cts.app.restclient.FeignAuthorizationClient;
import com.cts.app.restclient.FeignPolicyClient;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private FeignPolicyClient feignPolicyClient;

	@Autowired
	private FeignAuthorizationClient feignAuthorizationClient;

	@GetMapping("/createpolicy")
	public String displayPolicyForm(@RequestParam("consumerId") int consumerId, HttpServletRequest request,
			ModelMap model) {
		log.info("displayPolicyForm inside PolicyController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			model.addAttribute("createPolicyRequest", new CreatePolicyRequest());
			model.addAttribute("consumerId", consumerId);
			return "createpolicy";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access create Consumer Policy Form",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}
	}

	@PostMapping("/createpolicy")
	public String createPolicy(@Valid @ModelAttribute("createPolicyRequest") CreatePolicyRequest createPolicyRequest,
			BindingResult bindingResult, HttpServletRequest request, Model model) {
		log.info("createPolicy inside PolicyController");
		if (bindingResult.hasErrors())
			return "createpolicy";

		String token = request.getSession().getAttribute("token").toString();
		try {
			feignPolicyClient.createPolicy(token, createPolicyRequest);
			log.info("Consumer Policy created Successfully");
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to create invalid Policy", this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to create invalid Policy");
			return "error";
		}
		model.addAttribute("status", "Consumer Policy created Successfully");
		return "success";
	}

	@GetMapping("/issuepolicy")
	public String displayIssuePolicyForm(@RequestParam("consumerId") Long consumerId, HttpServletRequest request,
			ModelMap model) {
		log.info("displayIssuePolicyForm inside PolicyController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			model.addAttribute("issuePolicyRequest", new IssuePolicyRequest());
			model.addAttribute("consumerId", consumerId);
			return "issuepolicy";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access Issue Policy Form", this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to access Issue Policy Form");
			return "error";
		}
	}

	@PostMapping("/issuepolicy")
	public String issuePolicy(HttpServletRequest request,
			@Valid @ModelAttribute("issuePolicyRequest") IssuePolicyRequest issuePolicyRequest,
			BindingResult bindingResult, ModelMap model) {
		log.info("issuePolicy Post method inside PolicyController");
		if (bindingResult.hasErrors())
			return "issuepolicy";

		String token = request.getSession().getAttribute("token").toString();
		try {
			feignPolicyClient.issuePolicy(token, issuePolicyRequest);
			log.info("Consumer Policy Issued Successfully");
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to issue invalid Policy", this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to issue invalid Policy");
			return "error";
		}
		model.addAttribute("status", "Consumer Policy Issued Successfully");
		return "success";
	}

	@GetMapping("/viewpolicy")
	public String viewPolicy(HttpServletRequest request, Model model, @RequestParam("consumerId") Long consumerId) {
		log.info("viewPolicy inside PolicyController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			String policyId = feignPolicyClient.viewPolicy(consumerId, token).getPolicyId();
			PolicyDetailsResponse policyDetailsResponse = feignPolicyClient.viewPolicy(token, consumerId, policyId);
			model.addAttribute("policyDetailsResponse", policyDetailsResponse);
			log.info("{}, Information: displaying Policy Details", this.getClass().getSimpleName());
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to visit invalid Policy", this.getClass().getSimpleName());
			model.addAttribute("error", "Attempting to visit invalid Policy");
			return "error";
		}
		return "viewpolicy";
	}

}
