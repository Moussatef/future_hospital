package com.hospital.models;

import java.time.LocalDate;
import java.util.Date;

import com.hospital.enumerations.InsuranceType;

public class Patient extends Person{

	private LocalDate hospitalEntryDate;
	private String affiliationNumber;
	private InsuranceType insuranceType;
	private float portefeuille;

	public Patient(){}
	public Patient(LocalDate hospitalEntryDate,String affiliationNumber,InsuranceType insuranceType,float portefeuille) {
		super();
		this.hospitalEntryDate = hospitalEntryDate;
		this.affiliationNumber = affiliationNumber;
		this.insuranceType = insuranceType;
		this.portefeuille = portefeuille;
	}

	public LocalDate getHospitalEntryDate() {
		return hospitalEntryDate;
	}

	public void setHospitalEntryDate(LocalDate hospitalEntryDate) {
		this.hospitalEntryDate = hospitalEntryDate;
	}

	public String getAffiliationNumber() {
		return affiliationNumber;
	}

	public void setAffiliationNumber(String affiliationNumber) {
		this.affiliationNumber = affiliationNumber;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	@Override
	public String toString() {
		return "Patient [hospitalEntryDate=" + hospitalEntryDate + ", affiliationNumber=" + affiliationNumber
				+ ", insuranceType=" + insuranceType + "]";
	}

	public float getPortefeuille() {
		return portefeuille;
	}

	public void setPortefeuille(float portefeuille) {
		this.portefeuille = portefeuille;
	}
}
