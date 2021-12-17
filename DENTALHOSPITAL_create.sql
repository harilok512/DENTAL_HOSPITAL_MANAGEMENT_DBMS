-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-12-16 14:00:13.773

-- tables
-- Table: Appointment
CREATE TABLE Appointment (
    Appointment_ID int NOT NULL,
    Appointment_Date varchar(20) NOT NULL,
    patient_patient_id varchar(50) NOT NULL,
    Doctor_Doctor_Id varchar(50) NOT NULL,
    Transactions_Transaction_id varchar(50) NOT NULL,
    CONSTRAINT Appointment_pk PRIMARY KEY (Appointment_ID)
);

-- Table: Bills
CREATE TABLE Bills (
    Bill_id varchar(50) NOT NULL,
    Bill_amount int NOT NULL,
    Transactions_Transaction_id varchar(50) NOT NULL,
    CONSTRAINT Bills_pk PRIMARY KEY (Bill_id)
);

-- Table: Doctor
CREATE TABLE Doctor (
    Doctor_Id varchar(50) NOT NULL,
    Doctor_name varchar(50) NOT NULL,
    doctor_number int NOT NULL,
    Specialization varchar(50) NOT NULL,
    CONSTRAINT Doctor_pk PRIMARY KEY (Doctor_Id)
);

-- Table: Transactions
CREATE TABLE Transactions (
    Transaction_id varchar(50) NOT NULL,
    Bill_id varchar(50) NOT NULL,
    Treatement_treatement_id varchar(50) NOT NULL,
    CONSTRAINT Transactions_pk PRIMARY KEY (Transaction_id)
);

-- Table: Treatement
CREATE TABLE Treatement (
    treatement_id varchar(50) NOT NULL,
    treatement_name varchar(50) NOT NULL,
    CONSTRAINT Treatement_pk PRIMARY KEY (treatement_id)
);

-- Table: patient
CREATE TABLE patient (
    patient_id varchar(50) NOT NULL,
    patient_name varchar(25) NOT NULL,
    phn_number int NOT NULL,
    age int NOT NULL,
    Address varchar(30) NOT NULL,
    CONSTRAINT patient_pk PRIMARY KEY (patient_id)
);

-- foreign keys
-- Reference: Appointment_Doctor (table: Appointment)
ALTER TABLE Appointment ADD CONSTRAINT Appointment_Doctor FOREIGN KEY Appointment_Doctor (Doctor_Doctor_Id)
    REFERENCES Doctor (Doctor_Id);

-- Reference: Appointment_Transactions (table: Appointment)
ALTER TABLE Appointment ADD CONSTRAINT Appointment_Transactions FOREIGN KEY Appointment_Transactions (Transactions_Transaction_id)
    REFERENCES Transactions (Transaction_id);

-- Reference: Appointment_patient (table: Appointment)
ALTER TABLE Appointment ADD CONSTRAINT Appointment_patient FOREIGN KEY Appointment_patient (patient_patient_id)
    REFERENCES patient (patient_id);

-- Reference: Bills_Transactions (table: Bills)
ALTER TABLE Bills ADD CONSTRAINT Bills_Transactions FOREIGN KEY Bills_Transactions (Transactions_Transaction_id)
    REFERENCES Transactions (Transaction_id);

-- Reference: Transactions_Treatement (table: Transactions)
ALTER TABLE Transactions ADD CONSTRAINT Transactions_Treatement FOREIGN KEY Transactions_Treatement (Treatement_treatement_id)
    REFERENCES Treatement (treatement_id);

-- End of file.

