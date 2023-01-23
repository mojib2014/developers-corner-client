package com.developerscorner.client.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developerscorner.client.dto.QuestionDto;
import com.developerscorner.client.model.Question;
import com.developerscorner.client.service.QuestionService;

@RestController
@RequestMapping("/user/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping
	public ResponseEntity<Question[]> questions() {
		return questionService.findAll();
	}
	
	@GetMapping("/question")
	public ResponseEntity<Question[]> questionsByUserId(@RequestParam("userId") Long userId) {
		return questionService.findByUserId(userId);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid QuestionDto dto) {
		return questionService.save(dto);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid QuestionDto dto) {
		return questionService.update(id, dto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return questionService.delete(id);
	}
}
