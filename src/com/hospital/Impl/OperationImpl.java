package com.hospital.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.hospital.interfaces.OperationInterface;
import com.hospital.interfaces.PatientInterface;
import com.hospital.models.Hospital;
import com.hospital.models.Operation;
import com.hospital.models.Patient;
import com.hospital.models.TimeSlot;

public class OperationImpl implements OperationInterface{
    Scanner scanner = new Scanner(System.in);

    @Override
    public Optional<Operation> getOperationByRef(int ref) {
        return Optional.empty();
    }

    @Override
    public void showOperation(List<Operation> operations) {

    }

    @Override
    public Operation addOperation(Hospital hospital) {
        PatientInterface p1 = new PatientImpl();
        Operation op = new Operation();
        op.setPatient(p1.addPatient());
        op.setDescription(scanner.next());
        op.setDateTimeOperation(LocalDateTime.now());
        op.setPrice(Float.parseFloat(scanner.next()));
        while(true){
            if(op.getPatient().getPortefeuille() < op.getPrice()){
                System.out.println("warning !!!! the portefeuille is not enough !! ");
                System.out.print("Add enough money in yor portefeuille : ");
                float addMoney = op.getPatient().getPortefeuille() + Float.parseFloat(scanner.next());
                op.getPatient().setPortefeuille(addMoney);
                continue;
            }
            break;

        }
        float oldPorteValue = op.getPatient().getPortefeuille();
        float newPorteValue = op.getPatient().getPortefeuille() - op.getPrice();
        op.getPatient().setPortefeuille(newPorteValue);
        int startTime = Integer.parseInt(scanner.next());
        int endTime =  Integer.parseInt(scanner.next());
        TimeSlot timeSlot = new TimeSlot(startTime,endTime);
        op.setTimeShift(timeSlot);










        return null;
    }
}
