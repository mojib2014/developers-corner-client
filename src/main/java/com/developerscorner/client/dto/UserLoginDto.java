package com.developerscorner.client.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDto {

	@Override
	public String toString() {
		return "UserLoginDto [email=" + email + ", password=" + password + "]";
	}

	@NotNull(message = "Email is required and must be a valid email")
	private String email;
	
	@NotNull(message = "Password is required and must be at least 6 characters")
	@Size(message = "Password must be between 6 to 20 charactars long.", min = 6, max = 20)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
