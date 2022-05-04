package com.election.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.election.models.Candidatebean;

public interface CandidateDetailsRepo extends JpaRepository<Candidatebean, String> {

	List<Candidatebean> findByCandidateID(String CandidateID);
	
}
