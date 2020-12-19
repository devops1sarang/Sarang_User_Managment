/**
 * @author sarang
 */
package com.sarang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sarang.service.UserService;

@Controller
public class ForgetPasswordController {
	@Autowired
	UserService userService;

	/**
	 * This method used to load forget password from
	 * 
	 * @return
	 */
	@GetMapping(value = "/forgetPwd")
	public String loadForm() {
		return "forget";
	}

	/**
	 * this method used to handle forget password submit button.
	 * 
	 * @param email
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/forget")
	public String handleForgetPwdSubmitBtn(@RequestParam("email") String email, Model model) {

		return "forgetPwd";
	}
}
