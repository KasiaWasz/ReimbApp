package com.reimbursements.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "authorities")
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorityID;
	@Column(nullable=false)
	private String authorityName;
	
	
	public Authority() {}


	public Authority(int authorityID, String authorityName) {
		super();
		this.authorityID = authorityID;
		this.authorityName = authorityName;
	}


	public int getAuthorityID() {
		return authorityID;
	}


	public void setAuthorityID(int authorityID) {
		this.authorityID = authorityID;
	}


	public String getAuthorityName() {
		return authorityName;
	}


	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}


	@Override
	public int hashCode() {
		return Objects.hash(authorityID, authorityName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		return authorityID == other.authorityID && Objects.equals(authorityName, other.authorityName);
	}


	@Override
	public String toString() {
		return "Authority [authorityID=" + authorityID + ", authorityName=" + authorityName + "]";
	}
	

	
	
	
}
