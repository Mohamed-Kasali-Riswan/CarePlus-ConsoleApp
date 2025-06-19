package features.receptionist;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Appointment;

class ReceptionistModel implements IReceptionistModel {

	private final IReceptionistPresenter presenter;

	ReceptionistModel(ReceptionistPresenter receptionistPresenter) {
		this.presenter = receptionistPresenter;
	}

	public void init() {
		presenter.proceedFeatures();
	}

	public void viewAllAppointments() {
		List<Appointment> appointments = CareplusDB.getInstance().getAllAppointments();

		if (appointments.size() == 0)
			presenter.noAppointments();
		else
			presenter.showAllAppointments(appointments);

	}

}
