package com.hospital.app;

import com.hospital.Impl.PatientImpl;
import com.hospital.enumerations.InsuranceType;
import com.hospital.interfaces.PatientInterface;
import com.hospital.models.Patient;

public class Main {
    public static void main(String[] args) {

        System.out.println("ok");

        PatientInterface p1 = new PatientImpl();

        Patient p = p1.addPatient();
        p1.showPatient(p);




    }
}
