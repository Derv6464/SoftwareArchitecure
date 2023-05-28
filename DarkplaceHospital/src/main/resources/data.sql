DROP TABLE IF EXISTS PATIENTS;
DROP TABLE IF EXISTS USERS;

CREATE TABLE PATIENTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  SECONDNAME VARCHAR(250) NOT NULL,
  DOB DATE DEFAULT NULL,
  MEDICALINFORMATION VARCHAR(250) DEFAULT NULL,
  ISDEAD BOOLEAN DEFAULT FALSE,
  MEDICATION VARCHAR(250) DEFAULT NULL
);

CREATE TABLE USERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  USERNAME VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(20) NOT NULL
);



INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('admin', 'password');
INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('eanna', 'master');
INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('dervla', 'pico');
INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('dara', 'mullet');
INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('Wonton', 'myassisgrass04');
INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('Thechef', 'chicken');
INSERT INTO USERS(USERNAME, PASSWORD) VALUES ('Thetemp', 'screwdriver');

