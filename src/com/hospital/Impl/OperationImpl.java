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
    public int percentageRAMED = 80;
    public int percentageCNSS = 70;
    public int percentageCNOPS = 100;
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
        System.out.print("Writ a description for this operation : ");
        op.setDescription(scanner.next());

        op.setDateTimeOperation(LocalDateTime.now());
        System.out.println("Date Operation : "+ op.getDateTimeOperation());
        System.out.print("Price of operation : ");
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
        if(!op.getPatient().getInsuranceType().toString().equals("RAMED"))
            op.getPatient().setPortefeuille(newPorteValue);
        else{
            float newPorteValueR = op.getPatient().getPortefeuille() -  ( (op.getPrice() * percentageRAMED ) / 100 );
            op.getPatient().setPortefeuille(newPorteValueR);
        }
        while (true){
            System.out.print("Hour start : ");
            int startTime = Integer.parseInt(scanner.next());
            System.out.print("Hour end : ");
            int endTime =  Integer.parseInt(scanner.next());
            if((startTime > 0 && startTime <= 12 && endTime > 0 && endTime <= 12) && startTime < endTime  ){
                TimeSlot timeSlot = new TimeSlot(startTime,endTime);
                op.setTimeShift(timeSlot);
                break;
            }

            System.out.println("You may have trouble entering time!!! Enter again ");

        }













        return op;
    }
}
