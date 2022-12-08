package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.Reimbursement;
import com.revature.requests.CreateReimbursementRequest;
import com.revature.requests.UpdateReimbursementRequest;
import com.revature.services.ReimbursementService;


@RestController
@RequestMapping("/reimbursements")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ReimbursementController {
	
	private ReimbursementService reimbursementService;
	
	@Autowired
	public ReimbursementController(ReimbursementService reimbursementService) {
		super();
		this.reimbursementService = reimbursementService;
	}
	
	
	@PostMapping("/addreimbursement")
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'FINANCE_MANAGER')")
	public ResponseEntity<Reimbursement> addReimbursement(@RequestBody CreateReimbursementRequest req) {
		reimbursementService.addNewReimbursement(req);
		return ResponseEntity.status(200).build();
	}
	
	@PutMapping("/updatereimbursement")
	@PreAuthorize("hasRole('FINANCE_MANAGER')")
	public ResponseEntity<UpdateReimbursementRequest> updateReimbursement(@RequestBody UpdateReimbursementRequest req, HttpSession session){ 
		//SecurityContext securityContext = SecurityContextHolder.getContext();
		
		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			reimbursementService.update(req);
			return ResponseEntity.status(200).body(req);
		}else {
		return null;}}
	

}
