package com.apx.ejemploAPX.model;






public class Usuario  {

	
	private Long id;

	private String lastName;
	
	private String email;

	
	public Usuario() {}

	public Usuario(Long id, String lastName, String email) {
		super();
		this.id = id;
		this.email = email;
		this.lastName = lastName;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	
	
	
}
