package com.reimbursements.reporitories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reimbursements.models.User;



public interface UserRepository extends JpaRepository<User, Integer> {
//	@Query("select u.username, u.userID, a.authorityName from User u "
//			+ "join u.authorities ua on u.userID = ua.userID join Authority a on ua.authorityID = a.authorityID where u.username= :username")
	public User getUserByUsername(@Param("username")String username);
	public Optional<User> getByUserID(int userID);
	public List<User> findByUsername(String name);
}
