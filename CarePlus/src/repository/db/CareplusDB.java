package repository.db;

import java.io.FileNotFoundException;
import java.io.IOException;
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

	private FileStoring fileStoring = FileStoring.getInstance();

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
			fileStoring.writeDoctors(doctors);
			System.out.println("Doctor is added in the File");
		} catch (Exception e) {
			System.out.println("oops Doctor is not added in the File");
		}
	}

	public boolean addReceptionist(Receptionist receptionist) {
		try {
			receptionists.add(receptionist);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void addPatient(Patient patient) {
		patients.add(patient);
		try {
			fileStoring.writePatients(patients);
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
		for (Doctor doc : doctorss) {
			if (doc.getId().equals(docId)) {
				doc.setAvailabileStart(starttime);
				doc.setAvailabileStart(startEnd);
				break;
			}
		}
		try {
			fileStoring.writeDoctors(doctorss);
			System.out.println("Doctor is added in the File");
		} catch (Exception e) {
			System.out.println("oops Doctor is not added in the File");
		}

	}

	public List<Doctor> getAllDoctors() {
		List<Doctor> docs = new ArrayList<>();
		try {
			docs = fileStoring.getAllDoctors();
		} catch (Exception e) {
			System.out.println("Error in fetching Doctors from File Handling");
			e.printStackTrace();
		}

		return docs;
	}

	public List<Patient> getAllPatients() {
		List<Patient> pats = new ArrayList<>();
		try {
			pats = fileStoring.getAllPatients();
		} catch (Exception e) {
			System.out.println("Error in fetching Doctors from File Handling");
			e.printStackTrace();
		}

		return pats;
	}

	public void removeReceptionistById(String recId) {
		int i = 0;
		for (Receptionist rec : receptionists) {
			if (rec.getId().equals(recId)) {
				receptionists.remove(i);
				break;
			}
			i++;
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

	public boolean validateReceptionistLogin(String username, String password) {
		for (Receptionist rec : receptionists) {
			if (rec.getUsername().equals(username) && rec.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public List<Appointment> getAllAppointments() {
		List<Appointment> appoints = new ArrayList<>();
		try {
			appoints = fileStoring.getAllAppointments();
		} catch (Exception e) {
			System.out.println("Error in fetching Appointments from File Handling");
			e.printStackTrace();
		}

		return appoints;
	}

	public List<Receptionist> getAllReceptionists() {
		return receptionists;
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

	public List<String> getDoctorsWithAvailabletime(String patientId) {

		List<String> doctorsWithTime = new ArrayList<>();

		Patient currentPatient = null;
		
		List<Patient> pats = getAllPatients();

		for (Patient patient : pats) {

			if (patient.getId().equals(patientId))
				currentPatient = patient;

		}

		int date = (int) currentPatient.getAdmitDate();

		List<Doctor> docs = getAllDoctors();

		for (Doctor doctor : docs) {

			int start = (int) (doctor.getAvailabileStart());
			int end = (int) (doctor.getAvailabileEnd());

			for (int i = start; i < end; i++) {

				StringBuilder sb = new StringBuilder(i + "" + doctor.getId() + date);

				if (appointmentMapping.containsKey(sb.toString()))
					continue;
				else
					doctorsWithTime.add(doctor.getId() + " " + doctor.getName() + " " + i);

			}
		}

		return doctorsWithTime;
	}

	public boolean isAvailabletimeForDoctor(String docId, byte time) {

		List<Doctor> docs = getAllDoctors();

		for (Doctor doc : docs) {
			if (doc.getId().equals(docId) && time >= doc.getAvailabileStart() && time < doc.getAvailabileEnd())
				return true;
		}
		return false;
	}

	public boolean isAlreadyfixed(Appointment app) {
		StringBuilder sb = new StringBuilder(app.getTime() + "" + app.getDoctorId() + "" + app.getDate());
		return appointmentMapping.containsKey(sb.toString());
	}

	public void addAppointment(Appointment app) {

		appointments.add(app);
		StringBuilder sb = new StringBuilder(app.getTime() + "" + app.getDoctorId() + "" + app.getDate());
		appointmentMapping.put(sb.toString(), app);
		try {
			fileStoring.writeAppointments(appointments);
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
