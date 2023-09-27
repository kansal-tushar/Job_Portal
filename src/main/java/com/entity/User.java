package com.entity;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String qualfication;
	private String role;
	
	public User(String name, String email, String password, String qualfication, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.qualfication = qualfication;
		this.role = role;
	}
	public User() {
		super();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualfication() {
		return qualfication;
	}
	public void setQualfication(String qualfication) {
		this.qualfication = qualfication;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
