package repository.db;

import java.io.FileNotFoundException;
import util.Util;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import repository.dto.Admin;
import repository.dto.Appointment;
import repository.dto.Doctor;
import repository.dto.Patient;
import repository.dto.Receptionist;

public class CareplusDB {

	private static CareplusDB dbInstance;

	private Admin admin = Admin.getInstance();

	//private FileStoring fileStoring = FileStoring.getInstance();
	
	private CareplusMySqlDb sqldb = CareplusMySqlDb.getInstance();

	List<Receptionist> receptionists = new ArrayList<>();

	List<Doctor> doctors = new ArrayList<>();

	List<Patient> patients = new ArrayList<>();

	List<Appointment> appointments = new ArrayList<>();

	Map<String, Appointment> appointmentMapping = new HashMap<>();

	public CareplusDB() {

	}

	public static CareplusDB getInstance() {

		if (dbInstance == null)
			dbInstance = new CareplusDB();

		return dbInstance;

	}

	public boolean validateAdminLogin(String username, String password) {
		return admin.getEmail().equals(username) && admin.getPassword().equals(password);
	}

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
		try {
			sqldb.insertDoctor(doctor);
			System.out.println("Doctor is added in the File");
		} catch (Exception e) {
			System.out.println("oops Doctor is not added in the File");
		}
	}

	public boolean addReceptionist(Receptionist receptionist) {
		try {
			receptionists.add(receptionist);
			sqldb.insertReceptionist(receptionist);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void addPatient(Patient patient) {
		patients.add(patient);
		try {
			sqldb.insertPatient(patient);
			System.out.println("Patient is added in the File");
		} catch (Exception e) {
			System.out.println("oops Patient is not added in the File");
		}
	}

	public boolean isDoctorPresentbyId(String docId) {

		List<Doctor> doctorss = getAllDoctors();

		for (Doctor doc : doctorss) {
			if (doc.getId().equals(docId))
				return true;
		}
		return false;
	}

	public void changetimeforDoctor(String docId, byte starttime, byte startEnd) {
		List<Doctor> doctorss = getAllDoctors();
		Doctor updatedoctor = null;
		for (Doctor doc : doctorss) {
			if (doc.getId().equals(docId)) {
				doc.setAvailabileStart(starttime);
				doc.setAvailabileEnd(startEnd);
				updatedoctor = doc;
				break;
			}
		}
		
		if(updatedoctor != null) {
			try {
				sqldb.updateTimeForDoctor(updatedoctor);
				System.out.println("Doctor is added in the File");
			} catch (Exception e) {
				System.out.println("oops Doctor is not added in the File");
			}
		}

	}

	public List<Doctor> getAllDoctors() {
		List<Doctor> docs = new ArrayList<>();
		try {
			docs = sqldb.getAllDoctors();
		} catch (Exception e) {
			System.out.println("Error in fetching Doctors from File Handling");
			e.printStackTrace();
		}

		return docs;
	}

	public List<Patient> getAllPatients() {
		List<Patient> pats = new ArrayList<>();
		try {
			pats = sqldb.getAllPatients();
		} catch (Exception e) {
			System.out.println("Error in fetching Doctors from File Handling");
			e.printStackTrace();
		}

		return pats;
	}

	public void removeReceptionistById(String recId) {
		try {
			sqldb.deleteReceptionist(recId);
		} catch (SQLException e) {
			System.out.println("Error while Deleting Receptionist in db");
			e.printStackTrace();
		}
	}

	public boolean containsReceptionistById(String recId) {
		for (Receptionist rec : receptionists) {
			if (rec.getId().equals(recId)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateReceptionistLogin(String username, String password) throws SQLException {
		for (Receptionist rec : sqldb.getAllReceptionist()) {
			if (rec.getUsername().equals(username) && rec.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public List<Appointment> getAllAppointments() {
		List<Appointment> appoints = new ArrayList<>();
		try {
			appoints = sqldb.getAllAppointments();
		} catch (Exception e) {
			System.out.println("Error in fetching Appointments from File Handling");
			e.printStackTrace();
		}

		return appoints;
	}

	public List<Receptionist> getAllReceptionists() {
		List<Receptionist> receptionistss = new ArrayList<>();
		try {
			receptionistss = sqldb.getAllReceptionist();
		} catch (Exception e) {
			System.out.println("Error in fetching Appointments from File Handling");
			e.printStackTrace();
		}

		return receptionistss;
	}

	public List<Patient> getPatientByName(String patientName) {
		List<Patient> filePatients = getAllPatients();
		List<Patient> returnPatients = new ArrayList<>();
		for (Patient patient : filePatients) {
			if (patient.getName().equals(patientName))
				returnPatients.add(patient);
		}
		return returnPatients;
	}
	
	
	public List<String> getDoctorsWithAvailabletime(String Date){
		
		List<String> doctorsWithTime = new ArrayList<>();
		for (Doctor doctor : getAllDoctors()) {
			int start = (int) (doctor.getAvailabileStart());
			int end = (int) (doctor.getAvailabileEnd());
			for (int i = start; i < end; i++) {
				if(isAlreadyBooked(doctor.getId(),i,Date)) {
					continue;
				}
				else {
					StringBuilder sb = new StringBuilder();
					sb.append("Doctor Id: "+doctor.getId()+" Doctor Name: "+doctor.getName()+" Doctor Specialization: "+doctor.getSpecialization()+" Available time: "+i+" Date: "+Date);
					doctorsWithTime.add(sb.toString());
				}
			}
		}
		return doctorsWithTime;
	}

	public boolean isAlreadyBooked(String id, int i, String Date) {
		
		for(Appointment appointment : getAllAppointments()) {
			
			if(appointment.getDoctorId().equals(id) && appointment.getTime()==i && appointment.getDate().equals(Date)) return true;
		}
		return false;
	}

	public boolean isAvailabletimeForDoctor(String docId, byte time) {

		List<Doctor> docs = getAllDoctors();

		for (Doctor doc : docs) {
			if (doc.getId().equals(docId) && time >= doc.getAvailabileStart() && time < doc.getAvailabileEnd())
				return true;
		}
		return false;
	}

	public void addAppointment(Appointment app) {

		try {
			sqldb.insertAppointment(app);
			System.out.println("Appointment is added in the File");
		} catch (Exception e) {
			System.out.println("oops Appointment is not added in the File");
		}
	}

	public boolean isPatientWiththisName(String name) {
		List<Patient> allPatients = getAllPatients();
		for (Patient patient : allPatients) {
			if (patient.getName().equals(name))
				return true;
		}
		return false;
	}

}
