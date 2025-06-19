package features.patient;

import java.util.List;

import repository.dto.Patient;

public interface IPatientPresenter {
	
	// Methods in Model

	void init();

	void viewAllPatient();

	void addPatient(Patient patient);
	
	// Methods in View

	void proceedFeatures();

	void showAllPatient(List<Patient> patients);

	void noPatients();

	void addedSuccess(String string);

}
