package com.cts.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.app.restclient.FeignAuthorizationClient;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private FeignAuthorizationClient feignAuthorizationClient;

	@GetMapping
	public String displayHomePage(Model model, HttpServletRequest request) {
		log.info("displayHomePage inside HomeController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			return "home";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access create Consumer Policy Form",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}
	}

	@GetMapping("/businessoption")
	public String displayBusinessPage(Model model, HttpServletRequest request) {
		log.info("displayHomePage inside HomeController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			return "businessoption";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access create Consumer Policy Form",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}
	}

	@GetMapping("/propertyoption")
	public String displayPropertyPage(Model model, HttpServletRequest request) {
		log.info("displayHomePage inside HomeController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			return "propertyoption";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access create Consumer Policy Form",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}

	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		log.info("logout inside HomeController");
//		request.getSession().invalidate();
		request.getSession().removeAttribute("token");
		return "redirect:/login";

	}

	@GetMapping("/about")
	public String about(Model model, HttpServletRequest request) {
		log.info("about inside HomeController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			return "about";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access About Page",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}

	}
	
	@GetMapping("/contact")
	public String contact(Model model, HttpServletRequest request) {
		log.info("contact inside HomeController");
		String token = request.getSession().getAttribute("token").toString();
		try {
			feignAuthorizationClient.validatingAuthorizationToken(token);
			return "contact";
		} catch (FeignException e) {
			log.debug("{}, Information: Attempting to access Contact Page",
					this.getClass().getSimpleName());
			model.addAttribute("error", "Please Login again.");
			return "error";
		}

	}
}
