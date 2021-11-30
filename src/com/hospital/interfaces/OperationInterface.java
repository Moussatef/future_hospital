package com.hospital.interfaces;

import com.hospital.models.Operation;
import java.util.Optional;
import java.util.List;


public interface OperationInterface {

    public Optional<Operation> getOperationByRef(int ref);

    public void showOperation(List<Operation> operations);
    public Operation addOperation();


}
