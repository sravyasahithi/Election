package com.election.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.election.dao.ElectionDetailsRepo;
import com.election.dao.PartyDetailsRepo;
import com.election.exception.NoElectionOrPartyFound;
import com.election.exception.CandidateNotFoundException;
import com.election.models.Electionbean;
import com.election.models.Partybean;
import com.election.models.Candidatebean;
import com.election.service.AdminService;

@RestController
public class CandidateAdminController {

	
@Autowired
AdminService adms;

@Autowired
ElectionDetailsRepo fl;

@Autowired
PartyDetailsRepo rpo;

@GetMapping(value="/Candidate/viewall",produces = "application/json")
public List<Candidatebean> viewallCandidate() {
	if(adms.viewByCandidate().isEmpty()) {
		throw new CandidateNotFoundException();
	}
	return adms.viewByCandidate();
	
}

@PostMapping(consumes = "application/json",value="/schedule/save")
public String addCandidate(@RequestBody Candidatebean candidatebean) {

	List<Electionbean> fdetails = fl.findAll();
	List<Partybean> rddetails = rpo.findAll();

	for(Electionbean fd: fdetails) {
		for(Partybean rd: rddetails) {

		candidatebean.getParty().setPartyID(rd.getPartyID());
			Random rand = new Random();
			int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
			candidatebean.setCandidateID(Integer.toString(resRandom)); 
			adms.addCandidate(candidatebean);
			return "Added succesfully";
			 	
	}
		
	}
	throw new NoElectionOrPartyFound();
	
}

@GetMapping(value="/Candidate/viewById/{candidateID}")
public List<Candidatebean> viewById(@PathVariable("candidateID") String candidateID ) {
	
	if(adms.viewByCandidateId(candidateID)==null) {
		System.out.println("No Candidate is available");

		throw new CandidateNotFoundException();
	}
	return adms.viewByCandidateId(candidateID);
	
}


}
