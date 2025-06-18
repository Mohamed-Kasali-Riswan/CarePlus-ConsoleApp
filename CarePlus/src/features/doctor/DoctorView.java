package features.doctor;

import java.util.List;

import base.BaseView;
import features.appointment.AppointmentView;
import repository.dto.Doctor;

public class DoctorView extends BaseView{
	
	private DoctorModel model;

	public DoctorView() {
		model = new DoctorModel(this);
	}
	
	public void init() {
		model.init();
	}

	public void proceedFeatures() {
		boolean flag = true;
		
		
		while(flag) {
			System.out.println("1. Add Doctor");
			System.out.println("2. Manage Doctor Time");
			System.out.println("3. Appointment Sceduling");
			System.out.println("4. List All Doctors");
			System.out.println("5. Back");
			System.out.println("6. Exit");
			System.out.println("Enter the option:");
			switch(scanner.nextInt()) {
			
			case 1:{
				addDoctor();
				break;
			}
			case 2:{
				managedoctortime();
				break;
			}
			case 3:{
				new AppointmentView().init();
				break;
			}
			case 4:{
				listAllDoctors();
				break;
			}
			case 5:{
				flag=false;
				break;
			}
			case 6:{
				exitApp();;
			}
			default:{
				System.out.println("Invalid Option");
				break;
			}
			}
			
		}
		
	}

	private void listAllDoctors() {
		model.listAllDoctors();
	}


	private void managedoctortime() {
		System.out.println("Enter the Doctor Id:");
		String docId = scanner.next();
		
		if(model.isDoctorPresent(docId)) {
			byte starttime = getTime("Enter the new Available Start time:");
			byte startEnd = getTime("Enter the new Available End time:");
			
			model.changeTime(docId,starttime,startEnd);
			
		}else {
			System.out.println("There is no Doctor with this ID!");
		}
		
	}

	private void addDoctor() {
		Doctor doctor= new Doctor();
		
		doctor.setId("");
		doctor.setName(getName());
		doctor.setMobile(getMobile("Mobile Number"));
		doctor.setAge(getAge("Age"));
		doctor.setExperience(getExperience("Experience"));
		doctor.setSpecialization(getSpecialization());
		doctor.setAvailabileStart(getTime("Start time"));
		doctor.setAvailabileEnd(getTime("End time"));
		
		model.addDoctor(doctor);
		
		
	}

	private byte getTime(String prompt) {
		System.out.println("Enter the "+prompt+" time in 24Hrs:");
		do {
			byte time = scanner.nextByte();
			if(time<0 || time>24) System.out.println("Invalid time");
			else return time;
		}while(true);
	}

	private String getSpecialization() {
		System.out.println("Enter your Specialization:");
		do {
			String specialization = scanner.next();
			scanner.next();
			if(specialization.length()<5 || specialization.length()>50) System.out.println("Invalid String");
			else return specialization;
		}while(true);
	}

	private byte getExperience(String prompt) {
		System.out.println("Enter the "+prompt+":");
		do {
			byte time = scanner.nextByte();
			if(time<0 || time>50) System.out.println("Invalid Experience");
			else return time;
		}while(true);
	}

	private byte getAge(String prompt) {
		System.out.println("Enter the "+prompt+":");
		do {
			byte time = scanner.nextByte();
			if(time<0 || time>80) System.out.println("Invalid age");
			else return time;
		}while(true);
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

	public void noDoctors(String string) {
		showMessage("No doctors Added!");
	}

	public void showAllDoctors(List<Doctor> doctors) {
		for(Doctor doctor : doctors) {
			System.out.println(doctor);
		}
	}

	public void doctorAddSuccess(String string) {
		showMessage(string+", the doctor is Added!");
	}

	public void timeChanged(String docId) {
		showMessage("Doctor with id:"+docId+" has updated his available time!");
	}
	
}
