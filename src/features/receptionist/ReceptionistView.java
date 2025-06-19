package features.receptionist;

import java.util.List;

import base.BaseView;
import features.appointment.AppointmentView;
import features.doctor.DoctorView;
import features.patient.PatientView;
import repository.dto.Appointment;

public class ReceptionistView extends BaseView implements IReceptionistView {

	private final IReceptionistPresenter presenter;

	public ReceptionistView() {
		presenter = new ReceptionistPresenter(this);
	}

	public void init() {
		presenter.init();
	}

	public void proceedFeatures() {

		boolean flag = true;

		while (flag) {
			
			try {
				System.out.println("1. Manage Doctors");
				System.out.println("2. Manage Patients");
				System.out.println("3. Manage Appointments");
				System.out.println("4. View all appointments");
				System.out.println("5. Logout");
				System.out.println("6. Exit");
				System.out.print("Enter your option:");
				switch (scanner.nextInt()) {

				case 1: {
					new DoctorView().init();
					break;
				}
				case 2: {
					new PatientView().init();
					break;
				}
				case 3: {
					new AppointmentView().init();
					break;
				}
				case 4: {
					presenter.viewAllAppointments();
					break;
				}
				case 5: {
					flag = false;
					logout();
					break;
				}
				case 6: {
					exitApp();
					break;
				}
				default: {
					System.out.println("Invalid Option!");
					break;
				}
				}

			} catch (Exception e) {
				System.out.println("Invalid Input!");
				scanner.nextLine();
			}

		}
	}

	public void noAppointments() {
		showMessage("There is no appointments");
	}

	public void showAllAppointments(List<Appointment> appointments) {
		for (Appointment appointment : appointments) {
			System.out.println(appointment);
		}
	}

}
