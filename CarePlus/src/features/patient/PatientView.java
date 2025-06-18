package features.patient;

import java.util.List;

import base.BaseView;
import features.appointment.AppointmentView;
import repository.dto.Patient;

public class PatientView extends BaseView {

	private final PatientModel model;

	public PatientView() {
		model = new PatientModel(this);
	}

	public void init() {
		model.init();
	}

	public void proceedFeatures() {

		boolean flag = true;

		while (flag) {

			System.out.println("1. Add Patient");
			System.out.println("2. View All Patient");
			System.out.println("3. Appoint Patient");
			System.out.println("4. Back");
			System.out.println("5. Exit");
			switch (scanner.nextInt()) {

			case 1: {
				addPatient();
				break;
			}
			case 2: {
				model.viewAllPatient();
				break;
			}
			case 3: {
				new AppointmentView().init();
				break;
			}
			case 4: {
				flag = false;
				break;
			}
			case 5: {
				exitApp();
				break;
			}
			default: {
				System.out.println("Invalid Option!");
			}

			}

		}

	}

	private void addPatient() {
		Patient patient = new Patient();
		
		patient.setId();
		patient.setName(getName());
		patient.setAge(getAge("Age"));
		patient.setGender(getGender());
		patient.setWeight(getWeight("Weight"));
		patient.setMobile(getMobile("Mobile Number"));
		patient.setProblem(getProblem());
		patient.setAddress(getAddress());
		patient.setAdmitDate(getDate());
		patient.setAdmitMonth(getMonth());
		
		model.addPatient(patient);
	}

	private String getProblem() {
		System.out.println("Enter the Problem:");
		do {
			String patientName = scanner.next();
			if (isContainsNum(patientName) || patientName.length() < 3 || patientName.length()>100)
				System.out.println("Invalid Name");
			else
				return patientName;
		} while (true);
	}

	private byte getMonth() {
		System.out.println("Enter the Month:");
		do {
			byte month = scanner.nextByte();
			if (month < 1 || month > 12)
				System.out.println("Invalid Month");
			else
				return month;
		} while (true);
	}

	private byte getDate() {
		System.out.println("Enter the Date:");
		do {
			byte date = scanner.nextByte();
			if (date < 0 || date > 23)
				System.out.println("Invalid Date");
			else
				return date;
		} while (true);
	}

	private String getAddress() {
		System.out.println("Enter the Address:");
		do {
			String patientName = scanner.next();
			scanner.next();
			if (isContainsNum(patientName) || patientName.length() < 3 || patientName.length() > 100)
				System.out.println("Invalid Name");
			else
				return patientName;
		} while (true);
	}

	private byte getWeight(String prompt) {
		System.out.println("Enter the " + prompt + ":");
		do {
			byte time = scanner.nextByte();
			if (time < 0 || time > 143)
				System.out.println("Invalid Weight");
			else
				return time;
		} while (true);
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

	private byte getAge(String prompt) {
		System.out.println("Enter the " + prompt + ":");
		do {
			byte time = scanner.nextByte();
			if (time < 0 || time > 80)
				System.out.println("Invalid age");
			else
				return time;
		} while (true);
	}

	private String getMobile(String prompt) {
		System.out.println("Enter the " + prompt + ":");
		do {
			String mobileNum = scanner.next();
			if (mobileNum.length() != 10)
				System.out.println("Invalid Mobile Number");
			else
				return mobileNum;
		} while (true);
	}

	private String getName() {
		System.out.println("Enter the name:");
		do {
			String patientName = scanner.next();
			if (isContainsNum(patientName) || patientName.length() < 3 || patientName.length() > 20)
				System.out.println("Invalid Name");
			else
				return patientName;
		} while (true);
	}

	private boolean isContainsNum(String patientName) {
		for (int i = 0; i < 9; i++) {
			if (patientName.indexOf(i + "") != -1)
				return true;
		}
		return false;
	}

	public void noPatients() {
		showMessage("No Patients!");
	}

	public void showAllPatient(List<Patient> patients) {
		for (Patient patient : patients) {
			System.out.println(patient);
		}
	}

	public void addedSuccess(String string) {
		showMessage("Patient id:"+string+" is added");
	}

}
