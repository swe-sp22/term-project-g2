package com.jdbc.dao;

import com.jdbc.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembershipTypeDao {
    static Connection con = DatabaseConnection.getConnection();

    public List<String> getAllMembershipTypes() throws SQLException {
        String query = "select * from `membership type`";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<String> types = new ArrayList();
        while (rs.next()){
            types.add(rs.getString("duration"));
        }
        return types;
    }

    public int getMembershipTypeId(String dur) throws SQLException{
        String query = "select MSID from `membership type` where duration = ? ";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, dur);
        ResultSet rs = stmt.executeQuery();
        List<String> memTyID = new ArrayList();
        while (rs.next()){
            memTyID.add(rs.getString("MSID"));
        }

        return Integer.parseInt(memTyID.get(0));
    }

}
