package com.reimbursements.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reimbursements.models.User;
import com.reimbursements.reporitories.UserRepository;
import com.reimbursements.requests.CreateUserRequest;



@Service
public class UserService {
	private UserRepository userRepository;
	private AuthorityService authorityService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Autowired
	public UserService(UserRepository userRepository, AuthorityService authorityService,
			@Lazy BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.authorityService = authorityService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Transactional
	public void register(CreateUserRequest req) {
		final User newUser = new User();
			newUser.setUsername(req.getUsername());
			newUser.setPassword(bCryptPasswordEncoder.encode(req.getPassword()));
			newUser.setFirstname(req.getFirstname());
			newUser.setLastname(req.getLastname());
			newUser.setEmail(req.getEmail());
			newUser.setRole(req.getRole());
			newUser.setAuthorities(authorityService.getByAuthorityID(req.getAuthorityID()));
			
			userRepository.save(newUser);	
	}
	
	
	public User getUser(String username) {
		User user = userRepository.getUserByUsername(username);
			return user;
		}
	

	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getByUserId(int id) {
		return userRepository.getByUserID(id).orElse(null);
		
	}

}
