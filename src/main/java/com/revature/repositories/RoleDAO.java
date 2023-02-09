package com.revature.repositories;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {
	public Set<Role> getByRoleID(int roleID);
	
}
