package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "usr_tbl")
@Table (name = "usr_tbl")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "user_id")
	private int user_id;
	
	@Column (name = "user_mail")
	private String user_mail;
	
	@Column (name = "user_name")
	private String name;
	
	@Column (name = "user_password")
	private String password;
	
	@Column (name = "user_type")
	private int type;
	
	@Column (name = "user_created_at")
	private Date created_at;
	
	@Column (name = "user_updated_at")
	private Date updated_at;
	
	@Column (name = "user_deleted_at")
	private Date deleted_at;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
}
