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
			String[] meds = { "Morphine", "Peniectomies", "Oxycotion", "Adderal", "Xanax", "Paracetamol", "Sudafed",
					"Exputex", "Zertec" };
			Patients rick = new Patients("Rick", "Dagless", "1967-02-14", "Myopia", false,
					meds[(int) (Math.random() * meds.length)]);
			Patients liz = new Patients("Liz", "Asher", "1968-01-09", "Visions,Lycanthropy", true,
					meds[(int) (Math.random() * meds.length)]);
			Patients lucien = new Patients("Lucien", "Sanchez", "1975-11-17", "Lycanthropy", false,
					meds[(int) (Math.random() * meds.length)]);
			Patients thornton = new Patients("Thornton", "Reed", "1964-04-01", "Phones", false,
					meds[(int) (Math.random() * meds.length)]);
			Patients temp = new Patients("the", "temp", "1977-09-24", "screwdrivers in chest", true,
					meds[(int) (Math.random() * meds.length)]);
			repository.save(rick);
			repository.save(liz);
			repository.save(lucien);
			repository.save(thornton);
			repository.save(temp);
		};
	}
}