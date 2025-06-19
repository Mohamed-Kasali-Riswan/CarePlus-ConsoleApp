package features.login;

class LoginPresenter implements ILoginPresenter {

	private final ILoginView view;

	private final ILoginModel model;

	public LoginPresenter(LoginView loginView) {
		view = loginView;
		model = new LoginModel(this);
	}

	public void init() {
		model.init();
	}

	public boolean validateReceptionist(String username, String password) {
		return model.validateReceptionist(username, password);
	}

	public boolean validate(String username, String password) {
		return model.validate(username, password);
	}

	public void proceedLoginOption() {
		view.proceedLoginOption();
	}

}
