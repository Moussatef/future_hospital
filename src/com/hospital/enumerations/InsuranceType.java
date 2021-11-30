package com.hospital.enumerations;

public enum InsuranceType {

    CNSS("CNSS"),
    RAMED("RAMED"),
    CNOPS("CNOPS"),
    NONE("NONE");

    private String value;

    InsuranceType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

}
