package com.hospital.models;

public class Nurse extends Person {
    private String professionNumber;
    private double salary;

    public Nurse(){}
    public Nurse(String firstname,String lastname,String phone,String address,String professionNumber,double salary){
        super(firstname,lastname,phone,address);
        this.setProfessionNumber(professionNumber);

        this.setSalary(salary);
    }

    public String getProfessionNumber() {
        return professionNumber;
    }

    public void setProfessionNumber(String professionNumber) {
        this.professionNumber = professionNumber;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
