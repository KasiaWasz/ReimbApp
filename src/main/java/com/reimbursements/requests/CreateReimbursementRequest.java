package com.reimbursements.requests;

public class CreateReimbursementRequest {
	
	private int authorID;
    private double amount;
    private int typeID;
    private String description;
    
	public CreateReimbursementRequest(int authorID, double amount, int typeID, String description) {
		super();
		this.authorID = authorID;
		this.amount = amount;
		this.typeID = typeID;
		this.description = description;
	}
	
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
	

}
