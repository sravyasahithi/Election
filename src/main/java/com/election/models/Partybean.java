package com.election.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="Party_details")
public class Partybean {
	@Id

		private String partyID;
		private String name;
		private String leader;
		private String symbol;
		
		@OneToOne(mappedBy = "Party",orphanRemoval = true)
		@JsonIgnore
		private Candidatebean schdlparty;


}
