package com.jdbc.model;

public class Client {

    int client_id;
    String client_name;
    String client_address;


    public Client() {}
    public Client(String emp_name, String emp_address)
    {
        this.client_name = emp_name;
        this.client_address = emp_address;
    }
    public int getClient_id()
    {
        return client_id;
    }
    public void setClient_id(int client_id)
    {
        this.client_id = client_id;
    }
    public String getClient_name()
    {
        return client_name;
    }
    public void setClient_name(String client_name)
    {
        this.client_name = client_name;
    }
    public String getClient_address()
    {
        return client_address;
    }

    public void setClient_address(String client_address)
    {
        this.client_address = client_address;
    }

}
