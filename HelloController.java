package com.hsbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello")
	public String sayHello() {
		return "HEllo World";
	}

	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "Welcome to REST application";
	}

}
