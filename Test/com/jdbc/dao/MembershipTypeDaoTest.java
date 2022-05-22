package com.jdbc.dao;

import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MembershipTypeDaoTest {
    private final MembershipTypeDao membershipTypeDao = new MembershipTypeDao();
    @Test
    public void getAllMembershipTypes1() throws SQLException {
        List<String> list = new ArrayList<>();
        list.add("1 month");
        list.add("3 months");
        list.add("6 months");
        assertEquals(list,membershipTypeDao.getAllMembershipTypes());
    }
    @Test
    public void getAllMembershipTypes2() throws SQLException {
        List<String> list = new ArrayList<>();
        list.add("1 month");
        list.add("3 months");
        assertEquals(list,membershipTypeDao.getAllMembershipTypes());
    }
    @Test
    public void getAllMembershipTypes3() throws SQLException {
        List<String> list = new ArrayList<>();
        list.add("123");
        assertEquals(list,membershipTypeDao.getAllMembershipTypes());
    }

    @Test
    public void getMembershipTypeId1() throws SQLException {
        assertEquals(2,membershipTypeDao.getMembershipTypeId("3 months"));
    }
    @Test
    public void getMembershipTypeId2() throws SQLException {
        assertEquals(1,membershipTypeDao.getMembershipTypeId("3 months"));
    }
    @Test
    public void getMembershipTypeId3() throws SQLException {
        assertEquals(10,membershipTypeDao.getMembershipTypeId("6 months"));
    }
}