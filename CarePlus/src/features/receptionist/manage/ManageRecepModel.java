package features.receptionist.manage;

import java.util.List;

import repository.db.CareplusDB;
import repository.dto.Receptionist;

public class ManageRecepModel {

	private final ManageRecepView view;
	
	ManageRecepModel(ManageRecepView view){
		this.view = view;
	}

	public void init() {
		view.proceedFeatures();
	}

	public void addReceptionist(Receptionist rec) {
		if(CareplusDB.getInstance().addReceptionist(rec)) {
			view.receptionAdded(rec.getId()+" - "+rec.getName());
		}else view.noReceptionAdded();
	}

	public void removeReceptionist(String recId) {
		CareplusDB.getInstance().removeReceptionistById(recId);
		view.successremoved(recId);
	}

	public boolean containsReceptionistById(String recId) {
		return CareplusDB.getInstance().containsReceptionistById(recId);
	}

	public void viewAllReceptionist() {
		List<Receptionist> recs = CareplusDB.getInstance().getAllReceptionists();
		if(recs.size()==0) view.noReceptionAdded();
		else view.showAllRecs(recs);
	}
}
