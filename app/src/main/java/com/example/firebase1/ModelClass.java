package com.example.firebase1;

public class ModelClass {
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ModelClass(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
