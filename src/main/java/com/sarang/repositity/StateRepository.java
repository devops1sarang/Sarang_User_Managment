package com.sarang.repositity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarang.entity.StateMaster;

public interface StateRepository extends JpaRepository<StateMaster, Serializable> {
	public List<StateMaster> findByCountryId(String countryId);

}
