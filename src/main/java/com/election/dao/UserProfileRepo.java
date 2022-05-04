package com.election.dao;
import org.springframework.data.repository.CrudRepository;

import com.election.models.Profilebean;

public interface UserProfileRepo extends CrudRepository<Profilebean, String>{

}