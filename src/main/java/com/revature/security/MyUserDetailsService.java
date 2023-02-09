package com.revature.security;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDAO userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username){
		User user = userDao.getUserByUsername(username);
		if(user == null) {
			 throw new UsernameNotFoundException(username);
		}
		
		
		return new UserPrincipal(user);
	}

}
