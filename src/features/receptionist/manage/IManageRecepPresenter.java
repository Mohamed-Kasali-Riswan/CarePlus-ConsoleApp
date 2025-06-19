package features.receptionist.manage;

import java.util.List;

import repository.dto.Receptionist;

public interface IManageRecepPresenter {

	// Methods in Model

	void init();

	void addReceptionist(Receptionist receptionist);

	void removeReceptionist(String recId);

	boolean containsReceptionistById(String recId);

	void viewAllReceptionist();

	// Methods in View

	void proceedFeatures();

	void receptionAdded(String string);

	void noReceptionAdded();

	void successremoved(String recId);

	void showAllRecs(List<Receptionist> recs);

}
