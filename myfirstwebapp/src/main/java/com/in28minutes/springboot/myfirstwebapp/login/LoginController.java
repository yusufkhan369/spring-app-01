package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	

	private AuthenticationSerivice authenticationSerivice;
	
	 
	
	public LoginController(AuthenticationSerivice authenticationSerivice) {
		super();
		this.authenticationSerivice = authenticationSerivice;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	//Model
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	//Model
	public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap map) {
		map.put("name", name);
		if(authenticationSerivice.authenticate(name, password)) {

		//Authentication Logic
		//name = in28minutes
		//pwd=dummy
		
		
		return "welcome";
		}
		map.put("errormessage", "Invalid credentials. Please try again!");
		return "login";
		
	}


}
