package com.vasu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vasu.request.SignUpRequest;
import com.vasu.service.UserService;

public class RestController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user")
	public ResponseEntity<String> userRegistration(@RequestBody SignUpRequest request){
		
		boolean saveUser = userService.saveUser(request);
		if(saveUser) {
			return new ResponseEntity<>("User is saved", HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>("Registration Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
