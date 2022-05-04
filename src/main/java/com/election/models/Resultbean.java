package com.election.models;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="Result_details")
public class Resultbean {
	@Id
	private int serialNo;
	private String electionID;
	private String candidateID;
	private int voteCount;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name="election_id")
	private Electionbean election;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="candidate_id")
    private Candidatebean candidate;

}
