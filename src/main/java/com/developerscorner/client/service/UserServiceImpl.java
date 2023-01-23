package com.developerscorner.client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.developerscorner.client.dto.AuthResponse;
import com.developerscorner.client.dto.UserLoginDto;
import com.developerscorner.client.dto.UserRegistrationDto;
import com.developerscorner.client.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Value("${base-url}")
	private String BASE_URL;
	private final RestTemplate restTemplate;
	
	public UserServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public ResponseEntity<AuthResponse> login(UserLoginDto dto) {
		ResponseEntity<AuthResponse> res = restTemplate.postForEntity(BASE_URL + "/auth/login", dto, AuthResponse.class);
		return res;
	}

	@Override
	public ResponseEntity<User[]> findAll() {
		return restTemplate.getForEntity(BASE_URL + "/users", User[].class);
	}

	@Override
	public ResponseEntity<User> findById(Long id) {
		return restTemplate.getForEntity(BASE_URL + "/users/" + id, User.class);
	}

	@Override
	public ResponseEntity<User> findByUsername(String username) {
		return restTemplate.getForEntity(BASE_URL + "/users/", null);
	}

	@Override
	public ResponseEntity<User> findByEmail(String email) {
		ResponseEntity<User> user = restTemplate.getForEntity(BASE_URL + "/users/email/" + email, User.class);
		return user;
	}
	
	@Override
	public ResponseEntity<AuthResponse> save(UserRegistrationDto dto) {
		ResponseEntity<AuthResponse> res = restTemplate.postForEntity(
				BASE_URL + "/auth/register", dto, AuthResponse.class);
		
		return res;
	}

	@Override
	public ResponseEntity<?> update(Long id, UserRegistrationDto dto) {
		restTemplate.put(BASE_URL + "/users/" + id, dto);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		restTemplate.delete(BASE_URL + "/" + id, ResponseEntity.class);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
