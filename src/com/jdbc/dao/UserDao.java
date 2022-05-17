package com.jdbc.dao;

import com.jdbc.model.*;
import com.jdbc.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    static Connection con = DatabaseConnection.getConnection();
    public boolean getUser(String username, String password) throws SQLException {
        String query = "select * from member where member_id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        Member member = new Member();  //after getting the data , creates a new object from member class
        ResultSet rs = stmt.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            //member.setMember_id(rs.getInt("member_id"));
            //member.setMember_name(rs.getString("member_name"));
            //member.setMember_address(rs.getString("member_address"));
        }
        if(check==true){
            return member;
        }
        else{
            return null;
        }
    }
}
