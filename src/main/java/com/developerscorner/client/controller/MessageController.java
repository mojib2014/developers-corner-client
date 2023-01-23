package com.developerscorner.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.developerscorner.client.model.Message;

@Controller
public class MessageController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/gs-guide-websocket/info")
	public Message chat(Message dto) {
		ResponseEntity<Message> res = restTemplate.postForEntity("http://localhost:8080/gs-guide-websocket", dto, Message.class);
		Message message = res.getBody();
		return message;
	}
}
