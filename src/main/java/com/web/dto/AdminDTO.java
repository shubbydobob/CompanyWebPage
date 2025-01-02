package com.web.dto;

public class AdminDTO {
	
	private String admin;
	private String password;
	private String role;
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AdminDTO [admin=" + admin + ", password=" + password + ", role=" + role + "]";
	}
	
	

}
