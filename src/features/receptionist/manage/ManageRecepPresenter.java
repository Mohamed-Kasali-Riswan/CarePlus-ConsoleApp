package features.receptionist.manage;

import java.util.List;

import repository.dto.Receptionist;

class ManageRecepPresenter implements IManageRecepPresenter {

	private final IManageRecepView view;

	private final IManageRecepModel model;

	public ManageRecepPresenter(ManageRecepView manageRecepView) {
		view = manageRecepView;
		model = new ManageRecepModel(this);
	}

	public void init() {
		model.init();
	}

	public void addReceptionist(Receptionist receptionist) {
		model.addReceptionist(receptionist);
	}

	public void viewAllReceptionist() {
		model.viewAllReceptionist();
	}

	public boolean containsReceptionistById(String recId) {
		return model.containsReceptionistById(recId);
	}

	public void removeReceptionist(String recId) {
		model.removeReceptionist(recId);
	}

	public void proceedFeatures() {
		view.proceedFeatures();
	}

	public void receptionAdded(String string) {
		view.receptionAdded(string);
	}

	public void noReceptionAdded() {
		view.noReceptionAdded();
	}

	public void successremoved(String recId) {
		view.successremoved(recId);
	}

	public void showAllRecs(List<Receptionist> recs) {
		view.showAllRecs(recs);
	}

}
