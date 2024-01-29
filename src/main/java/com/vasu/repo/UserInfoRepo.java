package com.vasu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasu.entity.UserEntity;

public interface UserInfoRepo extends JpaRepository<UserEntity, Integer> {
	
	public UserEntity findByEmail(String email);

}
