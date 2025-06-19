package features.login;

interface ILoginModel {

	void init();

	boolean validateReceptionist(String username, String password);

	boolean validate(String username, String password);

}
