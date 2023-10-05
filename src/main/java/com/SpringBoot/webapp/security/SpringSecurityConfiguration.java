package com.SpringBoot.webapp.security;

import static  org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	 
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
	
	String username;
	String password;
	UserDetails userDetails = createNewUser("urvashi", "urvashi");
	UserDetails userDetails1 = createNewUser("satra", "satra");
	return new InMemoryUserDetailsManager(userDetails,userDetails1);
	
		
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input-> passwordEncoder().encode(input);
		UserDetails userDetails=	
			User.builder()
			.passwordEncoder(passwordEncoder)
			.username(username)
			.password(password)
			.roles("USER","ADMIN").build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(
		auth ->auth.anyRequest().authenticated());
		
		httpSecurity.formLogin(withDefaults());
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		
		return httpSecurity.build();
	}
}
