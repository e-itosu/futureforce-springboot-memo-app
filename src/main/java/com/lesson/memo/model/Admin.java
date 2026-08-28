package com.lesson.memo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "admins")
@Data

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "last_name", nullable = false)
	@NotBlank(message = "姓を入力してください")
	private String lastName;
	
	@Column(name = "first_name", nullable = false)
	@NotBlank(message = "名を入力してください")
	private String firstName;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "メールアドレスを入力してください")
	private String email;
	
	@Column(nullable = false)
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	
	@CreationTimestamp 
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	

}
