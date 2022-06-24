package com.apx.ejemploAPX.model;

import java.util.List;

public class Request {

	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<Usuario> data;
	private List<String> support;
	
	
	public Request() {
		
	}
	
	public Request(int page, int per_page, int total, int total_pages, List<Usuario> data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
		
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<Usuario> getData() {
		return data;
	}
	public void setData(List<Usuario> data) {
		this.data = data;
	}
//	public List<String> getSupport() {
//		return support;
//	}
//	public void setSupport(List<String> support) {
//		this.support = support;
//	}
	

	
	
	
}
