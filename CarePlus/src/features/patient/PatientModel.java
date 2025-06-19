package features.patient;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Patient;

class PatientModel implements IPatientModel {

	private final IPatientPresenter presenter;

	PatientModel(PatientPresenter patientPresenter) {
		this.presenter = patientPresenter;
	}

	public void init() {
		presenter.proceedFeatures();
	}

	public void viewAllPatient() {
		List<Patient> patients = CareplusDB.getInstance().getAllPatients();

		if (patients.size() == 0)
			presenter.noPatients();
		else
			presenter.showAllPatient(patients);

	}

	public void addPatient(Patient patient) {
		CareplusDB.getInstance().addPatient(patient);
		presenter.addedSuccess(patient.getId() + " - " + patient.getName());
	}

}
