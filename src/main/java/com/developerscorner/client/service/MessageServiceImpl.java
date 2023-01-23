package com.developerscorner.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.developerscorner.client.model.Message;

@Service("messageServie")
public class MessageServiceImpl implements MessageService {

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Message message) {
		
	}

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
