package com.saanvisoft.aws.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saanvisoft.aws.demo.model.SignUpRequest;
import com.saanvisoft.aws.demo.service.Customer;
import com.saanvisoft.aws.demo.service.CustomerRepository;
import com.saanvisoft.aws.demo.service.LoginRequest;
import com.saanvisoft.aws.demo.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoginController {


	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<Object>  addCustomer(@RequestBody LoginRequest loginRequest) {
		return userService.login(loginRequest);
	}
	@PostMapping("/signup")	
	public ResponseEntity<Object> signUp(@RequestBody SignUpRequest signUpDto){
		return userService.signUp(signUpDto);
	}


}
