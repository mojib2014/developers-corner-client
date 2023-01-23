package com.developerscorner.client.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.developerscorner.client.dto.UserRegistrationDto;
import com.developerscorner.client.model.User;
import com.developerscorner.client.dto.AuthResponse;
import com.developerscorner.client.dto.UserLoginDto;
import com.developerscorner.client.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// ----------------- Register user ----------------------------
	@PostMapping(value = "/register")
	public ResponseEntity<AuthResponse> register(@Valid @RequestBody UserRegistrationDto dto) {
		ResponseEntity<AuthResponse> authResponse = userService.save(dto);
		return authResponse;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody UserLoginDto dto) {
			ResponseEntity<AuthResponse> authResponse = userService.login(dto);

			return authResponse;
	}

	@GetMapping("/users")
	public ResponseEntity<User[]> users() {
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/users/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		return userService.findByEmail(email);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserRegistrationDto dto) {
		return userService.update(id, dto);
	}
}
