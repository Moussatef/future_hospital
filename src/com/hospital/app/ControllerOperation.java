package com.hospital.app;

import com.hospital.Impl.OperationImpl;
import com.hospital.Impl.PatientImpl;
import com.hospital.enumerations.StatuType;
import com.hospital.interfaces.OperationInterface;
import com.hospital.interfaces.PatientInterface;
import com.hospital.interfaces.TransactionIntrf;
import com.hospital.models.*;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ControllerOperation {
    Scanner scanner = new Scanner(System.in);
    private List<Operation> operations = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    public OperationInterface op = new OperationImpl();
    public TransactionIntrf transactionIntrf = new OperationImpl();
    private List<Transaction> transactions = new ArrayList<>();


    public List<Room> getRoomList(){
         List<Room> roomList = new ArrayList<>();
         roomList.add(new Room(1,1));
         roomList.add(new Room(2,1));
         roomList.add(new Room(3,1));
         roomList.add(new Room(4,1));
         roomList.add(new Room(5,1));
         roomList.add(new Room(6,1));
         roomList.add(new Room(7,1));

        return roomList;
    }
    public Hospital getHospital(){
        return new Hospital("MD6","Rabat",getDoctorList(),getRoomList());
    }


    public List<Nurse> getNurseList(){
        List<Nurse> nurseList = new ArrayList<>();
        nurseList.add(new Nurse("Fatima","Morasil","6928198","casa","NF°_6334371911",5_000));
        nurseList.add(new Nurse("Maryem","Erodj","6926879","casa","NF°_638798987911",5_000));
        nurseList.add(new Nurse("Khadija","Doelsj","69297868","safi","NF°_636578911",5_000));
        nurseList.add(new Nurse("Mohammed","Dolafi","692436","fes","NF°_63876911",5_000));
        nurseList.add(new Nurse("Adil","Samoliy","692089868","tanger","NF°_6386871911",5_000));
        nurseList.add(new Nurse("Yassine","Derasi","6926546","akader","NF°_6387887911",5_000));
        nurseList.add(new Nurse("Rafik","Cokali","69247598","dakhla","NF°_63879878911",5_000));
        nurseList.add(new Nurse("Amal","Modirasi","69536498","casa","NF°_6387808871",5_000));
        nurseList.add(new Nurse("Laila","Nozry","699868758","casa","NF°_63875571",5_000));

        return nurseList;
    }

    public List<Doctor> getDoctorList(){
        List<Nurse> nurses = getNurseList();
        List<Nurse> nurseList1 = new ArrayList<>();
        nurseList1.add(nurses.get(0));
        nurseList1.add(nurses.get(1));
        nurseList1.add(nurses.get(2));

        List<Nurse> nurseList2 = new ArrayList<>();
        nurseList2.add(nurses.get(3));
        nurseList2.add(nurses.get(4));
        nurseList2.add(nurses.get(5));

        List<Nurse> nurseList3 = new ArrayList<>();
        nurseList3.add(nurses.get(6));
        nurseList3.add(nurses.get(7));
        nurseList3.add(nurses.get(8));


        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(new Doctor("Hamza","Jebran","692698946","Casa","NM_986298697",new TimeSlot(8,12),50_000,nurseList2));
        doctorList.add(new Doctor("Yassine","Bissaoui","692698656","Marrakeche","NM_986009697",new TimeSlot(8,23),10_000,nurseList3));
        doctorList.add(new Doctor("OTHMAN","MOUSSATEF","637274172","SAFI","NM_000978",new TimeSlot(10,23),100_000,nurseList1));

        return doctorList;
    }
    public void status(){
        System.out.println("________________________________Status Type________________________________");
        System.out.println("1- "+StatuType.DONE_SUCCESSFULLY);
        System.out.println("2- "+StatuType.FAILED);
        System.out.println("3- return back");
        System.out.println("________________________________****________________________________");

    }
    public void menu(){
        System.out.println("________________________________MENU________________________________");
        System.out.println("1- Add operation");
        System.out.println("2- View operations ");
        System.out.println("3- View List Doctors");
        System.out.println("4- View List Patients");
        System.out.println("X- View List rooms");
        System.out.println("6- Transactions");
        System.out.println("7- Change operation status ");
        System.out.println("8- Exit");
        System.out.println("________________________________****________________________________");
    }
    public void menuOperations(){
        System.out.println("___________________________MENU Operation____________________________");
        System.out.println("1- View operations on Progress ");
        System.out.println("2- View operations Terminated with success");
        System.out.println("3- View operations Failed");
        System.out.println("4- Return");
        System.out.println("________________________________****________________________________");
    }
    public void exeChose(){
        int chose =0;
        do {
            System.out.println("\n\t\t\t\t\t-{ Welcome to Mohamed 6 Hospital }-\n\n");
            menu();
            System.out.print("Enter your chose : ");
            try {


            chose = Integer.parseInt(scanner.next());
            switch (chose){
                case 1 : doOperation();
                break;
                case 2 :
                    System.out.println("Operations");
                    int ch = 0;
                    do{
                        menuOperations();
                        System.out.print("Enter your chose : ");
                         ch = Integer.parseInt(scanner.next());
                         switch (ch){
                             case 1 :
                                 op.showOperations(op.operationInProgress(operations));
                                 break;
                             case 2 :
                                 op.showOperations(op.operationSuccess(operations));
                                 break;
                             case 3 :
                                 op.showOperations(op.operationFailed(operations));
                                 break;
                             case 4 :
                                 System.out.println("back to menu ");
                                 break;
                             default:
                                 System.out.println("This chose not in menu !! try again");
                                 break;
                         }
                    }while (ch != 4);

                    break;
                case 3   :
                    System.out.println("3- View List Doctors");
                    break;
                case 4 :
                    System.out.println("4- View List patient");
                    PatientInterface p = new PatientImpl();
                    p.showListPatient(patients);
                    break;
                case 5 :
                    System.out.println("5- View List rooms");
                    break;
                case 6 : System.out.println(" Transactions ");
                        for (Transaction tr : transactions)
                            System.out.println(tr.toString());
                    break;
                case 7 :
                        System.out.println("Change Operation status ");
                        System.out.print("Operation reference : ");
                        scanner.nextLine();
                        String ref = scanner.nextLine();
                        Operation operationfind = op.getOperationByRef(ref,this.operations);


                         System.out.println(operationfind.getStatu());
                    break;
                case 8 : System.out.println("{{{{# See you soon #}}}} ");
                    break;

                default:
                    System.out.println("This chose not in menu !! try again ");
                    break;

            }
            }catch (Exception e){
                System.out.println("Errer : "+e.getMessage());
            }
        }while (chose !=8);
    }
    public void doOperation(){

        Operation operation = op.addOperation(getHospital(),getDoctorList());

        operation.setStatu(StatuType.IN_PROGRESS);
        this.operations.add(operation);
        this.patients.add(operation.getPatient());
        this.transactions.add(transactionIntrf.addTransaction(operation));

        System.out.println("________________________________Operation Information________________________________");
        op.showOperation(operation);


    }


}
