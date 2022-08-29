package com.snort.intelli.app.Exception;

public class student {

	private int id;
	private String name;
	private String phone;
	
	
	public student() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
