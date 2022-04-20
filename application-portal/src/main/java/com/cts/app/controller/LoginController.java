package com.cts.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.app.dto.AuthenticationResponseDTO;
import com.cts.app.model.LoginModel;
import com.cts.app.service.LoginService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping
	public ModelAndView showLogin() {
		log.info("showLogin inside LoginController");
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginform", new LoginModel());
		return mv;
	}

	@PostMapping
	public ModelAndView performLogin(@Valid @ModelAttribute("loginform") LoginModel model, BindingResult result,
			HttpServletRequest request) throws FeignException {
		log.info("showLogin inside LoginController");
		ModelAndView mv = new ModelAndView("login");
		log.info(" Before Token generation");
		AuthenticationResponseDTO token = null;
		try {
			token = loginService.login(model);
		} catch (Exception e) {
			log.info("Exception");
			mv.addObject("error", "Invalid Credentials");
			return mv;
		}
		request.getSession().setAttribute("token", "Bearer " + token.getJwtAuthToken());
		request.getSession().setAttribute("userName", model.getUserName());
//		request.getSession().setMaxInactiveInterval(1);
		log.info(" After Token generation");
		log.info(token.getJwtAuthToken());

		return new ModelAndView("redirect:/home");

	}
}
