package com.election.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.election.models.Electionbean;

public interface ElectionDetailsRepo extends JpaRepository<Electionbean, String> {

	Electionbean findByElectionID(String electionID);
	
}

