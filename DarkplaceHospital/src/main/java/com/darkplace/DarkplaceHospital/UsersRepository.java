package com.darkplace.DarkplaceHospital;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    List<Users> findByUSERNAME(String USERNAME);

    Users findById(long ID);
}
