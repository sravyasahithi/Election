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

import com.election.exception.PartyNotFoundException;
import com.election.models.Partybean;
import com.election.service.AdminService;

@RestController
public class PartyAdminController {

@Autowired
AdminService adser;

@PostMapping(value="/party/save",consumes = "application/json")
public String addParty(@RequestBody Partybean party) {
	
	Random rand = new Random();
	int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
	party.setPartyID(Integer.toString(resRandom)); 
	adser.addParty(party);
	 return "Added Successfully";
	
}
@GetMapping(value="/party/viewall")
public ArrayList<Partybean> viewall(){
	if(adser.viewByAllParty().isEmpty()) {
		System.out.println("No Party is available");
		throw new PartyNotFoundException();
	}
	return adser.viewByAllParty();
}

@GetMapping(value="/Party/viewById/{partyID}")
public Partybean viewById(@PathVariable("partyID") String partyID ) {
	if(adser.viewByPartyId(partyID)==null) {
		System.out.println("No Party is available");
		throw new PartyNotFoundException();
	}
	return adser.viewByPartyId(partyID);
}
@DeleteMapping(value="/party/delete/{routeID}")
public String deleteparty(@PathVariable("partyID") String partyID) {
	
		
	adser.removeParty(partyID);
	return "Deleted Successfully";
	
	
}

@PutMapping(value="/party/update")
public String updateparty(@RequestBody Partybean party) {
	adser.modifyParty(party);
	
	return "Updated Successfully";
}
}
