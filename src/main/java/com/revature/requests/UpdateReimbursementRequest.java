package com.revature.requests;

import java.sql.Timestamp;

public class UpdateReimbursementRequest {
	private int id;
	private int resolverID;
	private Timestamp resolved;
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
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	

	
}
