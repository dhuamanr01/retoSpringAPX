package com.apx.ejemploAPX.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Usuario  {

	
	private Long id;
	private String last_name;
	private String email;
//	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String first_name;
//	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String avatar;

	public Usuario() {}


	public Usuario(Long id, String last_name, String email) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.email = email;
	}

	
	public Usuario(Long id, String last_name, String email, String first_name, String avatar) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.email = email;
		this.first_name = first_name;
		this.avatar = avatar;
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


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	
}
