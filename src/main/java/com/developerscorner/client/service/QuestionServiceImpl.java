package com.developerscorner.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.developerscorner.client.model.Question;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Question question) {
		
	}

	@Override
	public void update(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
