package com.jdbc.model;

import java.time.LocalDate;

public class Member {

    private int MID;
    private String name;
    private String phone_no;
    private LocalDate dob;
    private int MSID;
    private int EID;
    private String MembershipDuration;

    //! notice the empty constructor

    public Member(String name, String phone_no, LocalDate dob, int MSID, int EID) {
        this.name = name;
        this.phone_no = phone_no;
        this.dob = dob;
        this.MSID = MSID;
        this.EID = EID;
    }

    public Member() {
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

    public String getMembershipDuration() {
        return MembershipDuration;
    }

    public void setMembershipDuration(String MembershipDuration) {
        this.MembershipDuration = MembershipDuration;
    }
}
