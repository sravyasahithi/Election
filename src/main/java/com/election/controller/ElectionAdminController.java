package com.election.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.election.exception.ElectionNotFoundException;
import com.election.models.Electionbean;
import com.election.service.AdminService;

@RestController
public class ElectionAdminController {

@Autowired
AdminService adser;

@PostMapping(value="/election/save",consumes = "application/json")
public String addElection(@RequestBody Electionbean election) {
	
	Random rand = new Random();
	int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
	election.setElectionID(election.getName().substring(0,2) + Integer.toString(resRandom)); 
	adser.addElection(election);
	 return "Added Successfully";
	
}
@GetMapping(value="/election/viewall")
public ArrayList<Electionbean> viewall(){
	if(adser.viewByAllElections().isEmpty()) {
		System.out.println("No Election is available");
		throw new ElectionNotFoundException();
	}
	return adser.viewByAllElections();
}

@GetMapping(value="/election/viewById/{electionID}")
public Electionbean viewById(@PathVariable("electionID") String electionID ) {
	if(adser.viewByElectionId(electionID)==null) {
		System.out.println("No Election is available");
		throw new ElectionNotFoundException();
	}
	return adser.viewByElectionId(electionID);
}
@DeleteMapping(value="/election/delete/{electionID}")
public String deleteflight(@PathVariable("electionID") String electionID) {
	
		
	adser.removeElection(electionID);	
	
	return "Deleted Successfully";
	
	
}

@PutMapping(value="/election/update")
public Electionbean updateFlight(@RequestBody Electionbean election) {
	return adser.modifyElection(election);
}
}

