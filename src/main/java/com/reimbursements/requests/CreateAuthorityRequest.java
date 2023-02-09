package com.reimbursements.requests;

public class CreateAuthorityRequest {
	private String authorityName;
	private int userAuthID;
	
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public int getUserAuthID() {
		return userAuthID;
	}
	public void setUserAuthID(int userAuthID) {
		this.userAuthID = userAuthID;
	}
	
	

}
