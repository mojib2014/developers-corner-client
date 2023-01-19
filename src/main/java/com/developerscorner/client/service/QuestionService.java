package com.developerscorner.client.service;

import java.util.List;

import com.developerscorner.client.model.Question;

public interface QuestionService {

	List<Question> findAll();
	Question findById(Long id);
	Question findByUserId(Long userId);
	void save(Question quesiton);
	void update(Question question);
	void delete(Long id);
}
