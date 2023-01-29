package com.reimbursements.reporitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reimbursements.models.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User getUserByUsername(String username);
	//public Optional<User> getByAuthority(Authority authority);
	public Optional<User> getByUserID(int userID);
}
