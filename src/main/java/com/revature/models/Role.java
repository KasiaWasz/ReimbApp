package com.revature.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	private int roleID;
	@Column(nullable=false)
	private String roleName;
	//@OneToMany(mappedBy="role", fetch=FetchType.LAZY)
	//@JsonManagedReference
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	private boolean role;
	
	public Role() {
		super();
	}

	public Role(int roleID, String roleName, Set<User> users, boolean role) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.users = users;
		this.role = role;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, roleID, roleName, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return role == other.role && roleID == other.roleID && Objects.equals(roleName, other.roleName)
				&& Objects.equals(users, other.users);
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + ", users=" + users + ", role=" + role + "]";
	}

}