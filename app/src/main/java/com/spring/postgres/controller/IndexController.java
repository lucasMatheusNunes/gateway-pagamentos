package com.spring.postgres.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, path ="/")
	public String index() {
		return "API Spring Boot com PostgreSQL";
	}
}
