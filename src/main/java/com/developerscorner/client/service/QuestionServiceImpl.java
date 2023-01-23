package com.developerscorner.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.developerscorner.client.dto.QuestionDto;
import com.developerscorner.client.model.Question;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired RestTemplate restTemplate;
	@Value("${base-url}")
	private String baseUrl;

	@Override
	public ResponseEntity<Question[]> findAll() {
		return restTemplate.getForEntity(baseUrl + "/user/questions", Question[].class);
	}

	@Override
	public ResponseEntity<Question> findById(Long id) {
		return restTemplate.getForEntity(baseUrl + "/user/questions/" + id, Question.class);
	}

	@Override
	public ResponseEntity<Question[]> findByUserId(Long userId) {
		return restTemplate.getForEntity(baseUrl + "/user/questions/question?userId=" + userId, Question[].class);
	}
	
	@Override
	public ResponseEntity<?> save(QuestionDto dto) {
		return restTemplate.postForObject(baseUrl + "/user/questions", dto, ResponseEntity.class);
	}

	@Override
	public ResponseEntity<?> update(Long id, QuestionDto dto) {
		restTemplate.put(baseUrl + "/user/questions/" + id, dto, ResponseEntity.class);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		restTemplate.delete(baseUrl + "/user/questions/" + id, ResponseEntity.class);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
