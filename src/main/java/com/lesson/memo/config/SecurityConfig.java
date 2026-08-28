package com.lesson.memo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		   .authorizeHttpRequests(auth -> auth
				   .requestMatchers("/css/**","/js/**","/images/**","/admin/signup","/admin/signin").permitAll()
				   .anyRequest().authenticated()
		   )
		   
		   .formLogin(form -> form
				   .loginPage("/admin/signin")
				   .loginProcessingUrl("/admin/signin")
				   .defaultSuccessUrl("/memo",true)
				   .permitAll()
		   )
		   
		   .logout(logout -> logout
				   .logoutSuccessUrl("/admin/signin?logout")
				   .permitAll()
		  );
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
