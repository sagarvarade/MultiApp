package com.multiappui.app.controller;

import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multiappui.URLS.CallsWithOtherServices;
import com.multiappui.domain.AppUser;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CallsWithOtherServices URLS;

	@GetMapping("/")
	public String index() {
		return "loginfolder/login";
	}

	/*
	 * @GetMapping("/") public String index(Model model) { Authentication
	 * auth=SecurityContextHolder.getContext().getAuthentication(); if(!(auth
	 * instanceof AnonymousAuthenticationToken)) {
	 * model.addAttribute("authorities",auth.getAuthorities());
	 * model.addAttribute("credentials",auth.getCredentials());
	 * model.addAttribute("details",auth.getDetails());
	 * model.addAttribute("principal",auth.getPrincipal());
	 * model.addAttribute("class",auth.getClass());
	 * model.addAttribute("name",auth.getName()); //return "mainapp/index"; return
	 * "welcome"; } return "loginfolder/login"; }
	 */

	@PostMapping("/login")
	public String login(Model model,@RequestParam("username") String username,@RequestParam("password") String password) {
		System.out.println("HHHHHHHHHHHHHHH");
		HttpResponse<String> checkUserCredentials = URLS.checkUserCredentials(username,
				password);
		logger.info("Check status code: {} " + checkUserCredentials.statusCode());
		model.addAttribute("user", new AppUser());
		if (checkUserCredentials.statusCode() == 200) {
			return "welcome";
		} else
			return "loginfolder/login";
	}

	@GetMapping("/admin/home")
	public String adminLandingPage() {
		logger.info("Accessing admin page");
		return "loginfolder/admin"; // this name should match to admin.html inside templates folder
	}

	@GetMapping("/user/home")
	public String userLandingPage() {
		logger.info("Accessing user page");
		return "loginfolder/user"; // this name should match to user.html inside templates folder
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("user", new AppUser());
		return "mainapp/home";
	}

}