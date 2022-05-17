package com.jdbc.model;

public class Member {

    int member_id;
    String member_name;
    String member_address;


    public Member() {}
    public Member(String emp_name, String emp_address)
    {
        this.member_name = emp_name;
        this.member_address = emp_address;
    }
    public int getMember_id()
    {
        return member_id;
    }
    public void setMember_id(int member_id)
    {
        this.member_id = member_id;
    }
    public String getMember_name()
    {
        return member_name;
    }
    public void setMember_name(String member_name)
    {
        this.member_name = member_name;
    }
    public String getMember_address()
    {
        return member_address;
    }

    public void setMember_address(String member_address)
    {
        this.member_address = member_address;
    }

}
