package com.reimbursements.requests;

import java.sql.Timestamp;

public class UpdateReimbursementRequest {
	private int id;
	private int resolverID;
	private int statusID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResolverID() {
		return resolverID;
	}
	public void setResolverID(int resolverID) {
		this.resolverID = resolverID;
	}

	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	

	
}
