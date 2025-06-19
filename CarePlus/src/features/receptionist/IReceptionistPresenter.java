package features.receptionist;

import java.util.List;

import repository.dto.Appointment;

interface IReceptionistPresenter {

	// Methods in Model

	void init();

	void viewAllAppointments();

	// Methods in View

	void proceedFeatures();

	void showAllAppointments(List<Appointment> appointments);

	void noAppointments();

}
