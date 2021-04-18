package com.martini.windowcuts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martini.windowcuts.service.UserService;
import com.martini.windowcuts.web.dto.UserRegistrationDto;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto UserRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration.html";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		registrationDto.setRole("administracion");
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

}
