package com.vasu.service;

import com.vasu.request.LoginRequest;
import com.vasu.request.PwdChangeRequest;
import com.vasu.request.SignUpRequest;
import com.vasu.response.LoginResponse;

public interface UserService {
	
	public boolean saveUser(SignUpRequest signUpRequest);
	
	public LoginResponse userLogin(LoginRequest loginRequest);
	
	public LoginResponse updatePwd(PwdChangeRequest pwdRequest);
	
	public boolean recoverPwd(String email);

}
