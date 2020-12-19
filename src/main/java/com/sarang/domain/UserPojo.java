package com.sarang.domain;

import java.util.Date;

public class UserPojo {
	private String id;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userPazzword;
	private String userPhoneNumber;
	private Date dateOfBirth;
	private String gender;
	private String cityId;
	private String stateId;
	private String countryId;
	private String accStatus;
	private Date createdDate;
	private Date updatedDate;

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

	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail=" + userEmail
				+ ", userPazzword=" + userPazzword + ", userPhoneNumber=" + userPhoneNumber + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", cityId=" + cityId + ", stateId=" + stateId + ", countryId="
				+ countryId + ", accStatus=" + accStatus + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

}
