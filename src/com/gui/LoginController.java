package com.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import  javafx.scene.control.Button;


public class LoginController implements IControlledScreen{
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private BorderPane root;
    @FXML
    private BorderPane root2;
    @FXML
    private Button logout;

    ScreensController mycontroller;


    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }
    @FXML
    private void gotoMainScreen(javafx.event.ActionEvent actionEvent) {
        if (username.getText().equals("sallam") && password.getText().equals("12345")){
//
            mycontroller.setScreen(Main.mainScreenName);
            System.out.println("Welcome!");
            username.setText("");
            password.setText("");
        }
    }


}
