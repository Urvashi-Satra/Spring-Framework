package com.SpringBoot.webapp.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

	public boolean authenticate(String username,String password) {
		
		boolean isValidUsername=username.equalsIgnoreCase("urvashi");
		
		boolean isValidPassword = password.equalsIgnoreCase("urvashi");
		
		
		return isValidUsername && isValidPassword ;
	}
}
