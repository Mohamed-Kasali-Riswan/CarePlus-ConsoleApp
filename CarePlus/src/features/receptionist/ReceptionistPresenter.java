package features.receptionist;

import java.util.List;

import repository.dto.Appointment;

class ReceptionistPresenter implements IReceptionistPresenter {

	private final IReceptionistView view;

	private final IReceptionistModel model;

	public ReceptionistPresenter(ReceptionistView receptionistView) {
		view = receptionistView;
		model = new ReceptionistModel(this);
	}

	public void init() {
		model.init();
	}

	public void viewAllAppointments() {
		model.viewAllAppointments();
	}

	public void proceedFeatures() {
		view.proceedFeatures();
	}

	public void showAllAppointments(List<Appointment> appointments) {
		view.showAllAppointments(appointments);
	}

	public void noAppointments() {
		view.noAppointments();
	}

}
