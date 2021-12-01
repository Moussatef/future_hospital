package com.hospital.interfaces;

import com.hospital.models.Doctor;
import com.hospital.models.Hospital;
import com.hospital.models.Operation;
import java.util.Optional;
import java.util.List;


public interface OperationInterface {

    public Optional<Operation> getOperationByRef(int ref);

    public void showOperations(List<Operation> operations);
    public void showOperation(Operation operations);
    public Operation addOperation(Hospital hospital, List<Doctor> doctors);



}
