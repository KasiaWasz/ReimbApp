package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Status;

public interface StatusDAO extends JpaRepository<Status, Integer> {
	public Status getByStatusID(int statusID);

}
