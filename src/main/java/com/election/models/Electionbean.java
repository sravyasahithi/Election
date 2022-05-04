package com.election.models;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="Election_details")

public class Electionbean {
	@Id
	private String electionID;
	private String name;
	private Date electionDate;
	private String district;
	private String constituency;
	private Date countingDate;
	
	
	@OneToOne(mappedBy = "Election",orphanRemoval = true)
	@JsonIgnore
	private Candidatebean schdlelections;

}
