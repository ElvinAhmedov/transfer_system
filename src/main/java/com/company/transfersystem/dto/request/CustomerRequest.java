package com.company.transfersystem.dto.request;

import java.io.Serializable;

public class CustomerRequest implements Serializable {

    private String name;
    private String surname;
    private String fatherName;
    private String fin;
    private String address;
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public CustomerRequest setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getFin() {
        return fin;
    }

    public CustomerRequest setFin(String fin) {
        this.fin = fin;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerRequest setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public CustomerRequest setAge(Integer age) {
        this.age = age;
        return this;
    }
}
