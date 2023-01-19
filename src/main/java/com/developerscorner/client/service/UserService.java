package com.developerscorner.client.service;

import org.springframework.http.ResponseEntity;

import com.developerscorner.client.dto.AuthResponse;
import com.developerscorner.client.dto.UserLoginDto;
import com.developerscorner.client.dto.UserRegistrationDto;
import com.developerscorner.client.model.User;

public interface UserService {
	ResponseEntity<AuthResponse> login(UserLoginDto dto);
	ResponseEntity<User[]> findAll();
	ResponseEntity<User> findById(Long id);
	ResponseEntity<User> findByUsername(String username);
	ResponseEntity<User> findByEmail(String email);
	ResponseEntity<AuthResponse> save(UserRegistrationDto dto);
	ResponseEntity<?> update(Long id, UserRegistrationDto dto);
	void delete(Long id);
}
