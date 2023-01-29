package com.reimbursements.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reimbursements.models.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {
	public Type getByTypeID(int typeID);

}
