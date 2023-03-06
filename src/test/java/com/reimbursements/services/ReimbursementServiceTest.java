package com.reimbursements.services;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.reimbursements.SecurityReimbursementsApplication;
import com.reimbursements.models.Reimbursement;

@SpringBootTest
@ContextConfiguration(classes = SecurityReimbursementsApplication.class)
public class ReimbursementServiceTest {
	
	@Autowired
	private ReimbursementService reimbursementService;
	private UserService userService;
	//private StatusService statusService;
//	private TypeService typeService;
	
	@Test
	public void testUpdateReimbursement() {
		
		 Reimbursement reimbursement = reimbursementService.getById(1).get();
		 reimbursement.setResolver(userService.getByUserId(2)); 

		 
		assertEquals("test2", reimbursement.getResolver().getUsername());
	}

}
