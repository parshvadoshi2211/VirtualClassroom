package com.example.demo.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthByGoogle {
	private String usrnameGoogle;

	public String getUsrnameGoogle() {
		return usrnameGoogle;
	}

	public void setUsrnameGoogle(String usrnameGoogle) {
		this.usrnameGoogle = usrnameGoogle;
	}
}
