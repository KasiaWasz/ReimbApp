package com.reimbursements.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.reimbursements.SecurityReimbursementsApplication;
import com.reimbursements.models.User;

@SpringBootTest
@ContextConfiguration(classes = SecurityReimbursementsApplication.class)
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void testgetUserByUsername() {
		User user = userService.getUser("test");
		assertEquals("test", user.getEmail());
	}
	
	@Test
	public void testgetByUserID() {
		User user = userService.getByUserId(1);
		assertEquals("test", user.getUsername());
}}
