package repository.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import repository.dto.Appointment;
import repository.dto.Doctor;
import repository.dto.Patient;
import repository.dto.Receptionist;

public class CareplusMySqlDb {

    private static CareplusMySqlDb instance;

    private CareplusMySqlDb() {}

    public static CareplusMySqlDb getInstance() {
        if (instance == null) {
            instance = new CareplusMySqlDb();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/careplus"; 
        String user = "root";  
        String password = "root";  
        return DriverManager.getConnection(url, user, password);
    }

    // INSERT METHODS
    
    public void insertReceptionist(Receptionist receptionist) throws SQLException {
        String query = "INSERT INTO Receptionist (id, name, mobile, address, email, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, receptionist.getId());
            ps.setString(2, receptionist.getName());
            ps.setString(3, receptionist.getMobile());
            ps.setString(4, receptionist.getAddress());
            ps.setString(5, receptionist.getEmail());
            ps.setString(6, receptionist.getUsername());
            ps.setString(7, receptionist.getPassword());
            ps.executeUpdate();
        }
    }


    public void insertDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO Doctor (id, name, mobile, age, gender, experience, address, email, specialization, available_start, available_end) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, doctor.getId());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getMobile());
            ps.setByte(4, doctor.getAge());
            ps.setString(5, doctor.getGender());
            ps.setByte(6, doctor.getExperience());
            ps.setString(7, doctor.getAddress());
            ps.setString(8, doctor.getEmail());
            ps.setString(9, doctor.getSpecialization());
            ps.setByte(10, doctor.getAvailabileStart());
            ps.setByte(11, doctor.getAvailabileEnd());
            ps.executeUpdate();
        }
    }

    public void insertPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO Patient (id, name, mobile, age, gender, weight, problem, address, admit_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, patient.getId());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getMobile());
            ps.setByte(4, patient.getAge());
            ps.setString(5, patient.getGender());
            ps.setByte(6, patient.getWeight());
            ps.setString(7, patient.getProblem());
            ps.setString(8, patient.getAddress());
            ps.setDate(9, java.sql.Date.valueOf(patient.getAdmitDate()));
            ps.executeUpdate();
        }
    }

    public void insertAppointment(Appointment appt) throws SQLException {
        String query = "INSERT INTO Appointment (appointment_id, patient_id, doctor_id, date, appointment_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, appt.getAppointmentId());
            ps.setString(2, appt.getPatientId());
            ps.setString(3, appt.getDoctorId());
            ps.setString(4, appt.getDate());  
            ps.setByte(5, appt.getTime());
            ps.executeUpdate();
        }
    }

    // GET ALL METHODS 

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> list = new ArrayList<>();
        String query = "SELECT * FROM Doctor";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getString("id"));
                d.setName(rs.getString("name"));
                d.setMobile(rs.getString("mobile"));
                d.setAge(rs.getByte("age"));
                d.setGender(rs.getString("gender"));
                d.setExperience(rs.getByte("experience"));
                d.setAddress(rs.getString("address"));
                d.setEmail(rs.getString("email"));
                d.setSpecialization(rs.getString("specialization"));
                d.setAvailabileStart(rs.getByte("available_start"));
                d.setAvailabileEnd(rs.getByte("available_end"));
                list.add(d);
            }
        }
        return list;
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> list = new ArrayList<>();
        String query = "SELECT * FROM Patient";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setMobile(rs.getString("mobile"));
                p.setAge(rs.getByte("age"));
                p.setGender(rs.getString("gender"));
                p.setWeight(rs.getByte("weight"));
                p.setProblem(rs.getString("problem"));
                p.setAddress(rs.getString("address"));
                p.setAdmitDate(rs.getDate("admit_date").toString()); 
                list.add(p);
            }
        }
        return list;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> list = new ArrayList<>();
        String query = "SELECT * FROM Appointment";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getString("appointment_id"));
                a.setPatientId(rs.getString("patient_id"));
                a.setDoctorId(rs.getString("doctor_id"));
                a.setDate(rs.getString("date"));
                a.setTime(rs.getByte("appointment_time"));
                list.add(a);
            }
        }
        return list;
    }

	public void updateTimeForDoctor(Doctor updatedoctor)  throws SQLException{
		String query = "UPDATE Doctor SET available_start = ?, available_end = ? WHERE id = ?";
	    try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setByte(1, updatedoctor.getAvailabileStart());
	        ps.setByte(2, updatedoctor.getAvailabileEnd());
	        ps.setString(3, updatedoctor.getId());
	        ps.executeUpdate();
	    }
	}

	public List<Receptionist> getAllReceptionist()throws SQLException {
		List<Receptionist> list = new ArrayList<>();
	    String query = "SELECT * FROM Receptionist";
	    try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
	        while (rs.next()) {
	            Receptionist r = new Receptionist();
	            r.setId(rs.getString("id"));
	            r.setName(rs.getString("name"));
	            r.setMobile(rs.getString("mobile"));
	            r.setAddress(rs.getString("address"));
	            r.setEmail(rs.getString("email"));
	            r.setUsername(rs.getString("username"));
	            r.setPassword(rs.getString("password"));
	            list.add(r);
	        }
	    }
	    return list;
	}
	
	public void deleteReceptionist(String receptionistId) throws SQLException {
	    String query = "DELETE FROM Receptionist WHERE id = ?";
	    try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setString(1, receptionistId);
	        ps.executeUpdate();
	    }
	}

}
