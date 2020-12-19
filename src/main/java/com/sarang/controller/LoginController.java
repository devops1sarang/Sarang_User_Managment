package com.sarang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarang.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	/**
	 * this method used to load the login page.
	 * 
	 * @return view Name
	 */

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}

	/**
	 * This method used to handle sign in button request.
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/login")
	public String handleSignInButton(HttpServletRequest req, Model model) {
		String viewName = "";
		String userName = req.getParameter("email");
		String pazzword = req.getParameter("pwd");
		String isValid = userService.loginCheck(userName, pazzword);
		if (isValid == "VALID") {
			viewName = "dashboard";
			model.addAttribute("userName", userName);
		} else {
			viewName = "index";
			model.addAttribute("errorMsg", isValid);

		}
		return viewName;
	}
}
