package com.martini.windowcuts.service;

import org.springframework.security.core.userdetails.UserDetailsService;


import com.martini.windowcuts.model.User;
import com.martini.windowcuts.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);

}
