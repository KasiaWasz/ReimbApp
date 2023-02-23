package com.reimbursements.requests;

public class CreateAuthorityRequest {
	private String authorityName;
	private int userID;
	
	public CreateAuthorityRequest(String authorityName, int userID) {
		super();
		this.authorityName = authorityName;
		this.userID = userID;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	

}
