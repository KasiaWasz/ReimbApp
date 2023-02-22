package com.reimbursements.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "authorities")
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorityID;
	@Column(nullable=false)
	private String authorityName;
	@Column(nullable = false)
	private int userID;


	
	public Authority() {
		super();
	}


	public Authority(int authorityID, String authorityName, int userID) {
		super();
		this.authorityID = authorityID;
		this.authorityName = authorityName;
		this.userID = userID;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;

	}

	@Override
	public int hashCode() {

		return Objects.hash(authorityID, authorityName, userID);

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
		return authorityID == other.authorityID && Objects.equals(authorityName, other.authorityName)

				&& userID == other.userID;

	}

	@Override
	public String toString() {

		return "Authority [authorityID=" + authorityID + ", authorityName=" + authorityName + ", userID=" + userID
				+ "]";
	}

	
	

}
