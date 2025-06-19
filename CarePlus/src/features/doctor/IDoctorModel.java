package features.doctor;

import repository.dto.Doctor;

public interface IDoctorModel {

	void init();

	void listAllDoctors();

	void changeTime(String docId, byte starttime, byte startEnd);

	boolean isDoctorPresent(String docId);

	void addDoctor(Doctor doctor);

}
