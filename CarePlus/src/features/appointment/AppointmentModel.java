package features.appointment;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Appointment;
import repository.dto.Patient;

public class AppointmentModel {
	
	private final AppointmentView view;
	
	public AppointmentModel(AppointmentView appointmentView) {
		this.view = appointmentView;
	}

	public void init() {
		
		view.proceedFeatures();
		
	}

	public void searchPatientByName(String patientName) {
		List<Patient> patients = CareplusDB.getInstance().getPatientByName(patientName);
		
		if(patients.size()==0) view.noPatientWithName(patientName);
		else view.showAllPatients(patients);
		
	}

	public void viewAvailabletimeAndDoctors(String patientId) {
		List<String> availabledoctorsAndTime = CareplusDB.getInstance().getDoctorsWithAvailabletime(patientId);
		
		if(availabledoctorsAndTime.size()==0) view.noAvailableAppointments();
		else view.showAllAppointments(availabledoctorsAndTime);
		
	}

	public boolean isAvailabletimeForDoctor(String docId, byte time) {
		return CareplusDB.getInstance().isAvailabletimeForDoctor(docId,time);
	}

	public void addAppointment(Appointment app) {
		CareplusDB.getInstance().addAppointment(app);
		view.appointmentAddedSuccess();
	}
	
	public boolean isAlreadyfixed(Appointment app) {
		return CareplusDB.getInstance().isAlreadyfixed(app);
	}

	public void viewAllAppointments() {
		List<Appointment> allappointments = CareplusDB.getInstance().getAllAppointments();
		
		if(allappointments.size()==0) view.noAvailableAppointments();
		else view.showAllBookedAppointments(allappointments);
	}

	public boolean isPatientWiththisName(String name) {
		return CareplusDB.getInstance().isPatientWiththisName(name);
	}

}
