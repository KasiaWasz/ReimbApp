package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.models.Status;
import com.revature.repositories.StatusDAO;

@Service
public class StatusService {
	private StatusDAO statusDAO;
		
		public StatusService(StatusDAO statusDAO) {
			this.statusDAO = statusDAO;
		}
	
		public Status getByStatusID(int statusID) {
			return statusDAO.getByStatusID(statusID);
		}
}
