package com.sarang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "city")
public class CityMaster {
	@Id
	@GenericGenerator(name = "gen1", strategy = "uuid")
	@GeneratedValue(generator = "gen1")
	@Column(name = "ID")
	private String id;
	@Column(name = "CITY_NAME")
	private String cityName;
	@Column(name = "STATE_ID")
	private String stateId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

}
