package features.admin;

public class AdminModel {
	
	private final AdminView view;

	public AdminModel(AdminView adminView) {
		view = adminView;
	}

	public void init() {
		view.proceedFeature();
	}

}
