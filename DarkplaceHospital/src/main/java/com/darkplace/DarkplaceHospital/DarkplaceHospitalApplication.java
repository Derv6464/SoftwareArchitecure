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
			Patients rick = new Patients("Rick", "Dagless", "1967-02-14", "Myopia",false);
			Patients liz = new Patients("Liz", "Asher", "1968-01-09", "Visions,Lycanthropy",true);
			Patients lucien = new Patients("Lucien", "Sanchez", "1975-11-17", "Lycanthropy",false);
			Patients thornton = new Patients("Thornton", "Reed", "1964-04-01", "Phones",false);
			Patients temp = new Patients("the", "temp", "1977-09-24", "screwdrivers in chest",true);
			repository.save(rick);
			repository.save(liz);
			repository.save(lucien);
			repository.save(thornton);
			repository.save(temp);
		};
	}
}