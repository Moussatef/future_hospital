package com.hospital.interfaces;

import com.hospital.models.Operation;
import com.hospital.models.Transaction;

public interface TransactionIntrf {
    public Transaction addTransaction(Operation operation);
}
