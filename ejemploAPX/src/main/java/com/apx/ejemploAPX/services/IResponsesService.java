package com.apx.ejemploAPX.services;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import com.apx.ejemploAPX.model.Responses;
import com.apx.ejemploAPX.model.Usuario;



public interface IResponsesService {

	Responses registrar() ;
	public List<Usuario> getUsuarios() throws  UnknownHostException;
}
