package com.hospital.models;

import java.util.List;

public class Doctor extends Person{

	private String professionNumber;
	private TimeSlot shiftSlot;
	private double salary;
	private List<Nurse> nurses ;
	
	public Doctor(String professionNumber,TimeSlot shiftSlot,double salary,List<Nurse> nurses) {
		super();
		this.setProfessionNumber(professionNumber);
		this.setShiftSlot(shiftSlot);
		this.setSalary(salary);
		this.setNurses(nurses);
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
		return "Doctor [professionNumber=" + getProfessionNumber() + ", shiftSlot=" + getShiftSlot() + ", salary=" + getSalary() + "]";
	}

	public List<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}
}
