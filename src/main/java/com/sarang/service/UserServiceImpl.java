package com.sarang.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.sarang.domain.UserPojo;
import com.sarang.entity.CityMaster;
import com.sarang.entity.CountryMaster;
import com.sarang.entity.StateMaster;
import com.sarang.entity.User;
import com.sarang.repositity.CityRepository;
import com.sarang.repositity.CountryRepository;
import com.sarang.repositity.StateRepository;
import com.sarang.repositity.UserRepository;
import com.sarang.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	EmailUtils emailUtil;

	@Override
	public String loginCheck(String userName, String pazzword) {
		User user = userRepository.findByUserEmailAndUserPazzword(userName, pazzword);
		if (null == user) {
			return "Invalid Crediantial";
		} else if (user.getAccStatus() == "LOCKED") {
			return "Account is locked";
		}
		return "VALID";
	}

	@Override
	public Map<String, String> loadCountries() {
		List<CountryMaster> countries = countryRepository.findAll();
		Map<String, String> countryMap = new HashMap<>();
		countries.forEach(country -> {
			countryMap.put(country.getId(), country.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<String, String> loadStateByCountryId(String countryId) {
		List<StateMaster> states = stateRepository.findByCountryId(countryId);
		Map<String, String> stateMap = new HashMap<>();
		states.forEach((state) -> {
			System.out.println(state.getStateName());
			stateMap.put(state.getId(), state.getStateName());
		});
		return stateMap;
	}

	@Override
	public Map<String, String> loadCityByStateId(String stateId) {
		List<CityMaster> cities = cityRepository.findByStateId(stateId);
		Map<String, String> cityMap = new HashMap<>();
		cities.forEach(city -> {
			cityMap.put(city.getId(), city.getCityName());
		});
		return cityMap;
	}

	@Override
	public boolean isUniqueEmail(String email) {
		return null == userRepository.findByUserEmail(email);
	}

	@Override
	public String generateTempPassword() {

		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
		StringBuilder sb = new StringBuilder(6);
		for (int i = 0; i < 6; i++) {
			int index = (int) (alphaNumericString.length() * Math.random());
			sb.append(alphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public String getRegSuccMailBody(User user) {
		File resource = null;
		try {
			resource = new ClassPathResource("UNLOCK-ACCOUNT-EMAIL-TEMPLATE.txt").getFile();
			System.out.println("PATH+" + new ClassPathResource("UNLOCK-ACCOUNT-EMAIL-TEMPLATE.txt").getPath());
		} catch (Exception e) {
			System.out.println(e);
		}
		Path path = resource.toPath();
		String mailBody = null;
		List<String> mailLine = null;
		try {
			Stream<String> lines = Files.lines(path);
			mailLine = lines.map(
					line -> line.replace("{firstName}", user.getFirstName()).replace("{lastName}", user.getLastName())
							.replace("{tempPwd}", user.getTempPwd()).replace("{email}", user.getUserEmail()))
					.collect(Collectors.toList());
			lines.close();
			mailBody = String.join("", mailLine);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("mail body " + mailBody);
		return mailBody;
	}

	@Override
	public boolean sendRegSuccessfullMail(String to, String body, String subject) {
		return emailUtil.sendEmail(to, subject, body);
	}

	@Override
	public boolean saveUser(UserPojo userPojo) {
		User user = new User();
		user.setAccStatus("LOCKED");
		user.setTempPwd(generateTempPassword());
		user.setCityId(userPojo.getCityId());
		user.setCountryId(userPojo.getCountryId());
		user.setDateOfBirth(userPojo.getDateOfBirth());
		user.setFirstName(userPojo.getFirstName());
		user.setGender(userPojo.getGender());
		user.setLastName(userPojo.getLastName());
		user.setStateId(userPojo.getStateId());
		user.setUserEmail(userPojo.getUserEmail());
		user.setUserPhoneNumber(userPojo.getUserPhoneNumber());
		user = userRepository.save(user);
		boolean isUserSaved = null != user && null != user.getId();
		String mailBody = getRegSuccMailBody(user);
		if (isUserSaved)
			sendPwdToEmail(user.getUserEmail(), "Registration successfull ", mailBody);
		return isUserSaved;
	}

	@Override
	public boolean isValidTempPazz(String email, String pazzword) {
		return null != userRepository.findByUserEmailAndTempPwd(email, pazzword);
	}

	@Override
	public boolean unlockAccount(String email, String pazzword) {
		User user = userRepository.findByUserEmail(email);
		user.setAccStatus("UNLOCKED");
		user.setUserPazzword(pazzword);
		user = userRepository.save(user);
		System.out.println("password is " + user.getUserPazzword());
		return null != user;
	}

	@Override
	public String recoverPassword(String email) {
		return null;
	}

	@Override
	public String getRecoverPwdEmailBody(User user) {
		return null;
	}

	@Override
	public boolean sendPwdToEmail(String to, String subject, String body) {
		return emailUtil.sendEmail(to, subject, body);
	}

}
