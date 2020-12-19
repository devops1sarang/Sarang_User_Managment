package com.sarang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "state")
public class StateMaster {
	@Id
	@GenericGenerator(name = "gen1", strategy = "uuid")
	@GeneratedValue(generator = "gen1")
	@Column(name = "ID")
	private String id;
	@Column(name = "STATE_NAME")
	private String stateName;
	@Column(name = "COUNTRY_ID")
	private String countryId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

}
