package features.doctor;

import java.util.List;

import repository.dto.Doctor;

public interface IDoctorView {

	void proceedFeatures();

	void doctorAddSuccess(String string);

	void timeChanged(String docId);

	void noDoctors(String string);

	void showAllDoctors(List<Doctor> doctors);

}
