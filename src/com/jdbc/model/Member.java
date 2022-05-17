package com.jdbc.model;

import java.time.LocalDate;

public class Member {
    /*
    * create table if not exists `Member`(
    `MID` int auto_increment,
    name varchar(256) not null,
    phone_no int not null,
    dob DATE not null,
    MSID int,
    EID int,
    primary key (MID),
    foreign key (MSID) references `Membership type`(MSID),
    foreign key (EID) references Employee(EID)
);*/
    private int MID;
    private String name;
    private int phone_no;
    private LocalDate dob;
    private int MSID;
    private int EID;

    //! notice the empty constructor

    public Member(String name, int phone_no, LocalDate dob, int MSID, int EID) {
        this.name = name;
        this.phone_no = phone_no;
        this.dob = dob;
        this.MSID = MSID;
        this.EID = EID;
    }

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getMSID() {
        return MSID;
    }

    public void setMSID(int MSID) {
        this.MSID = MSID;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }
}
