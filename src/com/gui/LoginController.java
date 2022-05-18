package com.gui;

import com.jdbc.dao.UserDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import  javafx.scene.control.Button;

import java.sql.SQLException;


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
    private void gotoMainScreen(javafx.event.ActionEvent actionEvent) throws SQLException {
        UserDao userDao = new UserDao();
        String insertedUsername = username.getText();
        String insertedPassword = password.getText();
        if (userDao.checkCredentials(insertedUsername, insertedPassword)){
            mycontroller.setScreen(Main.mainScreenName);
            System.out.println("Welcome!");
            username.setText("");
            password.setText("");
        }
    }


}
