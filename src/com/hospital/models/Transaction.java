package com.hospital.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String reference ;
    private LocalDateTime dateTimeTransaction ;
    private float total;
    private String refOperation;
    private String namePatient;


    public Transaction(){

    }
    public Transaction(float total,String refOperation,String namePatient ){
        this.reference = "TR_"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"))+"_"+ (Math.random() *(100));
        this.dateTimeTransaction = LocalDateTime.now();
        this.total=total;
        this.refOperation=refOperation;
        this.namePatient=namePatient;
    }

    public LocalDateTime getDateTimeTransaction() {
        return dateTimeTransaction;
    }

    public void setDateTimeTransaction(LocalDateTime dateTimeTransaction) {
        this.dateTimeTransaction = dateTimeTransaction;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRefOperation() {
        return refOperation;
    }

    public void setRefOperation(String refOperation) {
        this.refOperation = refOperation;
    }


    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    @Override
    public String toString() {
        return "Transaction{ \n" +
                "* Reference : " + reference + '\n' +
                "* dateTimeTransaction : " + dateTimeTransaction.format(DateTimeFormatter.ofPattern("yyyy-MM-dd- hh:mm"))+ '\n' +
                "* TOTAL =" + total + '\n' +
                "* Operation Reference : " + refOperation + '\n' +
                "* Patient name : " + namePatient  +
                " }";
    }
}
