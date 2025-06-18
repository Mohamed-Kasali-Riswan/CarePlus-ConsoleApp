package features.patient;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Patient;

public class PatientModel {

	private final PatientView view;
	
	PatientModel(PatientView view){
		this.view = view;
	}

	public void init() {
		view.proceedFeatures();
	}

	public void viewAllPatient() {
		List<Patient> patients = CareplusDB.getInstance().getAllPatients();
		
		if(patients.size()==0) view.noPatients();
		else view.showAllPatient(patients);
		
	}

	public void addPatient(Patient patient) {
		CareplusDB.getInstance().addPatient(patient);
		view.addedSuccess(patient.getId()+" - "+patient.getName());
	}
	
}
