package features.appointment;

import java.util.List;

import repository.dto.Appointment;
import repository.dto.Patient;

interface IAppointmentView {

	void proceedFeatures();

	void noPatientWithName(String patientName);

	void showAllPatients(List<Patient> patients);

	void showAllAppointments(List<String> availabledoctorsAndTime);

	void noAvailableAppointments();

	void appointmentAddedSuccess();

	void showAllBookedAppointments(List<Appointment> allappointments);

}
