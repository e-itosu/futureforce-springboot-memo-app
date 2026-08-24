package com.lesson.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String shoeSignupForm() {
		return "admin/signup";
	}
	
	@PostMapping("/admin/signup")
	public String signup(
			@RequestParam("lastName") String lastName,
			@RequestParam("firstName") String firstName,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		Admin admin = new Admin();
		admin.setLastName(lastName);
		admin.setFirstName(firstName);
		admin.setEmail(email);
		admin.setPassword(passwordEncoder.encode(password));
		
		adminRepository.save(admin);
		
		return "redirect:/admin/signin";
		
	}	
}