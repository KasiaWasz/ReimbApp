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
	
	@ManyToOne
	@JsonBackReference(value="authorities")
	@JoinColumn(name = "userAuthID")
	
	private User user;
	
	public Authority() {
		super();
	}

	public Authority(int authorityID, String authorityName, User user) {
		super();
		this.authorityID = authorityID;
		this.authorityName = authorityName;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorityID, authorityName, user);
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
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Authority [authorityID=" + authorityID + ", authorityName=" + authorityName + ", user=" + user + "]";
	}

	
}
