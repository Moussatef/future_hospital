package com.hospital.interfaces;

import com.hospital.enumerations.InsuranceType;
import com.hospital.models.Patient;

import java.util.List;

public interface PatientInterface {
    public Patient addPatient();
    public InsuranceType insuranceType(int chose);
    public void showPatient(Patient p);
    public List<Patient> addListPatient();
    public void showListPatient(List<Patient> patients);
}
