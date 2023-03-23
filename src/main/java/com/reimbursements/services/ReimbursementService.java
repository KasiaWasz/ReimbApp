package com.reimbursements.services;

import java.sql.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursements.models.Reimbursement;
import com.reimbursements.reporitories.ReimbursementRepository;
import com.reimbursements.requests.CreateReimbursementRequest;
import com.reimbursements.requests.UpdateReimbursementRequest;




@Service
public class ReimbursementService {
protected ReimbursementRepository reimbursementRepository;
protected UserService userService;
protected StatusService statusService;
protected TypeService typeService;

	@Autowired
	
	public ReimbursementService(ReimbursementRepository reimbursementRepository, UserService userService,
			StatusService statusService, TypeService typeService) {
		super();
		this.reimbursementRepository = reimbursementRepository;
		this.userService = userService;
		this.statusService = statusService;
		this.typeService = typeService;
	}
	
	@Transactional
	public int addNewReimbursement(CreateReimbursementRequest req) {
		final Reimbursement newReimbursement = new Reimbursement();
		
		newReimbursement.setAuthor(userService.getByUserId(req.getAuthorID()));
		newReimbursement.setAmount(req.getAmount());
		newReimbursement.setSubmitted(String.valueOf(new Date(System.currentTimeMillis())));
		newReimbursement.setStatus(statusService.getByStatusID(1)); // 1-append, 2-denied, 3-approved
		newReimbursement.setType(typeService.getByTypeID(req.getTypeID()));
		newReimbursement.setDescription(req.getDescription());			
		reimbursementRepository.save(newReimbursement);
		return newReimbursement.getId();
		
	}

	public Optional<Reimbursement> getById(int id) {
		return reimbursementRepository.getById(id);
	}
	
	
	
	@Transactional
	public UpdateReimbursementRequest update(UpdateReimbursementRequest req) {
		Optional<Reimbursement> uReimbursement = reimbursementRepository.getById(req.getId());
		if(uReimbursement.isPresent()) {
			Reimbursement updateReimbursement = uReimbursement.get();
			updateReimbursement.setResolver(userService.getByUserId(req.getResolverID()));
			updateReimbursement.setResolved(String.valueOf(new Date(System.currentTimeMillis())));
			updateReimbursement.setStatus(statusService.getByStatusID(req.getStatusID()));
			reimbursementRepository.save(updateReimbursement);
			return req;
		}
		return null;
	}
	}