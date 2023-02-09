package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;
import com.revature.requests.CreateReimbursementRequest;
import com.revature.requests.UpdateReimbursementRequest;



@Service
public class ReimbursementService {
protected ReimbursementDAO reimbursementDAO;
protected UserService userService;
protected StatusService statusService;
protected TypeService typeService;

	@Autowired
	public ReimbursementService(ReimbursementDAO reimbursementDAO, UserService userService, StatusService statusService,
			TypeService typeService) {
		super();
		this.reimbursementDAO = reimbursementDAO;
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
		reimbursementDAO.save(newReimbursement);
		
	}


	public List<Reimbursement> getByReimbursement(User user, Role role) {
		//if(user.getRole().equals(role.getRoleName().equals("finance_manager"))) {
			return reimbursementDAO.findAll();
//		}else {
//				return null;
//			}
	}
	
	
	public List<Reimbursement> getReimb(User user, Role role, Status status){
//		if(user.getRole().equals(role.getRoleName().equals("employee"))) {
			Optional<List<Reimbursement>> reimb = reimbursementDAO.getByAuthor(user);
			if(reimb.isPresent() && status.getStatus().equals("APPROVED") || status.getStatus().equals("DENIED") ) {
				return reimb.get();}
		return new ArrayList<Reimbursement>();
		
	}
	public UpdateReimbursementRequest update(UpdateReimbursementRequest req) {
		Optional<Reimbursement> uReimbursement = reimbursementDAO.getById(req.getId());
		if(uReimbursement.isPresent()) {
			Reimbursement updateReimbursement = uReimbursement.get();
			updateReimbursement.setResolver(userService.getByUserId(req.getResolverID()));
			updateReimbursement.setResolved(req.getResolved());
			updateReimbursement.setStatus(statusService.getByStatusID(req.getStatusID()));
			reimbursementDAO.save(updateReimbursement);
			return req;
		}
		return null;
	}
	}

