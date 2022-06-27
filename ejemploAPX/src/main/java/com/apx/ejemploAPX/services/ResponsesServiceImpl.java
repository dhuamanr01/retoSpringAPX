package com.apx.ejemploAPX.services;

import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.apx.ejemploAPX.model.Request;
import com.apx.ejemploAPX.model.Responses;
import com.apx.ejemploAPX.model.Usuario;
import com.apx.ejemploAPX.util.DateUtil;

public class ResponsesServiceImpl implements IResponsesService {

//	@Autowired
	private Responses responses;
	
	@Autowired
	private  RestTemplate restTemplate;
	
	@Value("${payload}") 
	 private String url;

	@Override
	public Responses registrar()  {
		try {
			responses.setOperationDate(DateUtil.getDateTimeFormat());
			responses.setData(this.getUsuarios());
		}catch(UnknownHostException  e) {
			e.printStackTrace();
		}
		return responses;
	}

	@Override
	public List<Usuario> getUsuarios() throws  UnknownHostException {

		List<Usuario> lstUsuarios=null;
		try {
			ResponseEntity<Request> request = restTemplate.getForEntity(url, Request.class);
			lstUsuarios =  request.getBody().getData();
			lstUsuarios = lstUsuarios.stream()
		        .map(u -> new Usuario(u.getId(), u.getLast_name(), u.getEmail()))
		        .collect(Collectors.toList());
		}catch(Exception e) {
			throw new UnknownHostException("No se encuentra la dirección IP del host: "+url); 
		}

        return lstUsuarios;
    }

	
	public void setResponses(Responses responses) {
		this.responses = responses;
	}

	
	
}
