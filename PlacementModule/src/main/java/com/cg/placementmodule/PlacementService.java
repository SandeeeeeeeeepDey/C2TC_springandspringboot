package com.cg.placementmodule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

// Placement Service Class
@Service 
@Transactional
public class PlacementService {
	
	// Creation of PlacementRepository object using SpringBoot's Autowiring.
	@Autowired
	private PlacementRepository placementRepository;
	
	// Add service
	public void addPlacement(Placement placement) {
		placementRepository.save(placement);
	}
	
	// Get service
	public Placement searchPlacement(long id) {
		return placementRepository.findById(id).get();
		
	}
	
	// Delete service
	public void cancelPlacement(long id) {
		placementRepository.deleteById(id);
		
		
	}
	public List<Placement> listAll(){
		return placementRepository.findAll();
	}
	
	

}
