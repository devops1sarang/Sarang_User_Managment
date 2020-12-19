package com.sarang.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class User {

	@Id
	@Column(name = "USER_ID")
	@GenericGenerator(name = "gen1", strategy = "uuid")
	@GeneratedValue(generator = "gen1")
	private String id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "PAZZWORD")
	private String userPazzword;

	@Column(name = "PHONE_NUMBER")
	private String userPhoneNumber;

	@Column(name = "DOB")
	private Date dateOfBirth;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CITY_ID")
	private String cityId;

	@Column(name = "STATE_ID")
	private String stateId;

	@Column(name = "COUNTRY_ID")
	private String countryId;

	@Column(name = "ACCOUNT_STATUS")
	private String accStatus;

	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private Date createdDate;

	@Column(name = "UPDATE_TIME")
	@UpdateTimestamp
	private Date updatedDate;

	@Column(name = "TEMP_PWD")
	private String tempPwd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPazzword() {
		return userPazzword;
	}

	public void setUserPazzword(String userPazzword) {
		this.userPazzword = userPazzword;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getTempPwd() {
		return tempPwd;
	}

	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}

}
