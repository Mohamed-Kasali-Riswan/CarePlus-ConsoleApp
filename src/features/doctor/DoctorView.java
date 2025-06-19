package features.doctor;

import java.util.List;

import base.BaseView;
import features.appointment.AppointmentView;
import repository.dto.Doctor;

public class DoctorView extends BaseView implements IDoctorView {

	private final IDoctorPresenter presenter;

	public DoctorView() {
		presenter = new DoctorPresenter(this);
	}

	public void init() {
		presenter.init();
	}

	public void proceedFeatures() {

		boolean flag = true;

		while (flag) {
			try {
				System.out.println("1. Add Doctor");
				System.out.println("2. Manage Doctor Time");
				System.out.println("3. Appointment Sceduling");
				System.out.println("4. List All Doctors");
				System.out.println("5. Back");
				System.out.println("6. Exit");
				System.out.println("Enter the option:");
				switch (scanner.nextInt()) {

				case 1: {
					addDoctor();
					break;
				}
				case 2: {
					managedoctortime();
					break;
				}
				case 3: {
					new AppointmentView().init();
					break;
				}
				case 4: {
					listAllDoctors();
					break;
				}
				case 5: {
					flag = false;
					break;
				}
				case 6: {
					exitApp();
					;
				}
				default: {
					System.out.println("Invalid Option");
					break;
				}
				}

			} catch (Exception e) {
				System.out.println("Invalid Input");
				scanner.nextLine();
			}
		}

	}

	private void listAllDoctors() {
		presenter.listAllDoctors();
	}

	private void managedoctortime() {
		System.out.println("Enter the Doctor Id:");
		String docId = scanner.next();

		if (presenter.isDoctorPresent(docId)) {
			byte starttime = getTime("Enter the new Available Start time:");
			byte startEnd = getTime("Enter the new Available End time:");

			presenter.changeTime(docId, starttime, startEnd);

		} else {
			System.out.println("There is no Doctor with this ID!");
		}

	}

	private void addDoctor() {
		Doctor doctor = new Doctor();

		doctor.setId();
		doctor.setName(getName());
		doctor.setMobile(getMobile("Mobile Number"));
		doctor.setAge(getAge("Age"));
		doctor.setGender(getGender());
		doctor.setExperience(getExperience("Experience"));
		doctor.setAddress(getAddress());
		doctor.setEmail(getEmail());
		doctor.setSpecialization(getSpecialization());
		doctor.setAvailabileStart(getTime("Start time"));
		doctor.setAvailabileEnd(getTime("End time"));

		presenter.addDoctor(doctor);

	}

	private String getGender() {
		System.out.println("Enter the Gender(Male/Female/Others):");
		do {
			String gender = scanner.next();
			if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")
					|| gender.equalsIgnoreCase("others")))
				System.out.println("Invalid Gender");
			else
				return gender;
		} while (true);
	}

	private String getEmail() {
		System.out.print("Enter the Email Address:");
		do {
			String email = scanner.next();
			if (isContainsSpecial(email) || email.length() < 3 || email.length() > 100 || !email.endsWith("@gmail.com"))
				System.out.print("Invalid Email! re-enter:");
			else
				return email;
		} while (true);
	}

	private boolean isContainsSpecial(String email) {
		char[] spl = { '/', '?', '!', '#', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=' };
		for (int i = 0; i < spl.length; i++) {
			if (email.indexOf(spl[i] + "") != -1)
				return true;
		}
		return false;
	}

	private String getAddress() {
		System.out.println("Enter the Address:");
		do {
			String patientName = scanner.next();
			if (isContainsNum(patientName) || patientName.length() < 3 || patientName.length() > 100)
				System.out.println("Invalid Name");
			else
				return patientName;
		} while (true);
	}

	private byte getTime(String prompt) {
		System.out.print("Enter the " + prompt + " time in 24Hrs:");
		do {
			byte time = scanner.nextByte();
			if (time < 0 || time > 24)
				System.out.print("Invalid time! re-enter:");
			else
				return time;
		} while (true);
	}

	private String getSpecialization() {
		System.out.print("Enter your Specialization:");
		do {
			String specialization = scanner.next();
			scanner.next();
			if (specialization.length() < 5 || specialization.length() > 50)
				System.out.print("Invalid String! re-enter:");
			else
				return specialization;
		} while (true);
	}

	private byte getExperience(String prompt) {
		System.out.print("Enter the " + prompt + ":");
		do {
			byte time = scanner.nextByte();
			if (time < 0 || time > 50)
				System.out.print("Invalid Experience! re-enter:");
			else
				return time;
		} while (true);
	}

	private byte getAge(String prompt) {
		System.out.print("Enter the " + prompt + ":");
		do {
			byte time = scanner.nextByte();
			if (time < 0 || time > 80)
				System.out.print("Invalid age! re-enter:");
			else
				return time;
		} while (true);
	}

	private String getMobile(String prompt) {
		System.out.print("Enter the " + prompt + ":");
		do {
			String mobileNum = scanner.next();
			if (mobileNum.length() != 10)
				System.out.print("Invalid Mobile Number! re-enter:");
			else
				return mobileNum;
		} while (true);
	}

	private String getName() {
		System.out.print("Enter the name:");
		do {
			String doctorName = scanner.next();
			if (isContainsNum(doctorName) || doctorName.length() < 3 || doctorName.length() > 20)
				System.out.print("Invalid Name! re-enter:");
			else
				return doctorName;
		} while (true);
	}

	private boolean isContainsNum(String doctorName) {
		for (int i = 0; i < 9; i++) {
			if (doctorName.indexOf(i + "") != -1)
				return true;
		}
		return false;
	}

	public void noDoctors(String string) {
		showMessage("No doctors Added!");
	}

	public void showAllDoctors(List<Doctor> doctors) {
		int i = 1;
		for (Doctor doctor : doctors) {
			System.out.println(i + ". " + doctor);
			i++;
		}
	}

	public void doctorAddSuccess(String string) {
		showMessage(string + ", the doctor is Added!");
	}

	public void timeChanged(String docId) {
		showMessage("Doctor with id:" + docId + " has updated his available time!");
	}

}
