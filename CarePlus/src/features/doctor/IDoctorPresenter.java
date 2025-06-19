package features.doctor;

import java.util.List;

import repository.dto.Doctor;

interface IDoctorPresenter {
	
	// Methods in Model

	void init();

	void listAllDoctors();

	boolean isDoctorPresent(String docId);

	void changeTime(String docId, byte starttime, byte startEnd);

	void addDoctor(Doctor doctor);

	// Methods in View
	
	void proceedFeatures();

	void doctorAddSuccess(String string);

	void timeChanged(String docId);

	void noDoctors(String string);

	void showAllDoctors(List<Doctor> doctors);

}
