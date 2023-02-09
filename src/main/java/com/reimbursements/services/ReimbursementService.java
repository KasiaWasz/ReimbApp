package com.reimbursements.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursements.models.Reimbursement;
import com.reimbursements.models.Status;
import com.reimbursements.models.User;
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

	public void addNewReimbursement(CreateReimbursementRequest req) {
		final Reimbursement newReimbursement = new Reimbursement();
		
		newReimbursement.setAuthor(userService.getByUserId(req.getAuthorID()));
		newReimbursement.setAmount(req.getAmount());
		newReimbursement.setSubmitted(req.getSubmitted());
		newReimbursement.setStatus(statusService.getByStatusID(req.getStatusID())); // 1-append, 2-denied, 3-approved
		newReimbursement.setType(typeService.getByTypeID(req.getTypeID()));
		newReimbursement.setDescription(req.getDescription());			
		reimbursementRepository.save(newReimbursement);
		
	}


//	public List<Reimbursement> getByReimbursement(User user) {
//		
//			return reimbursementRepository.findAll();
//
//	}
	
	
	public List<Reimbursement> getReimb(User user, Status status){
			Optional<List<Reimbursement>> reimb = reimbursementRepository.getByAuthor(user);
			if(reimb.isPresent() && status.getStatus().equals("APPROVED") || status.getStatus().equals("DENIED") ) {
				return reimb.get();}
		return new ArrayList<Reimbursement>();
		
	}
	public UpdateReimbursementRequest update(UpdateReimbursementRequest req) {
		Optional<Reimbursement> uReimbursement = reimbursementRepository.getById(req.getId());
		if(uReimbursement.isPresent()) {
			Reimbursement updateReimbursement = uReimbursement.get();
			updateReimbursement.setResolver(userService.getByUserId(req.getResolverID()));
			updateReimbursement.setResolved(req.getResolved());
			updateReimbursement.setStatus(statusService.getByStatusID(req.getStatusID()));
			reimbursementRepository.save(updateReimbursement);
			return req;
		}
		return null;
	}
	}