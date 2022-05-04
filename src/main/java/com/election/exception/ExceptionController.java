package com.election.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(value = ElectionNotFoundException.class)
	public ResponseEntity<Object> exception(ElectionNotFoundException exception) {

	   return new ResponseEntity<Object>("Election not found", HttpStatus.NOT_FOUND);

	  }
	
	@ExceptionHandler(value = PartyNotFoundException.class)
	public ResponseEntity<Object> exception1(PartyNotFoundException exception){
		return new ResponseEntity<Object>("Party not found", HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value= NoElectionOrPartyFound.class)
	public ResponseEntity<Object> exeception2(NoElectionOrPartyFound exception){
		return new ResponseEntity<Object>("No Election or Party Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= CandidateNotFoundException.class)
	public ResponseEntity<Object> exeception3(CandidateNotFoundException exception){
		return new ResponseEntity<Object>("Candidate Not Found", HttpStatus.NOT_FOUND);
	}

}
