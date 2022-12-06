package com.company.transfersystem.dto.response;

import javax.persistence.Column;
import java.io.Serializable;

public class CustomerResponse implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String address;

    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public CustomerResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CustomerResponse setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerResponse setAddress(String address) {
        this.address = address;
        return this;
    }
}
