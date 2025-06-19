package features.appointment;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Appointment;
import repository.dto.Patient;

class AppointmentModel implements IAppointmentModel {

	private final IAppointmentPresenter presenter;

	public AppointmentModel(AppointmentPresenter appointmentPresenter) {
		this.presenter = appointmentPresenter;
	}

	public void init() {

		presenter.proceedFeatures();

	}

	public void searchPatientByName(String patientName) {
		List<Patient> patients = CareplusDB.getInstance().getPatientByName(patientName);

		if (patients.size() == 0)
			presenter.noPatientWithName(patientName);
		else
			presenter.showAllPatients(patients);

	}

	public void viewAvailabletimeAndDoctors(String Date) {
		List<String> availabledoctorsAndTime = CareplusDB.getInstance().getDoctorsWithAvailabletime(Date);

		if (availabledoctorsAndTime.size() == 0)
			presenter.noAvailableAppointments();
		else
			presenter.showAllAppointments(availabledoctorsAndTime);

	}

	public boolean isAvailabletimeForDoctor(String docId, byte time) {
		return CareplusDB.getInstance().isAvailabletimeForDoctor(docId, time);
	}

	public void addAppointment(Appointment app) {
		CareplusDB.getInstance().addAppointment(app);
		presenter.appointmentAddedSuccess();
	}

	public boolean isAlreadyfixed(Appointment app) {
//		return CareplusDB.getInstance().isAlreadyfixed(app);
		return CareplusDB.getInstance().isAlreadyBooked(app.getDoctorId(), app.getTime(), app.getDate());
	}

	public void viewAllAppointments() {
		List<Appointment> allappointments = CareplusDB.getInstance().getAllAppointments();

		if (allappointments.size() == 0)
			presenter.noAvailableAppointments();
		else
			presenter.showAllBookedAppointments(allappointments);
	}

	public boolean isPatientWiththisName(String name) {
		return CareplusDB.getInstance().isPatientWiththisName(name);
	}

}
