package com.hospital.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.hospital.enumerations.StatuType;
import com.hospital.interfaces.OperationInterface;
import com.hospital.interfaces.PatientInterface;
import com.hospital.models.*;

public class OperationImpl implements OperationInterface{
    public int percentageRAMED = 80;
    public int percentageCNSS = 70;
    public int percentageCNOPS = 100;
    Scanner scanner = new Scanner(System.in);

    @Override
    public Optional<Operation> getOperationByRef(String ref,List<Operation> operations) {
        for (Operation op:operations){
            if(op.getCodeOperation().equals(ref)){
                return Optional.of(op);
            }
        }
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
        System.out.println("Description       : "+operation.getDescription()+"\t Date Operation    : "+operation.getDateTimeOperation().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
        System.out.println("Price             : "+operation.getPrice() );
        System.out.println("________________________________Doctor Information________________________________");
        System.out.println("Profession Number : "+operation.getDoctor().getProfessionNumber() + "\t Doctor Name       : "+operation.getDoctor().getLastname()+" "+operation.getDoctor().getFirstname());
        System.out.println("__________________________________________________________________________________");
        System.out.println("________________________________Patient Information_______________________________");
        System.out.println("Affiliation Number: "+operation.getPatient().getAffiliationNumber()+"\t Patient Name      : "+operation.getPatient().getLastname().toUpperCase() +" "+ operation.getPatient().getFirstname().toUpperCase());
        System.out.println("InsuranceType     : "+operation.getPatient().getInsuranceType());
        System.out.println("Insurance reimbursed: "+rembourse +"DHs");
        System.out.println("----------------------------------------------------------------------------------");

    }

    public Doctor getDoctor(String ID,List<Doctor> d){
        for (Doctor doctor:d){
            if (doctor.getProfessionNumber().equals(ID)){
                return doctor;
            }
        }
        return null;
    }

    public void writDoctor(Doctor d){
        System.out.println("profession Number : "+d.getProfessionNumber());
        System.out.println("Name              : "+d.getFirstname().toUpperCase() +" "+  d.getLastname().toUpperCase() );
        System.out.println("ShiftSlot         : From "+d.getShiftSlot().getStartTime() +" -TO- "+d.getShiftSlot().getEndTime());
        System.out.println("Phone Number      : "+d.getPhone());
        System.out.println("Address           : "+d.getAddress());
        System.out.println("--------------------------------------------------------------------");
    }

    @Override
    public Operation addOperation(Hospital hospital,List<Doctor> doctors) {
        List<Doctor> doctorList = new ArrayList<>();

        PatientInterface p1 = new PatientImpl();
        Operation op = new Operation();
        op.setDateTimeOperation(LocalDateTime.now());
        op.setStatu(StatuType.IN_PROGRESS);
        System.out.println("_________________________Doctors Available__________________________");
        for (Doctor d : doctors){
            if(d.getShiftSlot().getStartTime() < op.getDateTimeOperation().getHour() && d.getShiftSlot().getEndTime() > op.getDateTimeOperation().getHour()){
                writDoctor(d);
                doctorList.add(d);
            }
        }
        op.setCodeOperation();
        op.setPatient(p1.addPatient());
        System.out.print("Writ a description for this operation : ");
        op.setDescription(scanner.nextLine());

        System.out.println("Date Operation : "+ op.getDateTimeOperation().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
        System.out.print("Price of operation : ");
        op.setPrice(Float.parseFloat(scanner.nextLine()));
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
            System.out.print("chose doctor from list Doctors (write profession Number ) : ");
            String ID_doctor = scanner.next();
            if (getDoctor(ID_doctor,doctorList)!=null){
                op.setDoctor(getDoctor(ID_doctor,doctorList));
                break;

            }
            System.out.println("This profession Number  : "+ID_doctor+" not in list Doctors svp try again !");
        }

        return op;
    }
}
