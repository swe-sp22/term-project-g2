package com.jdbc.dao;

import com.jdbc.model.Member;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MemberDaoImplementationTest {
    private final MemberDaoImplementation memberDaoImplementation = new MemberDaoImplementation();
    private final Member member = new Member();

    @Test
    public void getMemberName1() throws SQLException {
        assertEquals("Mohamed",memberDaoImplementation.getMember(1).getName());
    }
    @Test
    public void getMemberName2() throws SQLException {
        assertEquals("Sallam",memberDaoImplementation.getMember(1).getName());
    }
    @Test
    public void getMember3() throws SQLException {
        assertEquals("",memberDaoImplementation.getMember(1).getName());
    }

}