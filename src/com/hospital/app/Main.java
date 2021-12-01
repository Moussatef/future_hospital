package com.hospital.app;

import com.hospital.Impl.PatientImpl;
import com.hospital.enumerations.InsuranceType;
import com.hospital.interfaces.PatientInterface;
import com.hospital.models.Patient;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\t\t\t\t\t-{ Welcome to Mohammed 6 Hospital }-\n\n");
/*
        PatientInterface p1 = new PatientImpl();
        p1.showPatient(p1.addPatient());

 */

        ControllerOperation controller = new ControllerOperation();
        controller.doOperation();






    }
}
