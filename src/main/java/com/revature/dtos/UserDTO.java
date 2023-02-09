package com.revature.dtos;

import com.revature.models.User;

public class UserDTO {
	  private String username;
	    private String firstname;
	    private String lastname;
	    private String email;
	    private String roleName;

	    public UserDTO(User user) {
	    	this.username= user.getUsername();
	    	this.email=user.getEmail();
	    	this.firstname=user.getFirstname();
	    	this.lastname=user.getLastname();
	    }

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	    

}
