package com.election.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.election.models.Partybean;

public interface PartyDetailsRepo extends JpaRepository<Partybean, String> {

	Partybean findByPartyID(String partyID);
	
}
