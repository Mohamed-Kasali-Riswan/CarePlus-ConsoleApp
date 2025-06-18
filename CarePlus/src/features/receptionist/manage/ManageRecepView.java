package features.receptionist.manage;

import java.util.List;

import base.BaseView;
import repository.dto.Receptionist;

public class ManageRecepView extends BaseView{
	
	private final ManageRecepModel model;
	
	public ManageRecepView() {
		model = new ManageRecepModel(this);
	}

	public void init() {
		model.init();
	}

	public void proceedFeatures() {
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1. Add Receptionist");
			System.out.println("2. Remove Receptionist");
			System.out.println("3. View All Receptionist");
			System.out.println("4. Back");
			System.out.println("5. Logout");
			
			System.out.println("Enter the option:");
			switch(scanner.nextInt()) {
			
			case 1:{
				model.addReceptionist(getReceptionist());
				break;
			}
			case 2:{
				String recId = getReceptionistId();
				if(model.containsReceptionistById(recId))
					model.removeReceptionist(recId);
				else showMessage("There is no Receptionist with this ID");
				break;
			}
			case 3:{
				model.viewAllReceptionist();
				break;
			}
			case 4:{
				flag = false;
				break;
			}
			default:{
				System.out.println("Invalid Option!");
				break;
			}
			
			}
			
		}
	}

	private String getReceptionistId() {
		System.out.println("Enter the Receptionist ID:");
		do {
			String recId = scanner.next();
			if(!recId.startsWith("RECEP")) System.out.println("Invalid Receptionist ID");
			else return recId;
		}while(true);
	}

	private Receptionist getReceptionist() {
		Receptionist rec = new Receptionist();
		
		rec.setId("");
		rec.setName(getName());
		rec.setMobile(getMobile("Mobile"));
		rec.setUsername(getUserName());
		rec.setPassword(getPassword());
		rec.setAddress(getAddress());
		rec.setEmail(getEmail());
		
		return rec;
	}

	private String getEmail() {
			System.out.println("Enter the Email Address:");
			do {
				String email = scanner.next();
				if(isContainsSpecial(email) || email.length()<3 || email.length()>100 || !email.endsWith("@gmail.com")) System.out.println("Invalid Email");
				else return email;
			}while(true);
	}

	private boolean isContainsSpecial(String email) {
		char[] spl = {'/','?','!','#','%','^','&','*','(',')','_','-','+','='};
		for(int i=0;i<spl.length;i++) {
			if(email.indexOf(spl[i]+"")!=-1) return true;
		}
		return false;
	}

	public void receptionAdded(String string) {
		showMessage(string+", the receptionist is added");
	}

	public void noReceptionAdded() {
		showMessage("No receptionist is added");
	}

	private String getMobile(String prompt) {
		System.out.println("Enter the "+prompt+":");
		do {
			String mobileNum = scanner.next();
			if(mobileNum.length()!=10) System.out.println("Invalid Mobile Number");
			else return mobileNum;
		}while(true);
	}

	private String getName() {
		System.out.println("Enter the name:");
		do {
			String doctorName = scanner.next();
			if(isContainsNum(doctorName) || doctorName.length()<3 || doctorName.length()>20) System.out.println("Invalid Name");
			else return doctorName;
		}while(true);
	}
	
	private boolean isContainsNum(String doctorName) {
		for(int i=0;i<9;i++) {
			if(doctorName.indexOf(i+"")!=-1) return true;
		}
		return false;
	}
	
	private String getPassword() {
		System.out.println("Enter the Password:");
		do {
			String pass = scanner.next();
			if(pass.length()<8) System.out.print("Password should be of length greater 7\n");
			else if(!(isUpper(pass) && isLower(pass) && isNum(pass))) System.out.print("Password should one upper,lower,number,special character!");
			else return pass;
		}while(true);
	}

	private boolean isNum(String pass) {
		for(int i='0';i<='9';i++) {
			if(pass.indexOf((char)i+"")!=-1) return true;
		}
		return false;
	}

	private boolean isLower(String pass) {
		for(int i='a';i<='z';i++) {
			if(pass.indexOf((char)i+"")!=-1) return true;
		}
		return false;
	}

	private boolean isUpper(String pass) {
		for(int i='A';i<='Z';i++) {
			if(pass.indexOf((char)i+"")!=-1) return true;
		}
		return false;
	}

	public String getUserName() {
		System.out.println("Enter the username:");
		do {
			String uname = scanner.next();
			if(uname.length()<5 || uname.length()>20) System.out.println("Invalid Username");
			else return uname;
		}while(true);
	}
	
	private String getAddress() {
		System.out.println("Enter the Address:");
		String address = scanner.next();
		return address;
	}

	public void showAllRecs(List<Receptionist> recs) {
		for(Receptionist rec : recs) {
			System.out.println(rec);
		}
	}

	public void successremoved(String recId) {
		showMessage("Receptionist with id: "+recId+" is removed!");
	}
}
