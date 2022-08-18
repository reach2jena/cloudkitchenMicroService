package com.saanvisoft.aws.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.saanvisoft.aws.demo.model.SignUpRequest;
import com.saanvisoft.aws.demo.model.User;

@Component
public class UserService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public ResponseEntity<Object> login(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		Customer user = customerRepository.findByUsername(loginRequest.getUserName());
        if(user == null) {
        	return new ResponseEntity<Object>("User does not exist", HttpStatus. INTERNAL_SERVER_ERROR);
          //  throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(loginRequest.getPassword())){
        	return new ResponseEntity<Object>("Password mismatch.", HttpStatus.INTERNAL_SERVER_ERROR);
        	
          //  throw new RuntimeException("Password mismatch.");
        }
        return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	
	 public  ResponseEntity<Object> signUp(SignUpRequest signUpDto) {
	      
	        try{
	        	Customer user = new Customer();
	        
	        //can use Bcrypt
	        BeanUtils.copyProperties(signUpDto, user);
	        customerRepository.save(user);
	       
	        return new ResponseEntity<Object>(user, HttpStatus.OK);
	        }catch(Exception e)
	        {
	        	return new ResponseEntity<Object>("Error in registering customer.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}
