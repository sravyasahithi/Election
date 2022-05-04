package com.election.service;
import java.util.ArrayList;

import com.election.models.Electionbean;
import com.election.models.Partybean;
import com.election.models.Candidatebean;
import java.util.ArrayList;
import java.util.List;
public interface AdminService {

	Electionbean addElection(Electionbean electionbean);
	Electionbean modifyElection(Electionbean electionbean);
	int removeElection(String electionID);
	ArrayList<Electionbean> viewByAllElections();
	Electionbean viewByElectionId(String electionId);
	
	Partybean viewByPartyId(String partyID);
	ArrayList<Partybean> viewByAllParty();
	Partybean addParty(Partybean partybean);
	boolean modifyParty(Partybean partybean);
	int removeParty(String partyID);
	
	List<Candidatebean> viewByCandidate();
	List<Candidatebean> viewByCandidateId(String candidateId);
	Candidatebean addCandidate(Candidatebean candidatebean);
	boolean modifyCandidate(Candidatebean candidatebean);
	int removeCandidate(String candidateId);

	
	
	
}
	

	
