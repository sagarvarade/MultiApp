package com.SpringApp1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springapp1")
public class Endpoint1 {

	@GetMapping("/hello1")
	public String hello1() {
		return "Spring App 1 Controller";
	}
}
