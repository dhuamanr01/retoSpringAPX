package com.apx.ejemploAPX.services;


import java.net.UnknownHostException;
import java.util.List;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.apx.ejemploAPX.model.Response;
import com.apx.ejemploAPX.model.Usuario;



public interface IResponsesService {

	Response registrar() ;
	public List<Usuario> getUsuarios() ;
}
