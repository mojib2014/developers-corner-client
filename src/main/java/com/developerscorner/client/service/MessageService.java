package com.developerscorner.client.service;

import java.util.List;

import com.developerscorner.client.model.Message;

public interface MessageService {

	List<Message> findAll();
	Message findById(Long id);
	Message findByUserId(Long userId);
	void save(Message message);
	void update(Message message);
	void delete(Long id);
}
