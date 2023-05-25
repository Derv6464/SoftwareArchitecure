package com.darkplace.DarkplaceHospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DarkplaceHospitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(DarkplaceHospitalApplication.class, args);
	}
	
@Bean
	public CommandLineRunner demo(PatientsRepository repository) {
	  return (args) -> {
		// save a few customers
		String patientName = "Timmy";
		String patientSecondName = "Crenshaw";
		String patientDOB = "2022-01-01";
		String patientMedicalInformation = "blind";
		Boolean patientIsDead = true;
		repository.save(new Patients(patientName, patientSecondName, patientDOB, patientMedicalInformation, patientIsDead));
	  };
	}
  
  }