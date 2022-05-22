package com.jdbc.model;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MemberTest {
    private final Member member = new Member("Mohamed","01063860720", LocalDate.of(2000, 2, 26),1,1);


    @org.junit.Test
    public void getName1() {
        assertEquals("Mohamed",member.getName());
    }
    @org.junit.Test
    public void getName2() {
        assertEquals("Mohamed Ayman Sallam",member.getName());
    }
    @org.junit.Test
    public void getName3() {
        assertEquals("Mohamed ",member.getName());
    }

    @org.junit.Test
    public void getPhone_no1() {
        assertEquals("01063860720",member.getPhone_no());
    }
    @org.junit.Test
    public void getPhone_no2() {
        assertEquals("",member.getPhone_no());
    }

    @org.junit.Test
    public void getDob() {
        assertEquals( LocalDate.of(2000, 2, 26),member.getDob());
    }

    @org.junit.Test
    public void getMSID() {
        assertEquals(1,member.getMSID());
    }

    @org.junit.Test
    public void getEID() {
        assertEquals(1,member.getEID());
    }

}