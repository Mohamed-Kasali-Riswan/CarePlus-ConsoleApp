package features.receptionist.manage;

import java.util.List;

import repository.dto.Receptionist;

public interface IManageRecepView {

	void proceedFeatures();

	void receptionAdded(String string);

	void noReceptionAdded();

	void successremoved(String recId);

	void showAllRecs(List<Receptionist> recs);

}
