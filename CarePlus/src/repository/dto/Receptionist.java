package repository.dto;

import java.util.UUID;

public class Receptionist {
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = "RECEP"+UUID.randomUUID().toString().substring(15, 20);
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String name;
	private String mobile;
	private String address;
	private String email;
	private String username;
	private String password;
	
	public String toString() {
		return id+" "+name+" "+mobile+" "+username;
	}
	
}
