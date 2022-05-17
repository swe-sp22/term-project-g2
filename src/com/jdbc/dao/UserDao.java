package com.jdbc.dao;

import com.jdbc.model.*;
import com.jdbc.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    static Connection con = DatabaseConnection.getConnection();
    public static boolean checkCredentials(String username, String password) throws SQLException {
        String query = "select * from user where username = ? and password = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        User currentUser = new User();
        ResultSet rs = stmt.executeQuery();
        boolean found = false;
        if (rs.next()) {
            found = true;
            currentUser.setUsername(rs.getString("username"));
            currentUser.setPassword(rs.getString("password"));
        }
        return found;
    }
}
