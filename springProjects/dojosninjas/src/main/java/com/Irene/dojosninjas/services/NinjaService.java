package com.Irene.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Irene.dojosninjas.models.Dojo;
import com.Irene.dojosninjas.models.Ninja;
import com.Irene.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService (NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinja(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	
	public Ninja findNinja (Long id) {
		Optional <Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public void deleteNinja (Long id) {
		ninjaRepository.deleteById(id);
	}
	
	public List<Ninja> findByDojoId(Dojo id){
		return ninjaRepository.findByDojoId(id);
	}
	
	
}
