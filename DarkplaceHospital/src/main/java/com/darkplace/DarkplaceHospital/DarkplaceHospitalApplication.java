package com.darkplace.DarkplaceHospital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DarkplaceHospitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(DarkplaceHospitalApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PatientsRepository repository) {
		return (args) -> {
			// save a few customers
			String patientName = "Rick";
			String patientSecondName = "Dagless";
			String patientDOB = "1967-02-14";
			String patientMedicalInformation = "Myopia";
			Boolean patientIsDead = false;
			repository.save(
					new Patients(patientName, patientSecondName, patientDOB, patientMedicalInformation, patientIsDead));
		};
	}
}