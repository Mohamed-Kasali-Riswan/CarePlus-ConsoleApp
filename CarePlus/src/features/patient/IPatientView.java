package features.patient;

import java.util.List;

import repository.dto.Patient;

public interface IPatientView {

	void proceedFeatures();

	void noPatients();

	void showAllPatient(List<Patient> patients);

	void addedSuccess(String string);

}
