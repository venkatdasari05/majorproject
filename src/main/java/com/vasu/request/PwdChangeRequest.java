package com.vasu.request;

public class PwdChangeRequest {
	
	private Integer userId;
	private String email;
	private String password;
	private String confirmedPwd;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	public String getConfirmedPwd() {
		return confirmedPwd;
	}
	public void setConfirmedPwd(String confirmedPwd) {
		this.confirmedPwd = confirmedPwd;
	}
	

}
