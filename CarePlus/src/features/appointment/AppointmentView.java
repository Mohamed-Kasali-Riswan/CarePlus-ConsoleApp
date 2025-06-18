package features.appointment;

import java.util.List;

import base.BaseView;
import repository.dto.Appointment;
import repository.dto.Patient;

public class AppointmentView extends BaseView {

	private final AppointmentModel model;

	public AppointmentView() {
		model = new AppointmentModel(this);
	}

	public void init() {

		model.init();

	}

	public void proceedFeatures() {

		boolean flag = true;

		while (flag) {

			System.out.println("1. Allocation");
			System.out.println("2. View All Appointments");
			System.out.println("3. Back");
			System.out.println("4. Logout");

			switch (scanner.nextInt()) {

			case 1: {
				String namez = getName();
				System.out.println("For Showing All the Patients with this name!");
				model.searchPatientByName(namez);

				String patientId = getPatientId();
				System.out.println("For Showing All the Doctors and their Available time!");
				model.viewAvailabletimeAndDoctors(patientId);

				addAppointment();

				break;
			}
			case 2: {
				model.viewAllAppointments();
				break;
			}
			case 3: {
				flag = false;
				break;
			}
			case 4: {
				logout();
				break;
			}
			default: {
				System.out.println("Invalid Option!");
				break;
			}
			}

		}

	}

	private boolean isContinue(String s) {
		System.out.println(s);
		System.out.println("Do you want to continue:");
		char ans = scanner.next().charAt(0);
		return ans == 'y' || ans == 'Y';
	}

	private void addAppointment() {
		Appointment app = new Appointment();

		app.setAppointmentId();
		app.setPatientId(getPatientId());
		String docId = getDoctorId();
		app.setDoctorId(docId);
		app.setDate(getDate());
		app.setTime(getTime(docId));

		if (!model.isAlreadyfixed(app)) model.addAppointment(app);
		else showMessage("This time slot is already fixed!");

	}

	private byte getTime(String docId) {
		System.out.println("Enter the Time :");
		do {
			byte time = scanner.nextByte();
			if (!model.isAvailabletimeForDoctor(docId, time))
				System.out.println("Not available time!");
			else
				return time;
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

	private String getDoctorId() {
		System.out.println("Enter the Doctor Id:");
		do {
			String id = scanner.next();
			if (!id.startsWith("DOCTR"))
				showMessage("Invalid ID!");
			else
				return id;
		} while (true);
	}

	private String getPatientId() {
		System.out.println("Enter the Patient Id:");
		do {
			String id = scanner.next();
			if (!id.startsWith("PAT"))
				showMessage("Invalid ID!");
			else
				return id;
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

	public void noPatientWithName(String patientName) {
		showMessage("There is no patient with the name : " + patientName);
	}

	public void showAllPatients(List<Patient> patients) {
		for (Patient patient : patients) {
			System.out.println(patient);
		}
	}

	public void noAvailableAppointments() {
		showMessage("No appointments !");
	}

	public void showAllAppointments(List<String> availabledoctorsAndTime) {
		int i = 0;
		for (String appointmentsAvailable : availabledoctorsAndTime) {
			System.out.println(i + ". " + appointmentsAvailable);
			i++;
		}
	}

	public void showAllBookedAppointments(List<Appointment> allappointments) {
		for (Appointment appointment : allappointments) {
			System.out.println(appointment);
		}
	}

	public void appointmentAddedSuccess() {
		showMessage("Appointment is added successfully!");
	}

}
