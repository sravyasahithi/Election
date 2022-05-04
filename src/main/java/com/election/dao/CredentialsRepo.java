package com.election.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.election.models.Credentialsbean;

public interface CredentialsRepo extends JpaRepository<Credentialsbean, String> {

}