package com.apx.ejemploAPX.services;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.apx.ejemploAPX.model.Request;
import com.apx.ejemploAPX.model.Responses;
import com.apx.ejemploAPX.model.Usuario;
import com.apx.ejemploAPX.util.DateUtil;



public class ResponsesServiceImpl implements IResponsesService {

	
	
	@Autowired
	private Responses responses;
	
	@Autowired
	private Request request;


	@Value("${payload}") 
	 private String url;

	
	@Override
	public Responses registrar() {
		LocalDateTime ldt = LocalDateTime.now();
		responses.setOperationDate(ldt);
		responses.setData(getUsuarios());
		
		return responses;
	}


	
	public List<Usuario> getUsuarios() {
		 RestTemplate restTemplate= new RestTemplate();

		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
//		  headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
////		  headers.set("Content-type", "application/json;charset=UTF-8");
//		  headers.set("User-Agent", "MyAppName/1.0.0");
//		 HttpEntity<String> entity = new HttpEntity<>(headers);
		 
		 ResponseEntity<Request> response = restTemplate.exchange(url, HttpMethod.GET, entity, Request.class);
         List<Usuario> lstUsuarios =  response.getBody().getData();
	
//         List<Usuario> result = lstUsuarios.stream()
//	        .map(u -> new Usuario(u.getId(), u.getLastName(), u.getEmail()))
//	        .collect(Collectors.toList());
	
        return lstUsuarios;
    }

	
	public void setResponses(Responses responses) {
		this.responses = responses;
	}
//
//	
//
	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
