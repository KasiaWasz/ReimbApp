package com.reimbursements.reporitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.reimbursements.models.Authority;
import com.reimbursements.models.User;



public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User getUserByUsername(@Param("username")String username);
	//@Param("username")
	//public User getByAuthority(@Param("authority")Authority authority);
	public Optional<User> getByUserID(int userID);
}
