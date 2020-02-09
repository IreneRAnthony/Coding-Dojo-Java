package com.Irene.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.dojosninjas.models.Dojo;
import com.Irene.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojo(){
		return dojoRepository.findAll();	
	}
	
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
	
}
