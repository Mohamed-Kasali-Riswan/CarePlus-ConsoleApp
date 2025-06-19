package repository.dto;

import java.io.Serializable;
import java.util.UUID;

public class Doctor  implements Serializable {
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = "DOCTR"+UUID.randomUUID().toString().substring(15, 20);
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
	public byte getExperience() {
		return experience;
	}
	public void setExperience(byte experience) {
		this.experience = experience;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	private String name;
	private String mobile;
	private byte age;
	private String gender;
	private byte experience;
	private String address;
	private String email;
	private String specialization;
	private byte availabileStart;
	public byte getAvailabileStart() {
		return availabileStart;
	}
	public void setAvailabileStart(byte availabileStart) {
		this.availabileStart = availabileStart;
	}
	public byte getAvailabileEnd() {
		return availabileEnd;
	}
	public void setAvailabileEnd(byte availabileEnd) {
		this.availabileEnd = availabileEnd;
	}
	private byte availabileEnd;
	
	public String toString() {
		return "Doctor id: "+id+" Name: "+name+" Specialized in: "+specialization+" Available Time: "+availabileStart+" to "+availabileEnd;
	}
	
}












