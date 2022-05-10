package com.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("login/login.fxml"));
        Scene scene = new Scene(root, 1129, 750);
        String css = this.getClass().getResource("login/login.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setTitle("Gym Management System");
        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
        primaryStage.show();

    }

    public static void main(String[] args) { launch(args);}

//        Client client = new Client();
//        client.setClient_name("Mohamed Sallam");
//        client.setClient_address("45 Street");
//        ClientDaoImplementation clientDaoImplementation = new ClientDaoImplementation();
//        //adding new client
////        clientDaoImplementation.add(client);
//
//        //read all clients
//        List<Client> ls = clientDaoImplementation.getClients();
//        for (Client allclient:ls){
//            System.out.println(allclient.getClient_id()+" "+allclient.getClient_name()+" "+allclient.getClient_address());
//        }
//        clientDaoImplementation.delete(3);

}