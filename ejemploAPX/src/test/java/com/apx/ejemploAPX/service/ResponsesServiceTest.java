package com.apx.ejemploAPX.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.apx.ejemploAPX.model.Request;
import com.apx.ejemploAPX.model.Response;
import com.apx.ejemploAPX.model.Usuario;
import com.apx.ejemploAPX.services.ResponsesServiceImpl;


public class ResponsesServiceTest {


	ResponsesServiceImpl responseServiceImpl;
	
	RestTemplate restTemplate;
	
	final String URL="https://reqres.in/api/users";
	
	
	@BeforeEach
	public void setup() {
		
		restTemplate = mock(RestTemplate.class);
		responseServiceImpl = new ResponsesServiceImpl(new Response(),restTemplate,URL);
		
	}
	
	@Test
	void getUsuariosTest()   {

		String expectedLastName="huaman";
		List<Usuario> lstUsuario= new ArrayList<>();
		Usuario usuario= new Usuario(1L, expectedLastName,"george.bluth@reqres.in","daniel","avatar");
		
		lstUsuario.add(usuario);
		Request request2= new  Request(1,6,12,2,lstUsuario,null);
		ResponseEntity<Request> request=  ResponseEntity.ok(request2);
		when(restTemplate.getForEntity(URL, Request.class)).thenReturn(request);
		
		List<Usuario> result= responseServiceImpl.getUsuarios();
		
		//asserts
		
		assertThat(result).isNotEmpty();
		assertThat(result).hasSize(1);
		assertThat(result.get(0).getId()).isEqualTo(1);
		assertThat(result.get(0).getEmail()).isEqualTo("george.bluth@reqres.in");
		assertThat(result.get(0).getLast_name()).isEqualTo(expectedLastName);
		
	}
	
	@Test
	void getUsuariosTestThrowsHttpClientErrorExceptionError()  {
		
		when(restTemplate.getForEntity(URL, Request.class)).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

		
		//assert
		assertThrows(HttpClientErrorException.class, ()->responseServiceImpl.getUsuarios());

	}
	
	@Test
	void getUsuariosTestThrowsHttpServerErrorExceptionError()  {
		 
		
		when(restTemplate.getForEntity(URL, Request.class)).thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

	    //assert
		assertThrows(HttpServerErrorException.class, ()->responseServiceImpl.getUsuarios());
	}
	
	@Test
	void registrarTest() {
		
		String expectedLastName="huaman";
		List<Usuario> lstUsuario= new ArrayList<>();
		Usuario usuario= new Usuario(1L, expectedLastName,"george.bluth@reqres.in","daniel","avatar");
		
		lstUsuario.add(usuario);
		Request request2= new  Request(1,6,12,2,lstUsuario,null);
		ResponseEntity<Request> request=  ResponseEntity.ok(request2);
		when(restTemplate.getForEntity(URL, Request.class)).thenReturn(request);
		
		
		Response response=responseServiceImpl.registrar();
		
		//assert
		assertThat(response).isNotNull();
		assertThat(response.getOperationDate()).isNotNull();
		assertThat(response.getData()).isNotNull();
	}


	
	
	
}
