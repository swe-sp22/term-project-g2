package com.jdbc.dao;

import com.jdbc.model.Employee;
import com.jdbc.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
    static Connection con = DatabaseConnection.getConnection();
    public int addEmployee(Employee newEmployee) throws SQLException{
        /*
        * String query = "insert into member(member_name, " + "member_address) VALUES (?, ?)";
        //The performance of the application will be faster if we use PreparedStatement interface because query is compiled only once.
        PreparedStatement stmt = con.prepareStatement(query);
        //stmt.setString(1, member.getMember_name());
        //stmt.setString(2, member.getMember_address());
        int i = stmt.executeUpdate();  //i indicates number of changes made
        return i;*/
        String query = "insert into employee(name, address, phone_no, dob, role, salary) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, newEmployee.getName());
        stmt.setString(2, newEmployee.getAddress());
        stmt.setInt(3, newEmployee.getPhone_no());
        stmt.setDate(4, Date.valueOf(newEmployee.getDob()));
        stmt.setString(5, newEmployee.getRole());
        stmt.setFloat(6, newEmployee.getSalary());

        return stmt.executeUpdate();
    }
}
