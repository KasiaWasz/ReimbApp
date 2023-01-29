package com.reimbursements.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.reimbursements.models.Authority;
import com.reimbursements.models.User;
import com.reimbursements.reporitories.AuthorityRepository;
import com.reimbursements.requests.CreateAuthorityRequest;



@Service
public class AuthorityService{
	private AuthorityRepository authorityRepository;
	private UserService userService;
	
	
	
@Autowired
	
		
	public AuthorityService(AuthorityRepository authorityRepository) {
		super();
		this.authorityRepository = authorityRepository;
		
	}


	


	public void setNewAuthority(CreateAuthorityRequest req) {
		final Authority newAuthority = new Authority();
		newAuthority.setAuthorityName(req.getAuthorityName());
		newAuthority.setUser(userService.getByUserId(req.getUserAuthID()));
		authorityRepository.save(newAuthority);
	}


	public Set<Authority> getByAuthorityID(int authorityID) {
		return authorityRepository.getByAuthorityID(authorityID);}}
