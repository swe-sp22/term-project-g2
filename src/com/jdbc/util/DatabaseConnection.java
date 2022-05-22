package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    static //Is used to initialize the static data member.
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
