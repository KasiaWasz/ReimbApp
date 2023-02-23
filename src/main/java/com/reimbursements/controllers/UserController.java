package com.reimbursements.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursements.models.User;
import com.reimbursements.requests.CreateAuthorityRequest;
import com.reimbursements.requests.CreateUserRequest;
import com.reimbursements.services.AuthorityService;
import com.reimbursements.services.UserService;
;

@RestController
@RequestMapping(value = "/users")
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	
private UserService userService;
private AuthorityService authorityService;
	
	
	public UserController(UserService userService, AuthorityService authorityService) {
		this.userService = userService;
		this.authorityService = authorityService;
	}



	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody CreateUserRequest req) {
		userService.register(req);
		return ResponseEntity.ok().body("user successfully registered!");
	}
	
	@PostMapping("/authority-registration")
	public ResponseEntity<User> setNewAuthority(@RequestBody CreateAuthorityRequest req) {
		authorityService.setNewAuthority(req);
		return ResponseEntity.status(200).build();
	}
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> list = userService.getAllUsers();
		return ResponseEntity.status(200).body(list);
	}
}
	
	
//	@GetMapping("/{id}")
//	public UserDTO getByID(@PathVariable int id){
//		final User user= userService.getByUserId(id);
//		return new UserDTO(user);
//	}
