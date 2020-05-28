package com.example.easylogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.example.easylogin.model.dao.UserRepository;
import com.example.easylogin.model.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	UserRepository userpo;
	
	@RequestMapping("/")
	public String index() {
		 return "index";		//index.htmlへ移動する
		
	}
	
	@RequestMapping("/login")
	public String login(
		@RequestParam("userName") String userName,
		@RequestParam("password") String password,
		Model m) {

		String message = "Hellooo";
		List<User> users = userpo.findByUserNameAndPassword(userName, password);
		
		if(users.size() > 0) {
			User user = users.get(0);
			message += user.getFullName() + user.getPassword();
			}else {
			message += "who?";
		}
		
		m.addAttribute("message", message);
		return "login";	
	}
	
	
}
