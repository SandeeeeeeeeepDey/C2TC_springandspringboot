package com.cg.placementmodule;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Placement Controller class. For defining Transaction specific methods.
@RestController
public class PlacementController {
	
	// Creation of PlacementService class through Autowiring
	@Autowired
	private PlacementService service;
	
	
	// Create/addPlacement Controller. #Post Transaction
	@PostMapping("/placements/add")
	public ResponseEntity<Placement> addPlacement(@RequestBody Placement placement) {
			try{
				service.addPlacement(placement);
				return new ResponseEntity<Placement>(placement, HttpStatus.OK);
			}
			catch (DataIntegrityViolationException e){
				return new ResponseEntity<Placement>(HttpStatus.CONFLICT);
			}
	}
	
	// Retrieve/searchPlacement Controller. #Get Transaction
	@GetMapping("/placements/{id}")
	public ResponseEntity<Placement> searchPlacement(@PathVariable int id){
		
		try{
			Placement placement = service.searchPlacement(id);
			return new ResponseEntity<Placement>(placement, HttpStatus.OK);
		}
	
		catch (NoSuchElementException e){
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Update/updatePlacement Controller. #Put Transaction
	@PutMapping("/placements/{id}")
	public ResponseEntity<?> updatePlacement(@RequestBody Placement placement, @PathVariable int id)
		{
		try
		{
			Placement existPlacement = service.searchPlacement(id); // first we retrieve with id
			service.addPlacement(placement); // Then we add the changes
			return new ResponseEntity<>(placement,HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Delete/deletePlacement Controller. #Delete Transaction
	@DeleteMapping("/placements/{id}")
	public boolean cancelPlacement(@PathVariable int id) {
		try{
			Placement placement = service.searchPlacement(id); // first we verify if id is present
			service.cancelPlacement(id); // then we delete it
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	
	
}
