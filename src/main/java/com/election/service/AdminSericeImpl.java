package com.election.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.dao.ElectionDetailsRepo;
import com.election.dao.PartyDetailsRepo;
import com.election.dao.CandidateDetailsRepo;
import com.election.exception.ElectionNotFoundException;
import com.election.exception.CandidateNotFoundException;
import com.election.exception.PartyNotFoundException;
import com.election.models.Electionbean;
import com.election.models.Partybean;
import com.election.models.Candidatebean;

@Service
public class AdminSericeImpl implements AdminService{
	
	@Autowired
	private ElectionDetailsRepo flr;
	
	@Autowired
	private PartyDetailsRepo rdr;
	
	@Autowired
	private CandidateDetailsRepo scfr;

	@Override
	public Electionbean addElection(Electionbean electionbean) {
		
		return flr.save(electionbean);
	}

	@Override
	public Electionbean modifyElection(Electionbean electionbean) {
		return flr.save(electionbean);
	}

	@Override
	public int removeElection(String electionID) {
		if(flr.existsById(electionID)) {
		flr.deleteById(electionID);
		return 1;
		}
		else {
			throw new ElectionNotFoundException();
			
		}
		

	}

	@Override
	public ArrayList<Electionbean> viewByAllElections() {
		return (ArrayList<Electionbean>) flr.findAll();
	}

	@Override
	public Electionbean viewByElectionId(String electionId) {
		return flr.findByElectionID(electionId);
	}

	@Override
	public Partybean viewByPartyId(String partyID) {
		
		return rdr.findByPartyID(partyID);
	}

	@Override
	public ArrayList<Partybean> viewByAllParty() {
		return (ArrayList<Partybean>) rdr.findAll();
	}

	@Override
	public Partybean addParty(Partybean partybean) {
		return rdr.save(partybean);
		
	}

	@Override
	public boolean modifyParty(Partybean partybean) {
		rdr.save(partybean);
		return true;
	}

	@Override
	public int removeParty(String partyID) {
		if(rdr.existsById(partyID)) {
		rdr.deleteById(partyID);
		return 1;
	}
		else {
			throw new PartyNotFoundException();
			}
		}

	@Override
	public List<Candidatebean> viewByCandidate() {
		return (List<Candidatebean>) scfr.findAll();
	}

	@Override
	public List<Candidatebean> viewByCandidateId(String candidateId) {
		return  (List<Candidatebean>)scfr.findByCandidateID(candidateId);
	}

	@Override
	public Candidatebean addCandidate(Candidatebean candidatebean) {
		
		return  scfr.save(candidatebean);

	}

	@Override
	public boolean modifyCandidate(Candidatebean candidatebean) {
		
		scfr.save(candidatebean);
		return true;
	}

	@Override
	public int removeCandidate(String candidateId) {
		if(scfr.existsById(candidateId)) {
		scfr.deleteById(candidateId);
		return 1;
		}
		else {
			throw new CandidateNotFoundException();
		}
	}

}