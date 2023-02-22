package com.SpringApp1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class SpringAppOneEndPoints {

	@GetMapping("/hello1")
	public String hello1() {
		return "Spring App 1 Controller";
	}
}
