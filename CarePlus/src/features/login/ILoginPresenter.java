package features.login;

interface ILoginPresenter {

	// Methods in Model

	void init();

	boolean validateReceptionist(String username, String password);

	boolean validate(String username, String password);

	// Method in View

	void proceedLoginOption();

}
