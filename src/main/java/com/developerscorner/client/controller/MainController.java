package com.developerscorner.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.developerscorner.client.dto.UserLoginDto;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("message", "Hello");
		return mv;
	}
	
	@GetMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("message", "Hello");
		return mv;
	}
	
	@GetMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("loginForm", new UserLoginDto());
		return "loginForm";
	}
	
	@GetMapping("/register")
	public String register() {
		return "registerForm";
	}
	
	@GetMapping("/questions")
	public String questions() {
		return "questions";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
}
