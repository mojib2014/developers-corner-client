package com.developerscorner.client.service;

import org.springframework.http.ResponseEntity;

import com.developerscorner.client.dto.QuestionDto;
import com.developerscorner.client.model.Question;

public interface QuestionService {

	ResponseEntity<Question[]> findAll();
	ResponseEntity<Question> findById(Long id);
	ResponseEntity<Question[]> findByUserId(Long userId);
	ResponseEntity<?> save(QuestionDto dto);
	ResponseEntity<?> update(Long id, QuestionDto dto);
	ResponseEntity<?> delete(Long id);
}
