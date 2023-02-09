package com.reimbursements.services;

import org.springframework.stereotype.Service;

import com.reimbursements.models.Status;
import com.reimbursements.reporitories.StatusRepository;



@Service
public class StatusService {
	private StatusRepository statusRepository;
		
	
	
		public StatusService(StatusRepository statusRepository) {
		super();
		this.statusRepository = statusRepository;
	}



		public Status getByStatusID(int statusID) {
			return statusRepository.getByStatusID(statusID);
		}
}