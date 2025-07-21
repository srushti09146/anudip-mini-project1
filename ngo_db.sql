CREATE DATABASE ngo_db;
USE ngo_db;

-- Donor table
CREATE TABLE donors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    amount_donated DECIMAL(10,2)
);

-- Volunteer table
CREATE TABLE volunteers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    contact VARCHAR(20),
    area_of_work VARCHAR(100)
);
