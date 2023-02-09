package com.reimbursements.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reimbursements.models.Status;



public interface StatusRepository extends JpaRepository<Status, Integer> {
	public Status getByStatusID(int statusID);

}
