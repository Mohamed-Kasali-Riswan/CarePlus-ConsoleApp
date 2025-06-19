package features.receptionist.manage;

import repository.dto.Receptionist;

public interface IManageRecepModel {

	void init();

	void addReceptionist(Receptionist receptionist);

	void viewAllReceptionist();

	boolean containsReceptionistById(String recId);

	void removeReceptionist(String recId);

}
