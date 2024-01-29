package com.vasu.response;

public class LoginResponse {
	
	private Integer userId;
	private String name;
	private String userType;
	private boolean isValidLogin;
	private boolean pwdChanged;
	private DashboardResponse dashboardResponse;

	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public DashboardResponse getDashboardResponse() {
		return dashboardResponse;
	}
	public void setDashboardResponse(DashboardResponse dashboardResponse) {
		this.dashboardResponse = dashboardResponse;
	}
	public boolean getIsValidLogin() {
		return isValidLogin;
	}
	public void setIsValidLogin(boolean isValidLogin) {
		this.isValidLogin = isValidLogin;
	}
	public boolean isPwdChanged() {
		return pwdChanged;
	}
	public void setPwdChanged(boolean pwdChanged) {
		this.pwdChanged = pwdChanged;
	}
	

}
