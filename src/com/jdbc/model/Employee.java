package com.jdbc.model;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {
    private int EID;
    private String name;
    private String address;
    private String phone_no;
    private LocalDate dob;
    private String role;
    private String salary;

    public Employee(String name, String address, String phone_no, LocalDate dob, String role, String salary) {
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
        this.dob = dob;
        this.role = role;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
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

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
