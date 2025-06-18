package features.admin;

import base.BaseView;
import features.doctor.DoctorView;
import features.receptionist.ReceptionistView;
import features.receptionist.manage.ManageRecepView;

public class AdminView extends BaseView{
	
	private AdminModel model;
	
	public AdminView() {
		model = new AdminModel(this);
	}

	public void init() {
		model.init();
	}

	public void proceedFeature() {
		
		boolean flag=true;
		
		while(flag) {
			
			System.out.println("1. Manage Doctor");
			System.out.println("2. Manage Receptionist");
			System.out.println("3. Logout");
			System.out.println("4. Exit");
			
			switch(scanner.nextInt()) {
			case 1:{
				ManageDoctor();
				break;
			}
			case 2:{
				ManageReceptionist();
				break;
			}
			case 3:{
				logout();
				break;
			}
			case 4:{
				ManageAppointment();
				exitApp();
			}
			default:{
				System.out.println("Invalid Option!");
			}
			}
			
		}
		
	}

	private void ManageAppointment() {
		// TODO Auto-generated method stub
		
	}

	private void ManageReceptionist() {
		new ManageRecepView().init();
	}

	private void ManageDoctor() {
		new DoctorView().init();
	}

}
