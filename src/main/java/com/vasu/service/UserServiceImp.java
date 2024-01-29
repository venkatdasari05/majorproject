package com.vasu.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.vasu.entity.UserEntity;
import com.vasu.repo.UserInfoRepo;
import com.vasu.request.LoginRequest;
import com.vasu.request.PwdChangeRequest;
import com.vasu.request.SignUpRequest;
import com.vasu.response.DashboardResponse;
import com.vasu.response.LoginResponse;
import com.vasu.utils.MailSenderUtil;



@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@Autowired
	private MailSenderUtil mailUtil;

	@Override
	public boolean saveUser(SignUpRequest request) {
		
		//generate Random password
		String tempRandomPwd = generateRandomPwd();
		request.setPassword(tempRandomPwd);
		request.setPwdChanged(false);
		
		//save user details
		UserEntity entity= new UserEntity();
		BeanUtils.copyProperties(request, entity);
	    userInfoRepo.save(entity);
	    
	    //sending mail
	    String subject= " IES -Account created";
	    String body= "Your Temp Password :: " +tempRandomPwd;
	    
	    return mailUtil.sendMail(request.getEmail(), subject,body);
		
		
		// TODO Auto-generated method stub
		//return (isSendMail) ? true : false;
	}

	@Override
	public LoginResponse userLogin(LoginRequest loginRequest) {
		LoginResponse response= new LoginResponse();
		
		UserEntity entity = new UserEntity();
		entity.setEmail(loginRequest.getEmail());
		entity.setPassword(loginRequest.getPwd());
		
		Example<UserEntity> of= Example.of(entity);
		List<UserEntity> entities = userInfoRepo.findAll(of);
		
		if(!entities.isEmpty()) {
			UserEntity user= entities.get(0);
			
			response.setUserId(user.getUserId());
			response.setUserType(user.getUserType());
			
			if(user.isPwdChanged()) {
				//second time login
				response.setPwdChanged(true);
				response.setIsValidLogin(true);
				
				//Set dashbord setup
				DashboardResponse dashboard = new DashboardResponse();
				dashboard.setPlansCount(6l);
				dashboard.setCitizenApprovedCount(12345678l);
				dashboard.setCitizenDnCount(5000l);
				dashboard.setBenefitAmtTotal(540000.00);
				response.setDashboardResponse(dashboard);
				
			}else {
				//first time login
				response.setPwdChanged(false);
				response.setIsValidLogin(true);
			}
		}else {
			response.setIsValidLogin(false);
		}
		
		
		// TODO Auto-generated method stub
		return response;
	}

	@Override
	public LoginResponse updatePwd(PwdChangeRequest pwdRequest) {
		LoginResponse response= new LoginResponse();
		
		Integer userId = pwdRequest.getUserId();
		Optional<UserEntity> id = userInfoRepo.findById(userId);
		
		if(id.isPresent()) {
			UserEntity entity= new UserEntity();
			entity.setPassword(pwdRequest.getPassword());
			entity.setPwdChanged(true);
			userInfoRepo.save(entity);
			response.setIsValidLogin(true);
			
			response.setUserId(entity.getUserId());
			response.setUserType(entity.getUserType());
			
			DashboardResponse dashboard= new DashboardResponse();
			dashboard.setPlansCount(6l);
			dashboard.setCitizenApprovedCount(12345678l);
			dashboard.setCitizenDnCount(5000l);
			dashboard.setBenefitAmtTotal(540000.00);
			response.setDashboardResponse(dashboard);
			
		}
		
		// TODO Auto-generated method stub
		return response;
	}

	@Override
	public boolean recoverPwd(String email) {
		
		UserEntity user = userInfoRepo.findByEmail(email);
		
		if(user==null) {
			return false;
		}
		String subject= "REset Password link";
		
		String body= "User login password:: " +user.getPassword();
		 return mailUtil.sendMail(email, subject, body);
		
		
		
	}
	
	public String generateRandomPwd() {
		
		String s= "ABCDGHSJSJ123";
		StringBuilder sb= new StringBuilder();
		Random rm= new Random();
		int l=5;
		for(int i=0;i<l;i++) {
			int index= rm.nextInt(s.length());
			char rnChar= s.charAt(index);
			sb.append(rnChar);
		}
		return sb.toString();
		}

}
