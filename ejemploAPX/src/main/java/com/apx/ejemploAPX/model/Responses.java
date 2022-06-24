package com.apx.ejemploAPX.model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;



public class Responses   {

	private String operationDate;

	private List<Usuario> data;

	public Responses() {
		super();
		
	}

	public Responses(String operationDate, List<Usuario> data) {
		super();
		this.operationDate = operationDate;
		this.data = data;
	}



	public String getOperationDate() {
		return operationDate;
	}



	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}



	public List<Usuario> getData() {
		return data;
	}

	public void setData(List<Usuario> data) {
		this.data = data;
	}
	
	
	
}
