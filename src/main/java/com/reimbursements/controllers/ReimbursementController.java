package com.reimbursements.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursements.models.Reimbursement;
import com.reimbursements.requests.CreateReimbursementRequest;
import com.reimbursements.requests.UpdateReimbursementRequest;
import com.reimbursements.services.ReimbursementService;



@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {
	
	private ReimbursementService reimbursementService;
	
	@Autowired
	public ReimbursementController(ReimbursementService reimbursementService) {
		super();
		this.reimbursementService = reimbursementService;
	}
	
	@PostMapping("/add-new-reimbursement")
	public ResponseEntity<Integer> addReimbursement(@RequestBody CreateReimbursementRequest req) {
		int id = reimbursementService.addNewReimbursement(req);
		return ResponseEntity.ok(id);
	}
	
	@PutMapping("/update-reimbursement")
	public ResponseEntity<UpdateReimbursementRequest> updateReimbursement(@RequestBody UpdateReimbursementRequest req){ 
			reimbursementService.update(req);
			return ResponseEntity.status(200).body(req);
		}
	

}
