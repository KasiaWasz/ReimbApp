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
public class Type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeID;
	@Column(nullable=false)
	private String type;
	@OneToMany(mappedBy="type", fetch=FetchType.LAZY)
	@JsonManagedReference(value = "type")
    private List<Reimbursement> reimbursements = new ArrayList<>();
	
	public Type() {
		super();
	}

	public Type(int typeID, String type, List<Reimbursement> reimbursements) {
		super();
		this.typeID = typeID;
		this.type = type;
		this.reimbursements = reimbursements;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimbursements, type, typeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		return Objects.equals(reimbursements, other.reimbursements) && Objects.equals(type, other.type)
				&& typeID == other.typeID;
	}

	@Override
	public String toString() {
		return "Type [typeID=" + typeID + ", type=" + type + ", reimbursements=" + reimbursements + "]";
	}
	
	
	
}
