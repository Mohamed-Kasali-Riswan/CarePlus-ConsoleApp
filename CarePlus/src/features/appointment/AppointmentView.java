package features.appointment;

import java.util.List;
import util.Util;

import base.BaseView;
import repository.dto.Appointment;
import repository.dto.Patient;

public class AppointmentView extends BaseView implements IAppointmentView {

	private final IAppointmentPresenter presenter;

	public AppointmentView() {
		presenter = new AppointmentPresenter(this);
	}

	public void init() {

		presenter.init();

	}

	public void proceedFeatures() {

		boolean flag = true;

		while (flag) {
			
			try {
				System.out.println();
				System.out.println("1. Allocation");
				System.out.println("2. Check Availability for future");
				System.out.println("3. Search Pateints by Name");
				System.out.println("4. View All Appointments");
				System.out.println("5. Back");
				System.out.println("6. Logout");
				System.out.print("Enter your option:");

				switch (scanner.nextInt()) {

				case 1: {
					System.out.print("Enter the name of the Patient for searching the Patient ID!");
					String namez = getName();
					presenter.searchPatientByName(namez);

					String patientId = getPatientId();
					System.out.println("For Showing All the Doctors and their Available time!");
					presenter.viewAvailabletimeAndDoctors(getDate(0));

					System.out.println("Do you want to proceed Allocation(Y/N):");
					char c = scanner.next().charAt(0);
					if (c == 'y' || c == 'Y')
						addAppointment();

					break;
				}
				case 2: {
					System.out.print("Enter the Number of Days after today to check for Availability: ");
					int days = 0;
					do {
						days = scanner.nextInt();
						if (days < 0 || days > 10)
							System.out.println("Sorry Limited Days!");
						else
							break;
					} while (true);
					presenter.viewAvailabletimeAndDoctors(getDate(days));
					break;
				}
				case 3: {
					presenter.searchPatientByName(getName());
					break;
				}
				case 4: {
					presenter.viewAllAppointments();
					break;
				}
				case 5: {
					flag = false;
					break;
				}
				case 6: {
					logout();
					break;
				}
				default: {
					System.out.println("Invalid Option!");
					break;
				}
				}

			}catch (Exception e) {
				System.out.println("Invalid Input!");
				scanner.nextLine();
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
		app.setDate(getDate(0));
		app.setTime(getTime(docId));

		if (!presenter.isAlreadyfixed(app))
			presenter.addAppointment(app);
		else
			showMessage("This time slot is already fixed!");

	}

	private byte getTime(String docId) {
		System.out.println("Enter the Time :");
		do {
			byte time = scanner.nextByte();
			if (!presenter.isAvailabletimeForDoctor(docId, time))
				System.out.println("Not available time!");
			else
				return time;
		} while (true);
	}

	private String getDate(int days) {

		return new Util().utcMillisToDate(new Util().nowPlusDaysToUtcMillis(days));

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
		int i = 1;
		System.out.println("Available Doctors & their time slots:\n");
		for (String appointmentsAvailable : availabledoctorsAndTime) {
			System.out.println(i + ". " + appointmentsAvailable);
			i++;
		}
		System.out.println();
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
