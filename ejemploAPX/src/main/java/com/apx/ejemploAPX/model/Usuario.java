package com.apx.ejemploAPX.model;


public class Usuario  {

	
	private Long id;
	private String last_name;
	private String email;

	public Usuario() {}


	public Usuario(Long id, String last_name, String email) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
