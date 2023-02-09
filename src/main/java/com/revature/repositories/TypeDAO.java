package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Type;

public interface TypeDAO extends JpaRepository<Type, Integer> {
	public Type getByTypeID(int typeID);

}
