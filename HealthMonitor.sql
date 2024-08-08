create database healthmonitor;

CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    description TEXT,
    diagnosis TEXT,
    treatment TEXT,
    mobile_number VARCHAR(15),
    address TEXT,
    date DATETIME NOT NULL,
    modify_date DATETIME,
    date_delete DATETIME,
    status VARCHAR(20),
    doctor_specialized VARCHAR(100),
    schedule VARCHAR(100)
);

CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    admin_id VARCHAR(50) NOT NULL,
    password varchar(50),
    full_name VARCHAR(100) NOT NULL,
    email varchar(50),
    gender VARCHAR(10),
    description TEXT,
    diagnosis TEXT,
    treatment TEXT,
    mobile_number VARCHAR(15),
    image varchar(50),
    address TEXT,
    date DATETIME NOT NULL,
    modify_date DATETIME,
    date_delete DATETIME,
    status VARCHAR(20),
    doctor_specialized VARCHAR(100),
    statu varchar(10)
);

CREATE TABLE doctor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id VARCHAR(50) NOT NULL,
    password varchar(50),
    full_name VARCHAR(100) NOT NULL,
    email varchar(50),
    gender VARCHAR(10),
    description TEXT,
    diagnosis TEXT,
    treatment TEXT,
    mobile_number VARCHAR(15),
    image varchar(50),
    address TEXT,
    date DATETIME NOT NULL,
    modify_date DATETIME,
    date_delete DATETIME,
    status VARCHAR(20),
    doctor_specialized VARCHAR(100),
    statu varchar(10)
);

CREATE TABLE patient
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id varchar(20),
    password varchar(50),
    full_name VARCHAR(100) NOT NULL,
    email varchar(50),
    gender VARCHAR(10),
    description TEXT,
    diagnosis TEXT,
    treatment TEXT,
    mobile_number VARCHAR(15),
    image varchar(50),
    address TEXT,
    date DATETIME NOT NULL,
    modify_date DATETIME,
    date_delete DATETIME,
    status VARCHAR(20),
    doctor_specialized VARCHAR(100),
    statu varchar(10)
);

CREATE TABLE patient
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id varchar(20),
	doctor varchar(50),
    total_days varchar(50),
    total_price varchar(50),
    date varchar(50),
    date_checkout varchar(50),
	date_pay varchar(50)
);

CREATE TABLE healthtracking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    height varchar(50),
    b_weight varchar(50),
    bmi varchar(50),
	heart_rate varchar(50),
    blood_presure varchar(50),
    b_temp varchar(50),
    steps varchar(50),
    date DATETIME NOT NULL,
    modify_date DATETIME,
    date_delete DATETIME,
    status VARCHAR(20),
    doctor_specialized VARCHAR(100),
    statu varchar(10)
);

CREATE TABLE patienteci (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50) NOT NULL,
    Gname VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
	mobile VARCHAR(10),
	address VARCHAR(10)
);


CREATE TABLE weeknutritiotable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    day VARCHAR(10)
    bmi VARCHAR(100) NOT NULL,
    b_weight VARCHAR(10),
	heart_rate VARCHAR(10),
	blood_presure VARCHAR(10),
    breakfast VARCHAR(10),
    lunch VARCHAR(10),
    dinner VARCHAR(10),
    snack1 VARCHAR(10),
    snack2 VARCHAR(10),
    notes VARCHAR(10)
);

CREATE TABLE monthnutritiotable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    week VARCHAR(10)
    bmi VARCHAR(100) NOT NULL,
    b_weight VARCHAR(10),
	heart_rate VARCHAR(10),
	blood_presure VARCHAR(10),
    breakfast VARCHAR(10),
    lunch VARCHAR(10),
    dinner VARCHAR(10),
    snack1 VARCHAR(10),
    snack2 VARCHAR(10),
    notes VARCHAR(10)
);

use healthmonitor;