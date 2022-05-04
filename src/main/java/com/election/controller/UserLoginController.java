package com.election.controller;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.election.dao.CredentialsRepo;
import com.election.dao.UserProfileRepo;
import com.election.models.Credentialsbean;
import com.election.models.Profilebean;
import com.election.models.Status;

@RestController
public class UserLoginController {

@Autowired
CredentialsRepo cred;
@Autowired
UserProfileRepo prof;
@PostMapping(value="/users/register",consumes = "application/json")

public Status registerUser(@RequestBody Profilebean newUser) {

     Credentialsbean c = new Credentialsbean();
	 c.setLoginstatus(1);
	 c.setPassword(newUser.getPassword());
	 c.setUsertype("C");
	 Random rand = new Random();
	 int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
	 c.setUserID(newUser.getFirstName().substring(0,2) + Integer.toString(resRandom));    
   
	newUser.setCred(c);
	prof.save(newUser);
    cred.save(c);
    
    System.out.println(c.getUserID());
    return Status.Registered_successfully;
}


@GetMapping("/users/profilelist")
public List<Profilebean> profiles(){
	return (List<Profilebean>) prof.findAll();
}
@GetMapping("users/credentialslist")
public List<Credentialsbean> Cred(){
	return cred.findAll();
}

@PostMapping(value="/users/login",consumes = "application/json")
public Status loginUser(@RequestBody Credentialsbean user) {
    List<Credentialsbean> users = cred.findAll();
    for (Credentialsbean other : users) {
        if (other.equals(user)&& other.getLoginstatus()==0) {
            user.setLoginstatus(1);
            user.setUsertype("C");
            if(user.getUserID().equals("admin123")) {
            	user.setUsertype("A");
            }
            else {
            	user.setUsertype("C");
            }
            cred.save(user);
            return Status.Login_Successfully;
        }
    }
    return Status.User_not_found;
}
@PostMapping("/users/logout")
public Status logUserOut(@RequestBody Credentialsbean user) {
    List<Credentialsbean> users = cred.findAll();
    for (Credentialsbean other : users) {
        if (other.equals(user)&&other.getLoginstatus()==1) {
            user.setLoginstatus(0);
            if(user.getUserID().equals("admin123")) {
            	user.setUsertype("A");
            }
            else {
            	user.setUsertype("C");
            }
            cred.save(user);
            return Status.Logout_Successfully;
        }
    }
    return Status.Failure;
}

    @PutMapping(path="/users/changepassword",consumes= {"application/json"})
	public Status ChangePassword(@RequestBody Credentialsbean user) {
          cred.save(user);
	      return Status.Updated_successfully;
	       
	       
	}
    
}