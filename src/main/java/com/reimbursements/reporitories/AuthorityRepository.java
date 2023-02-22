package com.reimbursements.reporitories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimbursements.models.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
	public Set<Authority> getById(int authorityID);
	
}