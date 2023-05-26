package com.darkplace.DarkplaceHospital;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String USERNAME;
    private String PASSWORD;

    protected Users() {
    }

    public Users(String USERNAME, String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d|\tUsername: '%s'|\tPassword: '%s'\n",
                ID, USERNAME, PASSWORD);
    }

    public Long getId() {
        return ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}