-- Création de la base de données mpatients_db
CREATE DATABASE IF NOT EXISTS mpatients_db;

-- Utilisation de la base de données mpatients_db
USE mpatients_db;

-- Création de la table patients
CREATE TABLE IF NOT EXISTS patients (
    patient_id INT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    date_of_birth DATE,
    gender CHAR(1),
    address VARCHAR(255),
    phone_number VARCHAR(20)
);

-- Création de la table users
CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);

-- INSERT statements for test data
INSERT IGNORE INTO patients (patient_id, firstname, lastname, date_of_birth, gender, address, phone_number)
VALUES (1, 'Test', 'TestNone', '1966-12-31', 'F', '1 Brookside St', '100-222-3333');

INSERT IGNORE INTO patients (patient_id, firstname, lastname, date_of_birth, gender, address, phone_number)
VALUES (2, 'Test', 'TestBorderline', '1945-06-24', 'M', '2 High St ', '200-333-4444');

INSERT IGNORE INTO patients (patient_id, firstname, lastname, date_of_birth, gender, address, phone_number)
VALUES (3, 'Test', 'TestInDanger', '2004-06-18', 'M', '3 Club Road', '300-444-5555');

INSERT IGNORE INTO patients (patient_id, firstname, lastname, date_of_birth, gender, address, phone_number)
VALUES (4, 'Test', 'TestEarlyOnset', '2002-06-28', 'F', '4 Valley Dr', '400-555-6666');

-- Insertion des données utilisateurs avec les mots de passe cryptés
INSERT IGNORE INTO users (user_id, username, password, role) 
VALUES (1, 'user', '$2a$10$TGGYvNDuajMH7TWnL1i0uusj7/8eJdPq6wcsR36HiOSKSVqQ5JtOS', 'USER');

INSERT IGNORE INTO users (user_id, username, password, role) 
VALUES (2, 'user2', '$2a$10$KQD/WM7FLYsINHet9HNqY.oihKJhgsy.dtwZ3pcJGu11DN1EcA.cO', 'USER');


