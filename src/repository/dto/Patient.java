package repository.dto;

import java.io.Serializable;
import util.Util;
import java.sql.Date;
import java.util.UUID;

public class Patient implements Serializable {
	
	
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = "PAT"+UUID.randomUUID().toString().substring(15,20);
	}
	public void setId(String s) {
		this.id = s;
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
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public byte getWeight() {
		return weight;
	}
	public void setWeight(byte weight) {
		this.weight = weight;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate() {
		this.admitDate = new Util().utcMillisToDate(new Util().nowToUtcMillis());
	}
	
	public void setAdmitDate(String s) {
		this.admitDate = s;
	}
	
	private String id;
	private String name;
	private String mobile;
	private byte age;
	private String gender;
	private byte weight;
	private String problem;
	private String address;
	private String admitDate;
	
	
	public String toString() {
		return "Patient Id: "+id+" Name: "+name+" Age: "+age+" Mob: "+mobile+" Problem: "+problem+" Admitted on "+admitDate;
	}
	
}
