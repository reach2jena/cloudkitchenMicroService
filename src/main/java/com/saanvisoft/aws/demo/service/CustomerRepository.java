package com.saanvisoft.aws.demo.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saanvisoft.aws.demo.model.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	Customer findByUsername(String userName);
	
	
}