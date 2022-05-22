package com.jdbc.dao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class EmployeeDaoTest {
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void getAllEmployees() throws SQLException {
        assertNotNull(employeeDao.getAllEmployees());
    }

    @Test
    public void getAllEmployeesNames() throws SQLException {
        assertNotNull(employeeDao.getAllEmployeesNames());
    }

    @Test
    public void getEmployee() throws SQLException {
        assertNotNull(employeeDao.getEmployee(1));
    }

}