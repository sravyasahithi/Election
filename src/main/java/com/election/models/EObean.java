package com.election.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Eo_details")
public class EObean {
	@Id
	private String electoralOfficerID;
	private String constituency;


}
