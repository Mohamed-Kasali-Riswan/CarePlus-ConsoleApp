package features.doctor;

import java.util.List;

import repository.dto.Doctor;

class DoctorPresenter implements IDoctorPresenter {

	private final IDoctorView view;

	private final IDoctorModel model;

	public DoctorPresenter(DoctorView doctorView) {
		this.view = doctorView;
		model = new DoctorModel(this);
	}

	public void init() {
		model.init();
	}

	public void listAllDoctors() {
		model.listAllDoctors();
	}

	public void changeTime(String docId, byte starttime, byte startEnd) {
		model.changeTime(docId, starttime, startEnd);
	}

	public boolean isDoctorPresent(String docId) {
		return model.isDoctorPresent(docId);
	}

	public void addDoctor(Doctor doctor) {
		model.addDoctor(doctor);
	}

	public void proceedFeatures() {
		view.proceedFeatures();
	}

	public void doctorAddSuccess(String string) {
		view.doctorAddSuccess(string);
	}

	public void timeChanged(String docId) {
		view.timeChanged(docId);
	}

	public void noDoctors(String string) {
		view.noDoctors(string);
	}

	public void showAllDoctors(List<Doctor> doctors) {
		view.showAllDoctors(doctors);
	}

}
