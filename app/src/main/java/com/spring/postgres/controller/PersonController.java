package com.spring.postgres.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.postgres.entity.Person;
import com.spring.postgres.repository.UserRepository;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	@Autowired
	UserRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/bulkcreate")
	public String bulkcreate() {
		repository.save(new Person("Lucas", "Matheus", 22) );
		
		return "Person are created";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @RequestBody Person people){
		repository.save(people);
		return "Person are created";
	}

}