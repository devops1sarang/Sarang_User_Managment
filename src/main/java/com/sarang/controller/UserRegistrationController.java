package com.sarang.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sarang.domain.UnlockAccount;
import com.sarang.domain.UserPojo;
import com.sarang.service.UserService;

@Controller
public class UserRegistrationController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/register")
	public String loadRegistrationForm(Model model) {
		UserPojo userPojo = new UserPojo();
		model.addAttribute("user", userPojo);
		Map<String, String> countries = userService.loadCountries();
		model.addAttribute("countries", countries);
		return "registration";
	}

	@GetMapping(value = "/uniqueMailCheck")
	public @ResponseBody String uniqMailCheck(@RequestParam("email") String email) {
		return userService.isUniqueEmail(email) ? "unique" : "duplicate";

	}

	@GetMapping(value = "/countryChange")
	public @ResponseBody Map<String, String> handleCountryChangeEvent(@RequestParam("countryId") String countryId) {
		return userService.loadStateByCountryId(countryId);
	}

	@GetMapping(value = "/stateChange")
	public @ResponseBody Map<String, String> handleStateChangeEvent(@RequestParam("stateId") String stateId) {
		return userService.loadCityByStateId(stateId);
	}

	@PostMapping(value = "/registerUser")
	public String handleRegisterBtn(UserPojo userPojo, RedirectAttributes redir) {
		if (userService.saveUser(userPojo)) {
			redir.addFlashAttribute("success", "User Registered sucessfully");
		} else {
			redir.addFlashAttribute("error", "User Registration fail");
		}
		return "redirect:/register";
	}

	@GetMapping(value = "/unlockAccount")
	public String unlockAccount(@RequestParam("email") String email, Model model) {
		UnlockAccount unlockAccount = new UnlockAccount();
		unlockAccount.setEmail(email);
		model.addAttribute("unlock", unlockAccount);
		return "unlock";
	}

	@PostMapping(value = "/unlockAccount")
	public String handleUnlockAccountBtn(@ModelAttribute("unlock") UnlockAccount unlockAccount,
			RedirectAttributes redir) {
		boolean isValid = userService.isValidTempPazz(unlockAccount.getEmail(), unlockAccount.getTempPwd());
		if (isValid && (unlockAccount.getNewPwd().equals(unlockAccount.getConfirmPwd()))) {
			userService.unlockAccount(unlockAccount.getEmail(), unlockAccount.getNewPwd());
			redir.addFlashAttribute("success", "Account unlocked successfully");
			System.out.println("account unlocked");
		} else {
			redir.addFlashAttribute("error", "faild to unlocked account");
			return "redirect:/unlockAccount?email=?" + unlockAccount.getEmail();
		}
		return "redirect:/";
	}
}
