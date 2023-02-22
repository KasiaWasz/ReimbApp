package com.reimbursements.services;

import org.springframework.stereotype.Service;

import com.reimbursements.models.Type;
import com.reimbursements.reporitories.TypeRepository;



@Service
public class TypeService {
	private TypeRepository typeRepository;
		
		
	
		public TypeService(TypeRepository typeRepository) {
		super();
		this.typeRepository = typeRepository;
	}


		public Type getByTypeID(int typeID) {
			return typeRepository.getById(typeID);
		}
}
