package repository.db;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import repository.dto.Appointment;
import repository.dto.Doctor;
import repository.dto.Patient;
public class FileStoring {
	private static FileStoring fileObject;
	private FileStoring() {
	}
	
	public static FileStoring getInstance() {
		if(fileObject==null) fileObject= new FileStoring();
		return fileObject;
	}
	
	protected void writeDoctors(List<Doctor> doctors) throws FileNotFoundException, IOException {
		
		//File file = new File("C:\\Users\\asus\\Desktop\\ZohoGS\\Doctors.txt");
		File file = new File("C:\\Users\\asus\\Desktop\\Advanced Java\\JDBC\\CarePlus\\src\\datebase\\Doctors.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		for(Doctor doctor:doctors) {
			oos.writeObject(doctor);
		}
		
	}
	protected void writePatients(List<Patient> doctors) throws FileNotFoundException, IOException {
		
		//File file = new File("C:\\Users\\asus\\Desktop\\ZohoGS\\Patients.txt");
		File file = new File("C:\\Users\\asus\\Desktop\\Advanced Java\\JDBC\\CarePlus\\src\\datebase\\Patients.txt");

		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		for(Patient doctor:doctors) {
			oos.writeObject(doctor);
		}
		
	}
	protected void writeAppointments(List<Appointment> doctors) throws FileNotFoundException, IOException {
		
		//File file = new File("C:\\Users\\asus\\Desktop\\ZohoGS\\Appointments.txt");
		File file = new File("C:\\Users\\asus\\Desktop\\Advanced Java\\JDBC\\CarePlus\\src\\datebase\\Appointments.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		for(Appointment doctor:doctors) {
			oos.writeObject(doctor);
		}
		
	}
	
	protected List<Doctor> getAllDoctors() throws FileNotFoundException, IOException{
		
		List<Doctor> doctors = new ArrayList<>();
		
//		File file = new File("C:\\Users\\asus\\Desktop\\ZohoGS\\Doctors.txt");
		File file = new File("C:\\Users\\asus\\Desktop\\Advanced Java\\JDBC\\CarePlus\\src\\datebase\\Doctors.txt");
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			
			while(true) {
				doctors.add((Doctor)(ois.readObject()));
			}
			
		}catch(Exception e) {
			return doctors;
		}
		
	}
	protected List<Patient> getAllPatients() throws FileNotFoundException, IOException{
		
		List<Patient> patients = new ArrayList<>();
		
//		File file = new File("C:\\Users\\asus\\Desktop\\ZohoGS\\Patients.txt");
		File file = new File("C:\\Users\\asus\\Desktop\\Advanced Java\\JDBC\\CarePlus\\src\\datebase\\Patients.txt");

		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			
			while(true) {
				patients.add((Patient)(ois.readObject()));
			}
			
		}catch(Exception e) {
			return patients;
		}
		
	}
	protected List<Appointment> getAllAppointments() throws FileNotFoundException, IOException{
		
		List<Appointment> appointments = new ArrayList<>();
		
		//File file = new File("C:\\Users\\asus\\Desktop\\ZohoGS\\Appointments.txt");
		File file = new File("C:\\Users\\asus\\Desktop\\Advanced Java\\JDBC\\CarePlus\\src\\datebase\\Appointments.txt");

		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			
			while(true) {
				appointments.add((Appointment)(ois.readObject()));
			}
			
		}catch(Exception e) {
			return appointments;
		}
		
	}

}
