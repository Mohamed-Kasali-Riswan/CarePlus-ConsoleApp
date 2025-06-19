package features.receptionist;

import java.util.List;

import repository.dto.Appointment;

interface IReceptionistView {

	void proceedFeatures();

	void showAllAppointments(List<Appointment> appointments);

	void noAppointments();

}
