package features.patient;

import repository.dto.Patient;

interface IPatientModel {

	void init();

	void viewAllPatient();

	void addPatient(Patient patient);

}
