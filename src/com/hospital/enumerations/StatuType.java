package com.hospital.enumerations;

public enum StatuType {
    IN_PROGRESS("IN_PROGRESS"),
    DONE_SUCCESSFULLY("DONE_SUCCESSFULLY"),
    FAILED("FAILED");

    private String value;

    StatuType(String value){
        this.setValue(value);}


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
