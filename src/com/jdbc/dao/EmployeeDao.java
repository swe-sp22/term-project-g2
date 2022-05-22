package com.jdbc.dao;

import com.jdbc.model.Employee;
import com.jdbc.model.Member;
import com.jdbc.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    static Connection con = DatabaseConnection.getConnection();
    public int addEmployee(Employee newEmployee) throws SQLException{
        String query = "insert into employee(name, address, phone_no, dob, role, salary) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, newEmployee.getName());
        stmt.setString(2, newEmployee.getAddress());
        stmt.setString(3, newEmployee.getPhone_no());
        stmt.setDate(4, Date.valueOf(newEmployee.getDob()));
        stmt.setString(5, newEmployee.getRole());
        stmt.setString(6, newEmployee.getSalary());
        return stmt.executeUpdate();
    }

    public List<Employee> getAllEmployees() throws SQLException{
        String query = "select * from employee";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Employee> employees = new ArrayList();
        while (rs.next()){
            Employee employee = new Employee();
            employee.setName(rs.getString("name"));
            employee.setAddress(rs.getString("address"));
            employee.setDob(rs.getDate("dob").toLocalDate());
            employee.setRole(rs.getString("role"));
            employee.setSalary(rs.getString("salary"));
            employee.setPhone_no(rs.getString("phone_no"));
            employee.setEID(rs.getInt("EID"));
            employees.add(employee);
        }
        return employees;
    }

    public List<String> getAllEmployeesNames() throws SQLException{
        String query = "select * from employee";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<String> employeesNames = new ArrayList();
        while (rs.next()){
            employeesNames.add(rs.getString("name"));
        }
        return employeesNames;
    }

    public int getEmployeeId(String EName) throws SQLException{
        String query = "select EID from employee where name = ? ";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, EName);
        ResultSet rs = stmt.executeQuery();
        List<String> employeesID = new ArrayList();
        while (rs.next()){
            employeesID.add(rs.getString("EID"));
        }

        return Integer.parseInt(employeesID.get(0));
    }

    public Employee getEmployee(int id) throws SQLException {
        String query = "select * from employee where EID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        //after getting the data , creates a new object from member class
        ResultSet rs = stmt.executeQuery();
        Employee employee = null;
        //boolean check = false;
        while (rs.next()) {
            //check = true;
            employee = new Employee();
            employee.setEID(rs.getInt("EID"));
            employee.setName(rs.getString("name"));
            employee.setAddress(rs.getString("address"));
            employee.setPhone_no(rs.getString("phone_no"));
            employee.setDob(rs.getDate("dob").toLocalDate());
            employee.setRole(rs.getString("role"));
            employee.setSalary(rs.getString("salary"));
        }
        return employee;
    }

    public int update(Employee employee) throws SQLException {
        //TODO
        String query = "UPDATE employee\n" +
                "SET name = ?,address = ?, phone_no= ?,dob = ?, role = ? ,salary = ? \n" +
                "WHERE EID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, employee.getName());
        stmt.setString(2, employee.getAddress());
        stmt.setString(3, employee.getPhone_no());
        stmt.setDate(4, Date.valueOf(employee.getDob()));
        stmt.setString(5, employee.getRole());
        stmt.setString(6, employee.getSalary());
        stmt.setString(7, Integer.toString(employee.getEID()));
        return stmt.executeUpdate();

    }
    public void delete(int id) throws SQLException {
        String query = "delete from employee where EID =?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }
}
