package com.cc.dojoandninjas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cc.dojoandninjas.models.Ninja;
import com.cc.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private NinjaRepository ninjaRepo;
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public ArrayList<Ninja> getAll() {
		return (ArrayList<Ninja>) ninjaRepo.findAll();
	}
	
	public Ninja create(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}

	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;			
		}
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
