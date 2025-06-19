package features.appointment;

import repository.dto.Appointment;

public interface IAppointmentModel {

	void init();

	void searchPatientByName(String name);

	void viewAvailabletimeAndDoctors(String date);

	void viewAllAppointments();

	boolean isAlreadyfixed(Appointment app);

	void addAppointment(Appointment app);

	boolean isAvailabletimeForDoctor(String docId, byte time);

}
