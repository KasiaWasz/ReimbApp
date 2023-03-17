package com.reimbursements.services;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursements.models.Authority;
import com.reimbursements.reporitories.AuthorityRepository;
import com.reimbursements.requests.CreateAuthorityRequest;



@Service
public class AuthorityService{
	private AuthorityRepository authorityRepository;
	
	
	
	@Autowired	
	public AuthorityService(AuthorityRepository authorityRepository) {
		super();
		this.authorityRepository = authorityRepository;	
	}


	@Transactional
	public void setNewAuthority(CreateAuthorityRequest req) {
		final Authority newAuthority = new Authority();
		newAuthority.setAuthorityName(req.getAuthorityName());		
		authorityRepository.save(newAuthority);
	}


	public Set<Authority> getByAuthorityID(int authorityID) {
		return authorityRepository.getById(authorityID);}}
