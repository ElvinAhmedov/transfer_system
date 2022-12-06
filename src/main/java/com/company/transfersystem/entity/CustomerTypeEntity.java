package com.company.transfersystem.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER_TYPE")
public class CustomerTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name="ACTIVE")
    private Integer active;

    public Integer getId() {
        return id;
    }

    public CustomerTypeEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerTypeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public CustomerTypeEntity setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public Integer getActive() {
        return active;
    }

    public CustomerTypeEntity setActive(Integer active) {
        this.active = active;
        return this;
    }
}
