package com.reimbursements.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NamedQuery(name = "User.getUser", query = "select u.username, u.userID, a.authorityName from User u "
		+ "join u.authorities ua on u.userID = ua.userID join Authority a on ua.authorityID = a.authorityID where u.username= :username")

//@NamedQuery(name = "User.getUser", query = "select u.username, u.userID, a.authorityName from User u "
//		+ "join user_authorities uu on uu.user_user_id = u.userID join Authority a on uu.authorities_authorityid = a.authorityID "
//		+"where u.username= :username")


public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	@OneToMany(mappedBy="author", fetch=FetchType.LAZY)
	@JsonManagedReference(value="author-reimbursement")
	
    private List<Reimbursement> reimbursementsAuthor = new ArrayList<>();
	@OneToMany(mappedBy="resolver", fetch=FetchType.LAZY)
	@JsonManagedReference(value="resolver-reimbursement")
	
    private List<Reimbursement> reimbursementsResolver = new ArrayList<>();
	@Column(nullable=false, unique=true)
    private String username;
	@Column(nullable=false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String firstname;
    private String lastname;
    @Column(nullable=false, unique=true)
    private String email;
    private String role;
    
    @OneToMany
    
    private Set<Authority> authorities;
    
	public User() {
		super();
	}

	public User(int userID, List<Reimbursement> reimbursementsAuthor, List<Reimbursement> reimbursementsResolver,
			String username, String password, String firstname, String lastname, String email, String role,
			Set<Authority> authorities) {
		super();
		this.userID = userID;
		this.reimbursementsAuthor = reimbursementsAuthor;
		this.reimbursementsResolver = reimbursementsResolver;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.authorities = authorities;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public List<Reimbursement> getReimbursementsAuthor() {
		return reimbursementsAuthor;
	}

	public void setReimbursementsAuthor(List<Reimbursement> reimbursementsAuthor) {
		this.reimbursementsAuthor = reimbursementsAuthor;
	}

	public List<Reimbursement> getReimbursementsResolver() {
		return reimbursementsResolver;
	}

	public void setReimbursementsResolver(List<Reimbursement> reimbursementsResolver) {
		this.reimbursementsResolver = reimbursementsResolver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorities, email, firstname, lastname, password, reimbursementsAuthor,
				reimbursementsResolver, role, userID, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(authorities, other.authorities) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(password, other.password)
				&& Objects.equals(reimbursementsAuthor, other.reimbursementsAuthor)
				&& Objects.equals(reimbursementsResolver, other.reimbursementsResolver)
				&& Objects.equals(role, other.role) && userID == other.userID
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", reimbursementsAuthor=" + reimbursementsAuthor + ", reimbursementsResolver="
				+ reimbursementsResolver + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", role=" + role + ", authorities="
				+ authorities + "]";
	}

	
	
}