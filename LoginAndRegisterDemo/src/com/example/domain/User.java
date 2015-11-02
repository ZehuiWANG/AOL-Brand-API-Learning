package com.example.domain;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	
	private String name = null;
	private String firstname=null;
	private String lastname=null;
	private String email=null;
	private String password=null;
	private String access_token;
	private String test=null;
	
	public String getTest(){
		return test;
	}
	public void setTest(String string){
		this.test = test;
	}
	
	
	public String getAccessToken() {
		return access_token;
	}
	public void setAccessToken(String access_token) {
		this.access_token = access_token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String username) {
		this.name = username;
	}

}
