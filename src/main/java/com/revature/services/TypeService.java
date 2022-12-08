package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.models.Type;
import com.revature.repositories.TypeDAO;

@Service
public class TypeService {
	private TypeDAO typeDAO;
		
		public TypeService(TypeDAO typeDAO) {
			this.typeDAO = typeDAO;
		}
	
		public Type getByTypeID(int typeID) {
			return typeDAO.getByTypeID(typeID);
		}
}
