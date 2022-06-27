package com.apx.ejemploAPX.service;

import static org.junit.Assert.assertNotNull;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.apx.ejemploAPX.model.Request;
import com.apx.ejemploAPX.model.Responses;
import com.apx.ejemploAPX.model.Usuario;
import com.apx.ejemploAPX.services.ResponsesServiceImpl;
import com.apx.ejemploAPX.util.DateUtil;

@RunWith(MockitoJUnitRunner.class)
public class ResponsesServiceTest {

	@InjectMocks
	ResponsesServiceImpl responseServiceimpl;
	
	@Mock
	RestTemplate restTemplate;
	List<Usuario> lstUsuarios;
	
	@Mock
	DateUtil dateUtil;
	String fechaActual;
	
	ResponseEntity<Request> request;
	
	
	@Before
	
	public void setup() {
//		MockitoAnnotations.initMocks(this);
		
		lstUsuarios= new ArrayList<>();
		
		Usuario us = new Usuario(1L,"huaman","daniel3@gmail.com");
		lstUsuarios.add(us);
		fechaActual="2022-06-26 18:00:00";
		
		
	}
	
	@Test
	public void registrar() throws UnknownHostException {
		responseServiceimpl= new ResponsesServiceImpl();

//		Mockito.when(restTemplate).thenReturn(lstUsuarios);
		Mockito.when(dateUtil.getDateTimeFormat()).thenReturn(fechaActual);
		
		Responses responses= responseServiceimpl.registrar();
		System.out.println("responses - "+responses.toString());
		assertNotNull(responses);
	}
	
	
	
	
	
	
}
