DROP TABLE IF EXISTS PATIENTS;

CREATE TABLE PATIENTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  SECONDNAME VARCHAR(250) NOT NULL,
  DOB DATE DEFAULT NULL,
  MEDICALINFORMATION VARCHAR(250) DEFAULT NULL,
  ISDEAD BOOLEAN DEFAULT FALSE
);
