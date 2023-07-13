package com.cg.placementmodule;

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
	public Placement searchPlacement(int id) {
		return placementRepository.findById(id).get();
		
	}
	
	// Delete service
	public void cancelPlacement(int id) {
		placementRepository.deleteById(id);
		
		
	}
	
	

}
