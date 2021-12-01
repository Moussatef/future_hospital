package com.hospital.app;

import com.hospital.Impl.OperationImpl;
import com.hospital.interfaces.OperationInterface;
import com.hospital.models.*;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.ArrayList;
import java.util.List;

public class ControllerOperation {



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
        doctorList.add(new Doctor("Yassine","Bissaoui","692698656","Marrakeche","NM°_986298697",new TimeSlot(8,12),50_000,nurseList2));
        doctorList.add(new Doctor("Yassine","Bissaoui","692698656","Marrakeche","NM°_986009697",new TimeSlot(8,12),10_000,nurseList3));
        doctorList.add(new Doctor("OTHMAN","MOUSSATEF","637274172","SAFI","NM°_000978",new TimeSlot(10,12),100_000,nurseList1));

        return doctorList;
    }
    public void doOperation(){
        OperationInterface op = new OperationImpl();
        op.addOperation(getHospital(),getDoctorList());

    }


}
