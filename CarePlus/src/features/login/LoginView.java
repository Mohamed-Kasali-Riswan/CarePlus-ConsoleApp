package features.login;

import base.BaseView;
import features.admin.AdminView;
import features.receptionist.ReceptionistView;
import features.receptionist.manage.ManageRecepView;
import repository.dto.Admin;

public class LoginView extends BaseView{

	private LoginModel model;
	
	public LoginView() {
		model = new LoginModel(this);
	}
	public void init() {
		model.init();
	}
	
	public void proceedLoginOption() {
		System.out.print("Choose User Login Press 1 for Admin Login & 2 for Receptionist Login:");
		int option = scanner.nextInt();
		switch(option) {
			
		case 1:{
			adminLogin();
			break;
		}
		case 2:{
			receptionistLogin();
			break;
		}
		case 3:{
			exitApp();
			break;
		}
		default:{
			System.out.println("Invalid Option!");
			break;
		}
		
		}
	}

	private void receptionistLogin() {
		
		System.out.print("Enter the username:");
		String username = getUsername();
		System.out.print("Enter the password:");
		String password = getPassword();
		
		if(model.validateReceptionist(username , password)) {
			showMessage("Receptionist Login Successful");
			new ReceptionistView().init();
		}else {
			showMessage("Invalid Credentials!");
			System.out.println("Do you want to continue(Y/N):");
			char decision= scanner.next().charAt(0);
			if(decision=='y' || decision=='Y') receptionistLogin();
			else exitApp();
		}
		
		
	}

	private void adminLogin() {
		
		System.out.print("Enter the username:");
		String username = getUsername();
		System.out.print("Enter the password:");
		String password = getPassword();
		
		if(model.validate(username , password)) {
			showMessage("Admin Login Successful");
			new AdminView().init();
		}else {
			showMessage("Invalid Credentials!");
			System.out.println("Do you want to continue(Y/N):");
			char decision= scanner.next().charAt(0);
			if(decision=='y' || decision=='Y') adminLogin();
			else exitApp();
		}
		
	}
	
	private String getPassword() {
		do {
			String pass = scanner.next();
			if(pass.length()<8) System.out.print("Password should be of length greater 7\n");
			else if(!(isUpper(pass) && isLower(pass) && isNum(pass))) System.out.print("Password should one upper,lower,number,special character!");
			else return pass;
		}while(true);
	}

	private boolean isNum(String pass) {
		for(int i='0';i<='9';i++) {
			if(pass.indexOf((char)i+"")!=-1) return true;
		}
		return false;
	}

	private boolean isLower(String pass) {
		for(int i='a';i<='z';i++) {
			if(pass.indexOf((char)i+"")!=-1) return true;
		}
		return false;
	}

	private boolean isUpper(String pass) {
		for(int i='A';i<='Z';i++) {
			if(pass.indexOf((char)i+"")!=-1) return true;
		}
		return false;
	}

	public String getUsername() {
		do {
			String uname = scanner.next();
			if(uname.length()<5 || uname.length()>20) System.out.println("Invalid Username");
			else return uname;
		}while(true);
	}

	
}
