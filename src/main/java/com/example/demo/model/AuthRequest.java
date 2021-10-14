package com.example.demo.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthRequest {
	
	private static String usrname;	
	private static String password;
	private static int user_type;
	
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	
}
