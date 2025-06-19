use Careplus;

-- Table to store the details of the Doctors
CREATE TABLE Doctor (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    age TINYINT,
    gender VARCHAR(10),
    experience TINYINT,
    address VARCHAR(100),
    email VARCHAR(50),
    specialization VARCHAR(50),
    available_start TINYINT,
    available_end TINYINT
);

-- Table to store the details of the Patients
CREATE TABLE Patient (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    age TINYINT,
    gender VARCHAR(10),
    weight TINYINT,
    problem VARCHAR(100),
    address VARCHAR(100),
    admit_date VARCHAR(10) NOT NULL
);

-- Table to store the details of the Appointments
CREATE TABLE Appointment (
    appointment_id VARCHAR(20) PRIMARY KEY,
    patient_id VARCHAR(20) NOT NULL,
    doctor_id VARCHAR(20) NOT NULL,
    date VARCHAR(10) NOT NULL,
    appointment_time TINYINT NOT NULL,

    CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES Patient(id),
    CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);

-- Table to store the details of the Receptionists
CREATE TABLE Receptionist (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    address VARCHAR(100),
    email VARCHAR(50) UNIQUE,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

