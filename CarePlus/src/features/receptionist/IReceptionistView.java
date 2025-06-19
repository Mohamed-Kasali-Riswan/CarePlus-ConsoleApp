package features.receptionist;

import java.util.List;

import repository.dto.Appointment;

public interface IReceptionistView {

	void proceedFeatures();

	void showAllAppointments(List<Appointment> appointments);

	void noAppointments();

}
