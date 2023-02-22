package com.reimbursements.models;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@JsonBackReference(value="author-reimbursement")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorID")
    private User author;
	
	@JsonBackReference(value="resolver-reimbursement")
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resolverID")
    private User resolver;
	@Column(nullable=false)
    private double amount;
	@Column(nullable=false)
	private String submitted;
    private String resolved;
    @Column(nullable=false)
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusID")
    @JsonBackReference(value = "status")
    private Status status;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeID")
    @JsonBackReference(value = "type")
    private Type type;

	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, User author, User resolver, double amount, String submitted, String resolved,
			String description, Status status, Type type) {
		super();
		this.id = id;
		this.author = author;
		this.resolver = resolver;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, resolved, resolver, status, submitted, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(resolved, other.resolved)
				&& Objects.equals(resolver, other.resolver) && Objects.equals(status, other.status)
				&& Objects.equals(submitted, other.submitted) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", author=" + author + ", resolver=" + resolver + ", amount=" + amount
				+ ", submitted=" + submitted + ", resolved=" + resolved + ", description=" + description + ", status="
				+ status + ", type=" + type + "]";
	}

	
	
    
	
	
}