package com.personal.restApi.restTestByRestAssured.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_no")
    private String mobile;

    public StudentModel() {
    }

    public StudentModel(Long id, String name, String address, String mobile) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public StudentModel(String name, String address, String mobile) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
