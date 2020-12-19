package com.sarang.repositity;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarang.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	public User findByUserEmail(String userEmail);

	User findByUserEmailAndTempPwd(String userEmail, String pazzword);

	public User findByUserEmailAndUserPazzword(String userEmail, String pazzword);

}
