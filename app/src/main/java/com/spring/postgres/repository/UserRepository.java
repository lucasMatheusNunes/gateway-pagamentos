package com.spring.postgres.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.postgres.entity.Person;

@Repository
public interface UserRepository extends JpaRepository<Person, Long>{
	List<Person> findByFirstName(String firstName);
	List<Person> findAll();
}