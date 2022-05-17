package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Member;
import com.jdbc.util.DatabaseConnection;
//import com.jdbc.util.DatabaseConnection;

public class MemberDaoImplementation implements MemberDao {

    static Connection con = DatabaseConnection.getConnection();


    @Override
    public int add(Member member) throws SQLException {
        String query = "insert into member(member_name, " + "member_address) VALUES (?, ?)";
        //The performance of the application will be faster if we use PreparedStatement interface because query is compiled only once.
        PreparedStatement stmt = con.prepareStatement(query);
        //stmt.setString(1, member.getMember_name());
        //stmt.setString(2, member.getMember_address());
        int i = stmt.executeUpdate();  //i indicates number of changes made
        return i;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from member where member_id =?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }

    @Override
    public Member getMember(int id) throws SQLException {
        String query = "select * from member where member_id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        //Member member = new Member();  //after getting the data , creates a new object from member class
        ResultSet rs = stmt.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            //member.setMember_id(rs.getInt("member_id"));
            //member.setMember_name(rs.getString("member_name"));
            //member.setMember_address(rs.getString("member_address"));
        }
        if(check==true){
          //  return member;
        }
        else{
            return null;
        }
        return null;
    }

    @Override
    public List<Member> getMembers() throws SQLException {
        String query = "select * from member";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Member> ls = new ArrayList();
        while(rs.next()){
           // Member member = new Member();
            //member.setMember_id(rs.getInt("member_id"));
            //member.setMember_name(rs.getString("member_name"));
            //member.setMember_address(rs.getString("member_address"));
           // ls.add(member);
        }
        return ls;
    }

    @Override
    public void update(Member member) throws SQLException {
        String query = "update member set member_name=?, " + " member_address= ? where member_id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        //stmt.setString(1, member.getMember_name());
        //stmt.setString(2, member.getMember_address());
        //stmt.setInt(3, member.getMember_id());
        //stmt.executeUpdate();
    }
}
