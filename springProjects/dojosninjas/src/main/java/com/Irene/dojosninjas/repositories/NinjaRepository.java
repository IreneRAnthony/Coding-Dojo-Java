package com.Irene.dojosninjas.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Irene.dojosninjas.models.Dojo;
import com.Irene.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long> {
	List <Ninja> findAll();
	List <Ninja> findByDojoId(Dojo id);
}
