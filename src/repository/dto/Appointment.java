package repository.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

public class Appointment  implements Serializable {
	
	private String appointmentId;
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId( ) {
		this.appointmentId = "APONT"+UUID.randomUUID().toString().substring(15,20);
	}
	public void setAppointmentId(String s  ) {
		this.appointmentId = s;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public byte getTime() {
		return time;
	}
	public void setTime(byte time) {
		this.time = time;
	}
	private String patientId;
	private String doctorId;
	private String date;
	private byte time;
	
	public String toString() {
		return appointmentId+" "+patientId+" "+doctorId+" Date is "+date+" Time is "+time;
	}
	
}
