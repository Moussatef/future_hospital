package com.hospital.models;

import java.time.LocalDateTime;

public class Transaction {


    private LocalDateTime dateTimeTransaction ;
    private float total;
    private Operation operation;

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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
