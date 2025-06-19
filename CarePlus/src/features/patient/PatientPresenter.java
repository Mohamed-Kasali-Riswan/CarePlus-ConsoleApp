package features.patient;

import java.util.List;

import repository.dto.Patient;

class PatientPresenter implements IPatientPresenter {

	private final IPatientView view;

	private final IPatientModel model;

	public PatientPresenter(PatientView patientView) {
		view = patientView;
		model = new PatientModel(this);
	}

	public void init() {
		model.init();
	}

	public void viewAllPatient() {
		model.viewAllPatient();
	}

	public void addPatient(Patient patient) {
		model.addPatient(patient);
	}

	public void proceedFeatures() {
		view.proceedFeatures();
	}

	public void noPatients() {
		view.noPatients();
	}

	public void showAllPatient(List<Patient> patients) {
		view.showAllPatient(patients);
	}

	public void addedSuccess(String string) {
		view.addedSuccess(string);
	}

}
