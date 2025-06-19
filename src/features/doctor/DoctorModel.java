package features.doctor;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Doctor;

class DoctorModel implements IDoctorModel {

	private final IDoctorPresenter view;

	public DoctorModel(DoctorPresenter doctorPresenter) {
		view = doctorPresenter;
	}

	public void init() {
		view.proceedFeatures();
	}

	public void addDoctor(Doctor doctor) {
		CareplusDB.getInstance().addDoctor(doctor);
		view.doctorAddSuccess(doctor.getId() + " - " + doctor.getName());
	}

	public boolean isDoctorPresent(String docId) {
		if (CareplusDB.getInstance().isDoctorPresentbyId(docId))
			return true;
		return false;
	}

	public void changeTime(String docId, byte starttime, byte startEnd) {
		CareplusDB.getInstance().changetimeforDoctor(docId, starttime, startEnd);
		view.timeChanged(docId);
	}

	public void listAllDoctors() {
		List<Doctor> doctors = CareplusDB.getInstance().getAllDoctors();

		if (doctors.size() == 0)
			view.noDoctors("");
		else
			view.showAllDoctors(doctors);
	}

}
