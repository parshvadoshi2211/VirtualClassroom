package com.example.demo.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name = "assignment_tbl")
@Table (name = "assignment_tbl")
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "ass_id")
	private int ass_id;
	
	@Column (name = "ass_title")
	private String title;
	
	@Column (name = "ass_des")
	private String description;
	
	@Column (name = "ass_published_date")
	private Date publishedDate;
	
	@Column (name = "ass_due_date")
	private Date dueDate;
	
	@Column (name = "ass_created_at")
	private Date created_at;
	
	@Column (name = "ass_updated_at")
	private Date updated_at;
	
	@Column (name = "ass_deleted_at")
	private Date deleted_at;
	
	@OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn (name = "user_id")
	private User user_id;

	public int getAss_id() {
		return ass_id;
	}

	public void setAss_id(int ass_id) {
		this.ass_id = ass_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
}
