package repository.dto;

import java.util.UUID;

public class Admin {
	
	private static Admin admin;
	
	private final String name = "Riswan";
	private final String email = "rxswxn";
	private final String password = "Rxswxn@2";

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public static Admin getInstance() {
		if(admin==null) admin = new Admin();
		return admin;
	}
	
	
}
