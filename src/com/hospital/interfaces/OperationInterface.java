package com.hospital.interfaces;

import com.hospital.models.Doctor;
import com.hospital.models.Hospital;
import com.hospital.models.Operation;
import com.hospital.models.Transaction;

import java.util.Optional;
import java.util.List;


public interface OperationInterface {

    public Optional<Operation> getOperationByRef(String ref,List<Operation> operations);

    public void showOperations(List<Operation> operations);
    public void showOperation(Operation operations);
    public Operation addOperation(Hospital hospital, List<Doctor> doctors);
    public List<Operation> operationInProgress(List<Operation> operations);
    public List<Operation> operationSuccess(List<Operation> operations);
    public List<Operation> operationFailed(List<Operation> operations);




}
