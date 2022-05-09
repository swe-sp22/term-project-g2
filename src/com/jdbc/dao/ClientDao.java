package com.jdbc.dao;
import java.sql.SQLException;
import java.util.List;

import com.jdbc.model.Client;

public interface ClientDao {
    public int add(Client client)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public Client getClient(int id)
            throws SQLException;
    public List<Client> getClients()
            throws SQLException;
    public void update(Client client)
            throws SQLException;
}
