package com.darkplace.DarkplaceHospital;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatientsRepository extends CrudRepository<Patients, Long> {

  List<Patients> findBySECONDNAME(String SECONDNAME);

  Patients findById(long ID);

}