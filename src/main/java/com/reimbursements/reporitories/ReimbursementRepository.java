package com.reimbursements.reporitories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reimbursements.models.Reimbursement;
import com.reimbursements.models.User;


public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer>{

	
	public Optional<List<Reimbursement>> getByAuthor(User author);
	public Optional<Reimbursement> getById(int reimbursementID);
	
}