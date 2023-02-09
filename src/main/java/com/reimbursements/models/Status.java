package com.reimbursements.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusID;
	@Column(nullable=false)
	private String status;
	@OneToMany(mappedBy="status", fetch=FetchType.LAZY)
	@JsonManagedReference(value = "status")
    private List<Reimbursement> reimbursements = new ArrayList<>();
	
	public Status() {
		super();
	}

	public Status(int statusID, String status, List<Reimbursement> reimbursements) {
		super();
		this.statusID = statusID;
		this.status = status;
		this.reimbursements = reimbursements;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimbursements, status, statusID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return Objects.equals(reimbursements, other.reimbursements) && Objects.equals(status, other.status)
				&& statusID == other.statusID;
	}

	@Override
	public String toString() {
		return "Status [statusID=" + statusID + ", status=" + status + ", reimbursements=" + reimbursements + "]";
	}
	
	
	
	

}
