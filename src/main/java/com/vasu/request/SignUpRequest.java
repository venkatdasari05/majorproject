package com.vasu.request;

import java.time.LocalDate;

public class SignUpRequest {
	
	private String name;
	private String email;
	private String phNo;
	private String password;
	private LocalDate dob;
	private String ssn;
	private String gender;
	private String userType;
	private boolean pwdChanged;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isPwdChanged() {
		return pwdChanged;
	}
	public void setPwdChanged(boolean pwdChanged) {
		this.pwdChanged = pwdChanged;
	}

}
