package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Entity.User;
import com.Service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService service;

	@GetMapping("/register")
	public String showRegisterpage() {
		return "Registration";

	}

	@PostMapping("/Register")
	public String registeruser(@PathVariable String fullname, @PathVariable String password,
			@PathVariable String confirmpassword, Model model) {
		if (!password.equals(confirmpassword)) {
			model.addAttribute("error", "Registration successful! Please login.");
			return "Registretion";
		}

		User user = new User(fullname, password);
        service.registerUser(user);
		return "login";

	}
	@GetMapping("/login")
	public String showloginpage() {
		return "login";
		
	}
	
	@PostMapping("/login")
	public String Loginuser(@PathVariable String fullname,@PathVariable String password,Model model) {
		
		User user=service.loginUser(fullname, password);
		if(user!=null) {
			model.addAttribute("user",user);
			return"Home";
		}
		else {
			model.addAttribute("error","Invalid username or password!");
		
		return password;
		
		}
		
	}
	

	

}
