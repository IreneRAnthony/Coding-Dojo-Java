package com.Irene.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Irene.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository <License, Long>{
	List<License> findAll();
	List<License> findByPerson(String search);
	List<License> findByNumber(String search);
	License findTopByOrderByNumberDesc();
}
