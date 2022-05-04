package com.election.models;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Candidate_details")
public class Candidatebean {
	@Id
	private String candidateID;
	private String name;
	private String district;
	private String constituency;
	private Date dateOfBirth;
	private String mobileNo;
	private String address;
	private String emailID;
	
	
@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name="election_id")
	private Electionbean Election;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="party_id")
    private Partybean Party;

}

