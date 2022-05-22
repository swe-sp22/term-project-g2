package com.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Employee;
import com.jdbc.model.Member;
import com.jdbc.util.DatabaseConnection;
//import com.jdbc.util.DatabaseConnection;

public class MemberDaoImplementation {

    static Connection con = DatabaseConnection.getConnection();

    public int add(Member member) throws SQLException {
            String query = "insert into member(name,phone_no, dob,MSID , EID) values (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, member.getName());
            stmt.setString(2, member.getPhone_no());
            stmt.setDate(3, Date.valueOf(member.getDob()));
            stmt.setString(4, Integer.toString(member.getMSID()));
            stmt.setString(5, Integer.toString(member.getEID()));
            return stmt.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = "delete from member where MID =?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }

    public Member getMember(int id) throws SQLException {
        String query = "select * from member join `membership type` where MID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
         //after getting the data , creates a new object from member class
        ResultSet rs = stmt.executeQuery();
        Member member = null;
        //boolean check = false;
        while (rs.next()) {
            //check = true;
            member = new Member();
            member.setMID(rs.getInt("MID"));
            member.setName(rs.getString("name"));
            member.setPhone_no(rs.getString("phone_no"));
            member.setDob(rs.getDate("dob").toLocalDate());
            member.setMSID(rs.getInt("MSID"));
            member.setEID(rs.getInt("EID"));
        }
        return member;
    }

    public List<Member> getMembers() throws SQLException {
        String query = "select * from member";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Member> members = new ArrayList();
        while (rs.next()){
            Member member = new Member();
            member.setMID(rs.getInt("MID"));
            member.setName(rs.getString("name"));
            member.setPhone_no(rs.getString("phone_no"));
            member.setDob(rs.getDate("dob").toLocalDate());
            member.setMSID(rs.getInt("MSID"));
            member.setEID(rs.getInt("EID"));

            members.add(member);
        }
        return members;
    }

    public int update(Member member) throws SQLException {
        //TODO
        String query = "UPDATE member\n" +
                "SET name = ?, phone_no= ?,dob = ?, MSID = ? ,EID = ? \n" +
                "WHERE MID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, member.getName());
        stmt.setString(2, member.getPhone_no());
        stmt.setDate(3, Date.valueOf(member.getDob()));
        stmt.setString(4, Integer.toString(member.getMSID()));
        stmt.setString(5, Integer.toString(member.getEID()));
        stmt.setString(6, Integer.toString(member.getMID()));
        return stmt.executeUpdate();

    }
}
