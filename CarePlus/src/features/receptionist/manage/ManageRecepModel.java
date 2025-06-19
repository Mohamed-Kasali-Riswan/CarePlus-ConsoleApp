package features.receptionist.manage;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Receptionist;

class ManageRecepModel implements IManageRecepModel {

	private final IManageRecepPresenter presenter;

	ManageRecepModel(ManageRecepPresenter manageRecepPresenter) {
		this.presenter = manageRecepPresenter;
	}

	public void init() {
		presenter.proceedFeatures();
	}

	public void addReceptionist(Receptionist rec) {
		if (CareplusDB.getInstance().addReceptionist(rec)) {
			presenter.receptionAdded(rec.getId() + " - " + rec.getName());
		} else
			presenter.noReceptionAdded();
	}

	public void removeReceptionist(String recId) {
		CareplusDB.getInstance().removeReceptionistById(recId);
		presenter.successremoved(recId);
	}

	public boolean containsReceptionistById(String recId) {
		return CareplusDB.getInstance().containsReceptionistById(recId);
	}

	public void viewAllReceptionist() {
		List<Receptionist> recs = CareplusDB.getInstance().getAllReceptionists();
		if (recs.size() == 0)
			presenter.noReceptionAdded();
		else
			presenter.showAllRecs(recs);
	}
}
