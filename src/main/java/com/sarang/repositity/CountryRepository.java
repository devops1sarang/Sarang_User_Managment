package com.sarang.repositity;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarang.entity.CountryMaster;

public interface CountryRepository extends JpaRepository<CountryMaster, Serializable> {

}
