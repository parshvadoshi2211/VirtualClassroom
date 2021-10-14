package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class SubmissionDto {
	
private int sub_id;
	
	private String ass_file;
	
	
	private String remark;
	
	private Date submitted_at;
	
	private Date updated_at;
	
	private Date deleted_at;
	
	private int user_id;
	
	private int ass_id;
	
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


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getAss_id() {
		return ass_id;
	}


	public void setAss_id(int ass_id) {
		this.ass_id = ass_id;
	}


}
