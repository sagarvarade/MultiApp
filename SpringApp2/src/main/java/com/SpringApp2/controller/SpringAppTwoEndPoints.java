package com.SpringApp2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class SpringAppTwoEndPoints {

	@GetMapping("/hello2")
	public String hello2() {
		return "Spring App 2 Controller";
	}
}
