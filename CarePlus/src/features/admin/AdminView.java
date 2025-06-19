package features.admin;

import base.BaseView;
import features.appointment.AppointmentView;
import features.doctor.DoctorView;
import features.receptionist.ReceptionistView;
import features.receptionist.manage.ManageRecepView;

public class AdminView extends BaseView implements IAdminView {

	private final IAdminPresenter presenter;

	public AdminView() {
		presenter = new AdminPresenter(this);
	}

	public void init() {
		presenter.init();
	}

	public void proceedFeature() {

		boolean flag = true;

		while (flag) {
			
			try {
				System.out.println("1. Manage Doctor");
				System.out.println("2. Manage Receptionist");
				System.out.println("3. Manage Appointments");
				System.out.println("4. Logout");
				System.out.println("5. Exit");
				System.out.print("Enter your option:");
				switch (scanner.nextInt()) {
				case 1: {
					ManageDoctor();
					break;
				}
				case 2: {
					ManageReceptionist();
					break;
				}
				case 3: {
					ManageAppointment();
					break;
				}
				case 4: {
					logout();
					break;
				}
				case 5: {
					exitApp();
					break;
				}
				default: {
					System.out.println("Invalid Option!");
					break;
				}
				}

			} catch (Exception e) {
				System.out.println("Invalid Input");
				scanner.nextLine();
			}

		}

	}

	private void ManageAppointment() {
		new AppointmentView().init();
	}

	private void ManageReceptionist() {
		new ManageRecepView().init();
	}

	private void ManageDoctor() {
		new DoctorView().init();
	}

}
