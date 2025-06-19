package features.appointment;

import java.util.List;

import repository.dto.Appointment;
import repository.dto.Patient;

public interface IAppointmentPresenter {
	
	// Methods in Model

	void init();

	void searchPatientByName(String namez);

	void viewAvailabletimeAndDoctors(String date);

	void viewAllAppointments();

	boolean isAlreadyfixed(Appointment app);

	void addAppointment(Appointment app);

	boolean isAvailabletimeForDoctor(String docId, byte time);
	
	// Methods in View

	void proceedFeatures();

	void noPatientWithName(String patientName);

	void showAllPatients(List<Patient> patients);

	void appointmentAddedSuccess();

	void showAllAppointments(List<String> availabledoctorsAndTime);

	void noAvailableAppointments();

	void showAllBookedAppointments(List<Appointment> allappointments);

}
