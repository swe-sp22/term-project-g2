package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Client;
import com.jdbc.util.DatabaseConnection;

public class ClientDaoImplementation implements ClientDao {

    static Connection con = DatabaseConnection.getConnection();


    @Override
    public int add(Client client) throws SQLException {
        String query = "insert into client(client_name, " + "client_address) VALUES (?, ?)";
        //The performance of the application will be faster if we use PreparedStatement interface because query is compiled only once.
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, client.getClient_name());
        stmt.setString(2, client.getClient_address());
        int i = stmt.executeUpdate();  //i indicates number of changes made
        return i;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete from employee where emp_id =?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        stmt.executeUpdate();
    }

    @Override
    public Client getClient(int id) throws SQLException {
        String query = "select * from client where client_id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,id);
        Client client = new Client();  //after getting the data , creates a new object from client class
        ResultSet rs = stmt.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            client.setClient_id(rs.getInt("client_id"));
            client.setClient_name(rs.getString("client_name"));
            client.setClient_address(rs.getString("client_address"));
        }
        if(check==true){
            return client;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Client> getClients() throws SQLException {
        String query = "select * from client";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Client> ls = new ArrayList();
        while(rs.next()){
            Client client = new Client();
            client.setClient_id(rs.getInt("client_id"));
            client.setClient_name(rs.getString("client_name"));
            client.setClient_address(rs.getString("client_address"));
            ls.add(client);
        }
        return ls;
    }

    @Override
    public void update(Client client) throws SQLException {
        String query = "update client set client_name=?, " + " client_address= ? where client_id = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, client.getClient_name());
        stmt.setString(2, client.getClient_address());
        stmt.setInt(3, client.getClient_id());
        stmt.executeUpdate();
    }
}
