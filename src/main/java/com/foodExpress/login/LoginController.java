package com.foodExpress.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.foodExpress.LoginService;

@Controller
@SessionAttributes("name")		//generic across the app
public class LoginController {
	
	//Set the login Server - Autowiring
	@Autowired
	private LoginService service;
		
	
	@RequestMapping(value="/hella")
	
	@ResponseBody
	public String sayHello() {
		System.out.println("in here hell");
		return "Die Fellas";	//serveletname
	}
	
	@RequestMapping(value="/redRoom", method = RequestMethod.GET)
	public String welCome() {
		System.out.println("in here redRoom");
		return "login";	//serveletname
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String inLogin() {
		System.out.println("in here inLogin");
		return "login";	//serveletname
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String handleLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
		if(!service.validateUser(name, password)) {
			model.put("errorMessage", "invalid credentials");
			return "login";
		}
		System.out.println(name);

		model.put("name", name);
		return "welcome";	//serveletname

	}
}
