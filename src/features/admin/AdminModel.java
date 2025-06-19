package features.admin;

class AdminModel implements IAdminModel {

	private final IAdminPresenter presenter;

	public AdminModel(AdminPresenter adminPresenter) {
		presenter = adminPresenter;
	}

	public void init() {
		presenter.proceedFeature();
	}

}
