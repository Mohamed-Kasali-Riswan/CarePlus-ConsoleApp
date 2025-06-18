package repository.dto;

import java.io.Serializable;
import java.util.UUID;

public class Patient implements Serializable {
	
	
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = "PAT"+UUID.randomUUID().toString().substring(15,20);
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
	
	private String id;
	private String name;
	private String mobile;
	private byte age;
	private String gender;
	private byte weight;
	private String problem;
	private String address;
	private byte admitDate;
	public byte getAdmitDate() {
		return admitDate;
	}
	public void setAdmitDate(byte admitDate) {
		this.admitDate = admitDate;
	}
	public byte getAdmitMonth() {
		return admitMonth;
	}
	public void setAdmitMonth(byte admitMonth) {
		this.admitMonth = admitMonth;
	}

	private byte admitMonth;
	
	public String toString() {
		return id+"-"+name+"-"+mobile;
	}
	
}
