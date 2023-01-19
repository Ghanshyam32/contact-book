package com.example.firebase1;

public class modelClass {
    String name, number;

    modelClass() {

    }

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

    public modelClass(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
