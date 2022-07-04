package com.apx.ejemploAPX.services;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import com.apx.ejemploAPX.model.Request;
import com.apx.ejemploAPX.model.Response;
import com.apx.ejemploAPX.model.Usuario;
import com.apx.ejemploAPX.util.DateUtil;

public class ResponsesServiceImpl implements IResponsesService {

	private Response response;

	private RestTemplate restTemplate;

	private String url;

	public ResponsesServiceImpl(Response response, RestTemplate restTemplate, @Value("${payload}") String url) {
		super();
		this.response = response;
		this.restTemplate = restTemplate;
		this.url = url;
	}

	@Override
	public Response registrar()  {
		try {
			response.setOperationDate(DateUtil.getDateTimeFormat());
			response.setData(this.getUsuarios());
		}
		catch(Exception  e) {
			e.getMessage(); 
		}

		return response;
	}

	@Override
	public List<Usuario> getUsuarios()  {

		List<Usuario> lstUsuarios=null;
		try {
			ResponseEntity<Request> request = restTemplate.getForEntity(url, Request.class);
			lstUsuarios =  request.getBody().getData();

		}
		catch( HttpClientErrorException e) {
			 throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Excepción lanzada cuando se recibe un HTTP 4xx.: "); 

		}catch( HttpServerErrorException e) {
			 throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Error en el servidor del endpoint: "+url); 

		}catch(Exception e) {
			e.getMessage();
		}

        return lstUsuarios;
    }

	
	public void setResponse(Response response) {
		this.response = response;
	}

	
	
}
