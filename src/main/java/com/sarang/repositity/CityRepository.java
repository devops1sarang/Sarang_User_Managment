package com.sarang.repositity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarang.entity.CityMaster;

public interface CityRepository extends JpaRepository<CityMaster, Serializable> {
	public List<CityMaster> findByStateId(String stateId);

}
