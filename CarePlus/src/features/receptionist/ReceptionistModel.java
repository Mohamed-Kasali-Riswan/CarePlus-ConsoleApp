package features.receptionist;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Appointment;

class ReceptionistModel {
	
	private final ReceptionistView view;
	
	ReceptionistModel (ReceptionistView view){
		this.view = view;
	}

	public void init() {
		view.proceedFeatures();
	}

	public void viewAllAppointments() {
		List<Appointment> appointments = CareplusDB.getInstance().getAllAppointments();
		
		if(appointments.size()==0) view.noAppointments();
		else view.showAllAppointments(appointments);
		
	}

}
