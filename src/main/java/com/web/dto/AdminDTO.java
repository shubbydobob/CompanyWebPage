package com.web.dto;

public class AdminDTO {
	
	private String admin;
	private String password;
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
	@Override
	public String toString() {
		return "adminDTO [admin=" + admin + ", password=" + password + "]";
	}
	

}
