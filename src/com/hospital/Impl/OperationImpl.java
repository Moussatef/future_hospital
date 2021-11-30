package com.hospital.Impl;

import java.util.List;
import java.util.Optional;

import com.hospital.interfaces.OperationInterface;
import com.hospital.models.Operation;

public class OperationImpl implements OperationInterface{

    @Override
    public Optional<Operation> getOperationByRef(int ref) {
        return Optional.empty();
    }

    @Override
    public void showOperation(List<Operation> operations) {

    }

    @Override
    public Operation addOperation() {



        return null;
    }
}
