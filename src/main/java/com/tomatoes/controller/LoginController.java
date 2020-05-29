package com.tomatoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam (value="error", required=false)String error,
			@RequestParam(value="logout", required=false)String logout, Model model) {
		
		if(error != null) {
			model.addAttribute("error","Invalid Credentials");
		}
		
		if(logout != null) {
			model.addAttribute("message","You have successfully logged out!");
		}
		
		return "login";
		
	}
}
