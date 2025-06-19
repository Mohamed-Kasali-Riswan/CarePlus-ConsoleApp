package base;

import java.util.Scanner;

import features.login.LoginView;

public class BaseView {
	
	protected Scanner scanner = new Scanner(System.in);
	
	protected void exitApp() {
		System.out.println("Thank you for using CarePlus.");
		System.exit(0);
	}
	protected void showMessage(String message) {
		System.out.println(message);
	}
	
	protected void logout( ) {
		new LoginView().init();
	}
}
