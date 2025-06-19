package features.admin;

public class AdminPresenter implements IAdminPresenter {

	private final IAdminView view;
	private final IAdminModel model;

	public AdminPresenter(AdminView adminView) {
		view = adminView;
		model = new AdminModel(this);
	}

	public void init() {
		model.init();
	}

	public void proceedFeature() {
		view.proceedFeature();
	}

}
