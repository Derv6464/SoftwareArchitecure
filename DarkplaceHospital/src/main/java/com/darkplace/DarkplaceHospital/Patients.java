package com.darkplace.DarkplaceHospital;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patients {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID;
  private String NAME;
  private String SECONDNAME;
  private Date DOB;
  private String MEDICALINFORMATION;
  private Boolean ISDEAD;
  private String MEDICATION;

  protected Patients() {
  }

  public Patients(String NAME, String SECONDNAME, String DOB, String MEDICALINFORMATION, Boolean ISDEAD, String MEDICATION) {
    this.NAME = NAME;
    this.SECONDNAME = SECONDNAME;
    this.DOB = convertToDate(DOB);
    this.MEDICALINFORMATION = MEDICALINFORMATION;
    this.ISDEAD = ISDEAD;
    this.MEDICATION = MEDICATION;
  }

  @Override
  public String toString() {
    return String.format(
        "%d|\t'%s'|\t'%s'|\t'%s'|\t'%s'|\t'%s'|\t'%s'\n",
        ID, NAME, SECONDNAME, DOB, MEDICALINFORMATION, ISDEAD,MEDICATION);
  }

  private Date convertToDate(String dateString) {
    LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    return Date.valueOf(localDate);
  }

  public Long getId() {
    return ID;
  }

  public String getNAME() {
    return NAME;
  }

  public String getSECONDNAME() {
    return SECONDNAME;
  }

  public Date getDOB() {
    return DOB;
  }

  public String getMEDICALINFORMATION() {
    return MEDICALINFORMATION;
  }

  public Boolean getISDEAD() {
    return ISDEAD;
  }

  public String getMEDICATION() {
    return MEDICATION;
  }
}