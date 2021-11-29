package com.hospital.models;

public class Doctor extends Person{

	private String professionNumber;
	private TimeSlot shiftSlot;
	private double salary;
	
	public Doctor(String professionNumber,TimeSlot shiftSlot,double salary) {
		super();
		this.professionNumber = professionNumber;
		this.shiftSlot = shiftSlot;
		this.salary = salary;
	}

	public String getProfessionNumber() {
		return professionNumber;
	}

	public void setProfessionNumber(String professionNumber) {
		this.professionNumber = professionNumber;
	}

	public TimeSlot getShiftSlot() {
		return shiftSlot;
	}

	public void setShiftSlot(TimeSlot shiftSlot) {
		this.shiftSlot = shiftSlot;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Doctor [professionNumber=" + professionNumber + ", shiftSlot=" + shiftSlot + ", salary=" + salary + "]";
	}
	
}
