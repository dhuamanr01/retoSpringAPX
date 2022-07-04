package com.apx.ejemploAPX.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apx.ejemploAPX.model.Response;
import com.apx.ejemploAPX.services.IResponsesService;


@RestController
@RequestMapping("/api")
public class ResponseController {
	
	private static Logger logger = LoggerFactory.getLogger(ResponseController.class);
	
	@Autowired
	private IResponsesService service;

	  @PostMapping(path="/registrar", produces="application/json")
	  public ResponseEntity<?> registrar() {
		  logger.info("Method_Initialize");
	    ResponseEntity<?> response;
	    try {
	    	Response respuesta = this.service.registrar();
	    	response = new ResponseEntity<Response>(respuesta,HttpStatus.CREATED);
	    }
	   
	    catch (Exception ex) {
	      logger.error(ex.getMessage(), ex);
	      response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

	    }
	    finally {
	    	 logger.info("Method_Finalize");
	    }
	    return response;
	  }

	public void setService(IResponsesService service) {
		this.service = service;
	}
	   
	  
}
