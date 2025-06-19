package features.login;

public interface ILoginModel {

	void init();

	boolean validateReceptionist(String username, String password);

	boolean validate(String username, String password);

}
