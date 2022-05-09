import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.ClientDaoImplementation;
import com.jdbc.model.Client;

public class Main {
    public static void main(String[] args) throws SQLException{

        Client client = new Client();
        client.setClient_name("Mohamed Sallam");
        client.setClient_address("45 Street");
        ClientDaoImplementation clientDaoImplementation = new ClientDaoImplementation();
        //adding new client
//        clientDaoImplementation.add(client);

        //read all clients
        List<Client> ls = clientDaoImplementation.getClients();
        for (Client allclient:ls){
            System.out.println(allclient.getClient_id()+" "+allclient.getClient_name()+" "+allclient.getClient_address());
        }
//        clientDaoImplementation.delete(3);
    }
}
