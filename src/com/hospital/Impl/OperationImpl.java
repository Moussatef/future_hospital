package com.hospital.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.hospital.interfaces.OperationInterface;
import com.hospital.interfaces.PatientInterface;
import com.hospital.models.*;

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
    public void showOperations(List<Operation> operations) {

    }
    @Override
    public void showOperation(Operation operation) {
        float rembourse = 0;
        if (operation.getPatient().getInsuranceType().toString().equals("CNSS"))
            rembourse = (operation.getPrice() * percentageCNSS ) / 100;

        if(operation.getPatient().getInsuranceType().toString().equals("CNOPS"))
            rembourse = operation.getPrice();


        System.out.println("Code Operation    : "+operation.getCodeOperation());
        System.out.println("Description       : "+operation.getDescription()+"\t Date Operation    : "+operation.getDateTimeOperation());
        System.out.println("Price             : "+operation.getPrice() );
        System.out.println("Profession Number : "+operation.getDoctor().getProfessionNumber() + "\t Doctor Name       : "+operation.getDoctor().getLastname()+operation.getDoctor().getFirstname());
        System.out.println("Affiliation Number: "+operation.getPatient().getAffiliationNumber()+"\t Patient Name      : "+operation.getPatient().getLastname().toUpperCase() + operation.getPatient().getFirstname().toUpperCase());
        System.out.println("InsuranceType     : "+operation.getPatient().getInsuranceType());
        System.out.println("Insurance reimbursed: "+rembourse +"DHs");
        System.out.println("-----------------------------------------------------------------------------------");

    }

    public Doctor getDoctor(Long ID,List<Doctor> d){
        for (Doctor doctor:d){
            if (doctor.getId().equals(ID)){
                return doctor;
            }
        }
        return null;


    }

    public void writDoctor(Doctor d){
        System.out.println("ID                : "+d.getId());
        System.out.println("profession Number : "+d.getProfessionNumber());
        System.out.println("Name              : "+d.getFirstname().toUpperCase() + d.getLastname().toUpperCase() );
        System.out.println("ShiftSlot         : "+d.getShiftSlot());
        System.out.println("Phone Number      : "+d.getPhone());
        System.out.println("Address           : "+d.getAddress());
        System.out.println("------------------------------------------");
    }



    @Override
    public Operation addOperation(Hospital hospital,List<Doctor> doctors) {
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
        List<Doctor> doctorList = new ArrayList<>();

        for (Doctor d : doctors){
            if(d.getShiftSlot().getStartTime() > op.getDateTimeOperation().getHour() && d.getShiftSlot().getEndTime() < op.getDateTimeOperation().getHour()){
                writDoctor(d);
                doctorList.add(d);
            }
        }

        System.out.println("chose doctor from this list (write ID) : ");






        return op;
    }
}
