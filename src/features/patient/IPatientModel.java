package features.patient;

import repository.dto.Patient;

public interface IPatientModel {

	void init();

	void viewAllPatient();

	void addPatient(Patient patient);

}
