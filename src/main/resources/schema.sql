DROP TABLE IF EXISTS Customer;

DROP TABLE IF EXISTS Customer_Wallet;

DROP TABLE IF EXISTS Biller;

DROP TABLE IF EXISTS Biller_Wallet;

DROP TABLE IF EXISTS Biller_Data;

DROP TABLE IF EXISTS Customer_Transaction;
  
CREATE TABLE Customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(100) NOT NULL
);

CREATE TABLE Customer_Wallet (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  cust_id INT NOT NULL,
  amount INT NOT NULL
);



CREATE TABLE Biller (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE Biller_Wallet (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  biller_id INT NOT NULL,
  amount INT NOT NULL
);

CREATE TABLE Biller_Data (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  biller_id INT NOT NULL,
  cust_id INT NOT NULL,
  amount_to_paid INT NOT NULL, 	
  month_year VARCHAR(255) NOT NULL
);

  
CREATE TABLE Customer_Transaction  (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  cust_id INT NOT NULL,
  amount INT NOT NULL,
  type VARCHAR(255) NOT NULL,
  biller_id INT,
  payment_mthd VARCHAR(255)
);

