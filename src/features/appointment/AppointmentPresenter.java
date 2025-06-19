package features.appointment;

import java.util.List;

import repository.dto.Appointment;
import repository.dto.Patient;

class AppointmentPresenter implements IAppointmentPresenter {

	private final IAppointmentView view;

	private final IAppointmentModel model;

	public AppointmentPresenter(AppointmentView appointmentView) {
		view = appointmentView;
		model = new AppointmentModel(this);
	}

	public void init() {
		model.init();
	}

	public void searchPatientByName(String name) {
		model.searchPatientByName(name);
	}

	public void viewAvailabletimeAndDoctors(String date) {
		model.viewAvailabletimeAndDoctors(date);
	}

	public void viewAllAppointments() {
		model.viewAllAppointments();
	}

	public boolean isAlreadyfixed(Appointment app) {
		return model.isAlreadyfixed(app);
	}

	public void addAppointment(Appointment app) {
		model.addAppointment(app);
	}

	public boolean isAvailabletimeForDoctor(String docId, byte time) {
		return model.isAvailabletimeForDoctor(docId, time);
	}

	public void proceedFeatures() {
		view.proceedFeatures();
	}

	public void noPatientWithName(String patientName) {
		view.noPatientWithName(patientName);
	}

	public void showAllPatients(List<Patient> patients) {
		view.showAllPatients(patients);
	}

	public void showAllAppointments(List<String> availabledoctorsAndTime) {
		view.showAllAppointments(availabledoctorsAndTime);
	}

	public void noAvailableAppointments() {
		view.noAvailableAppointments();
	}

	public void appointmentAddedSuccess() {
		view.appointmentAddedSuccess();
	}

	public void showAllBookedAppointments(List<Appointment> allappointments) {
		view.showAllBookedAppointments(allappointments);
	}

}
