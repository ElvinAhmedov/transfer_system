package com.company.transfersystem.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="SURNAME")
    private String surname;
    @Column(name="FIN")
    private String fin;
    @Column(name="FATHER_NAME")
    private String fatherName;
    @Column(name="VOEN")
    private String voen;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="ACTIVE")
    private Byte active;
    @Column(name="AGE")
    private Integer age;

    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_type", referencedColumnName = "id")
    private CustomerTypeEntity customerType;

    public Long getId() {
        return id;
    }

    public CustomerEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CustomerEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getFin() {
        return fin;
    }

    public CustomerEntity setFin(String fin) {
        this.fin = fin;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public CustomerEntity setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getVoen() {
        return voen;
    }

    public CustomerEntity setVoen(String voen) {
        this.voen = voen;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public Byte getActive() {
        return active;
    }

    public CustomerEntity setActive(Byte active) {
        this.active = active;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public CustomerEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public CustomerEntity setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public CustomerTypeEntity getCustomerType() {
        return customerType;
    }

    public CustomerEntity setCustomerType(CustomerTypeEntity customerType) {
        this.customerType = customerType;
        return this;
    }
}
