package com.sarang.service;

import java.util.Map;

import com.sarang.domain.UserPojo;
import com.sarang.entity.User;

public interface UserService {
	public String loginCheck(String userName, String pazzword);

	public Map<String, String> loadCountries();

	public Map<String, String> loadStateByCountryId(String countryId);

	public Map<String, String> loadCityByStateId(String stateId);

	public boolean isUniqueEmail(String email);

	public String generateTempPassword();

	public boolean saveUser(UserPojo userPojo);

	public String getRegSuccMailBody(User user);

	public boolean sendRegSuccessfullMail(String to, String body, String subject);

	public boolean isValidTempPazz(String email, String pazzword);

	public boolean unlockAccount(String email, String pazzword);

	public String recoverPassword(String email);

	public String getRecoverPwdEmailBody(User user);

	public boolean sendPwdToEmail(String to, String subject, String body);

}
