 package com.idat.cazaofertas.app.models.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "document_id"))
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String first_name;
	
	private String last_name;
	
	private String document_id;
	
	private String position;
	
	private String email;
	
	private String phone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createAt;
	
	private Long user_id;
	
	@PrePersist
	public void prePresist() {
		createAt = new Date();
	}
	
	public Employee() {
	}

	public Employee(Long id) {
		this.id = id;
	}

	public Employee(Long id, String first_name, String last_name, String document_id, String position, String email,
			String phone, Date createAt, Long user_id) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.document_id = document_id;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.createAt = createAt;
		this.user_id = user_id;
	}

	public Employee(String first_name, String last_name, String document_id, String position, String email,
			String phone, Date createAt, Long user_id) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.document_id = document_id;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.createAt = createAt;
		this.user_id = user_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDocument_id() {
		return document_id;
	}

	public void setDocument_id(String document_id) {
		this.document_id = document_id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
	
	
	
	
	
	
	
}
