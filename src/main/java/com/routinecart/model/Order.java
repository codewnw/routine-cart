package com.routinecart.model;

public class Order {
	private Long id;
	private String status;

	public Long getId() {
		return id;
	}
	
	

	public Order(Long id, String status) {
		super();
		this.id = id;
		this.status = status;
	}



	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
