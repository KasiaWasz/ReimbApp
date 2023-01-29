package com.reimbursements.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursements.models.User;
import com.reimbursements.requests.CreateAuthorityRequest;
import com.reimbursements.requests.CreateUserRequest;
import com.reimbursements.services.AuthorityService;
import com.reimbursements.services.UserService;

@RestController
@RequestMapping(value = "/users", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	
private UserService userService;
private AuthorityService authorityService;
	
	@Autowired
	public UserController(UserService userService, AuthorityService authorityService) {
		super();
		this.userService = userService;
		this.authorityService = authorityService;
	}
	
	@Bean 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	


	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody CreateUserRequest req) {
		userService.register(req);
		return ResponseEntity.status(200).build();
	}
	@PostMapping("/authorityRegistration")
	//@RequestMapping(value = "/authorityRegistration", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<User> setNewAuthority(@RequestBody CreateAuthorityRequest req) {
		authorityService.setNewAuthority(req);
		return ResponseEntity.status(200).build();
	}
}
	
	
//	@GetMapping("/{id}")
//	public UserDTO getByID(@PathVariable int id){
//		final User user= userService.getByUserId(id);
//		return new UserDTO(user);
//	}
