package com.apx.ejemploAPX.controller;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.apx.ejemploAPX.services.IResponsesService;


@WebMvcTest(ResponseController.class)
@SpringBootTest
public class ResponseControllerTest {

	@Autowired
	private MockMvc mockMVC;

	@MockBean
	private IResponsesService servicio;
	

	
	
	
	
	
	
}
