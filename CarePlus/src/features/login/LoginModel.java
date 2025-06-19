package features.login;

import java.sql.SQLException;

import repository.db.CareplusDB;

class LoginModel implements ILoginModel {

	private final ILoginPresenter presenter;

	LoginModel(LoginPresenter loginPresenter) {
		this.presenter = loginPresenter;
	}

	public void init() {

		presenter.proceedLoginOption();

	}

	public boolean validate(String username, String password) {
		if (CareplusDB.getInstance().validateAdminLogin(username, password)) {
			return true;
		}
		return false;
	}

	public boolean validateReceptionist(String username, String password) {

		try {
			return CareplusDB.getInstance().validateReceptionistLogin(username, password);
		} catch (SQLException e) {
			System.out.println("Error while Validating Validation in the DB");
			e.printStackTrace();
			return false;
		}
	}

}
