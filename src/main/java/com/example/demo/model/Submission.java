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

@Entity (name = "submission_tbl")
@Table (name = "submission_tbl")
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "sub_id")
	private int sub_id;
	
	@Column (name = "ass_file")
	private String ass_file;
	
	@Column (name = "sub_remark")
	private String remark;
	
	@Column (name = "sub_submitted_at")
	private Date submitted_at;
	
	@Column (name = "sub_updated_at")
	private Date updated_at;
	
	@Column (name = "sub_deleted_at")
	private Date deleted_at;
	
	@OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn (name = "user_id")
	private User user_id;
	
	@OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn (name = "ass_id")
	private Assignment ass_id;
	
	public int getSub_id() {
		return sub_id;
	}
	

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getAss_file() {
		return ass_file;
	}

	public void setAss_file(String ass_file) {
		this.ass_file = ass_file;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getSubmitted_at() {
		return submitted_at;
	}

	public void setSubmitted_at(Date submitted_at) {
		this.submitted_at = submitted_at;
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


	public Assignment getAss_id() {
		return ass_id;
	}


	public void setAss_id(Assignment ass_id) {
		this.ass_id = ass_id;
	}

}
