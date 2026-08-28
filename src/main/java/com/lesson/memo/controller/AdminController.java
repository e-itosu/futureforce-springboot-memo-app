package com.lesson.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lesson.memo.model.Admin;
import com.lesson.memo.repository.AdminRepository;


@Controller
public class AdminController{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/admin/signin")
	public String showSigninForm() {
		return "admin/signin";
	}
	
	@GetMapping("/admin/signup")
	public String showSignupForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/signup";
	}
	
	@PostMapping("/admin/signup")
	public String signup(@Validated @ModelAttribute Admin admin, BindingResult result) {
	
	    if(result.hasErrors()) {
	    	return "admin/signup";	
	    }
	
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		
		adminRepository.save(admin);
		
		return "redirect:/admin/signin";
		
	}	
}