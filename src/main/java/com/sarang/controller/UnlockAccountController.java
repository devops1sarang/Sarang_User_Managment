package com.sarang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sarang.domain.UnlockAccount;

@Controller
public class UnlockAccountController {
	/**
	 * This method used to load the unlock screen form
	 * 
	 * @param email
	 * @param model
	 * @return view Name
	 */
	@GetMapping(value = "/loadUnlockAccount")
	public String loadUnlockAccountForm(@RequestParam("email") String email, Model model) {
		return "unlockAccount";
	}

	/**
	 * this method is used to handle the unlock functionality.
	 * 
	 * @param unlockAccount
	 * @param model
	 * @return
	 */
	@PostMapping
	public String handleSubmitBtn(UnlockAccount unlockAccount, Model model) {
		return "unlockAccount";
	}
}
