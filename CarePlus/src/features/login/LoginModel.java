package features.login;

import repository.db.CareplusDB;

class LoginModel {
	
	private LoginView view;
	
	LoginModel(LoginView view){
		this.view = view;
	}
	
	public void init() {

		view.proceedLoginOption();
				
	}

	public boolean validate(String username, String password) {
		if(CareplusDB.getInstance().validateAdminLogin(username,password)) {
			return true;
		}
		return false;
	}

	public boolean validateReceptionist(String username, String password) {
	
		return CareplusDB.getInstance().validateReceptionistLogin(username,password);
	}

}
