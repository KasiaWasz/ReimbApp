package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.requests.CreateUserRequest;


@Service
public class UserService {
	private UserDAO userDAO;
	private RoleService roleService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
//	@Autowired
//	public UserService(UserDAO userDAO, RoleService roleService, @Lazy BCryptPasswordEncoder bCryptPasswordEncoder) {
//		super();
//		this.userDAO = userDAO;
//		this.roleService = roleService;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
	
	@Autowired
	public UserService(UserDAO userDAO, RoleService roleService,
			@Lazy BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDAO = userDAO;
		this.roleService = roleService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	public void register(CreateUserRequest req) {
		final User newUser = new User();
			newUser.setUsername(req.getUsername());
			newUser.setPassword(bCryptPasswordEncoder.encode(req.getPassword()));
			newUser.setFirstname(req.getFirstname());
			newUser.setLastname(req.getLastname());
			newUser.setEmail(req.getEmail());
			newUser.setRoles(roleService.getByRoleID(req.getRoleID()));
			
			userDAO.save(newUser);
		
	}
	
	public User getUser(String username) {
		User user = userDAO.getUserByUsername(username);
		if(user == null) {
			return null;
		}else {
			return userDAO.getUserByUsername(username);
		}
	}
	
	public User login(User user) {
		User dbUser = userDAO.getUserByUsername(user.getUsername());
		if(dbUser == null) {
			return null;
		}
		return dbUser;
	}
	public User getByUserId(int id) {
		return userDAO.getByUserID(id).orElse(null);
		
	}

}
