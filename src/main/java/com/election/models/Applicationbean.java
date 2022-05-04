package com.election.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="Application_details")
public class Applicationbean {
	@Id
	private String userID;
	private String constituency;
	private int passedStatus;
	private int approvedStatus;
	private String voterID;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Credentialsbean cred;
}
