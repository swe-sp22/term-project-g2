package com.gui.login;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import  javafx.scene.control.Button;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController{
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private void handleLoginButton(javafx.event.ActionEvent actionEvent) {
        if (username.getText().equals("sallam") && password.getText().equals("12345")){
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            try {
                loadWindow("mainScreen.fxml","Gym System");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Welcome!");
            username.setText("");
            password.setText("");
        }
    }

    private void loadWindow(String location, String title)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(location));
        Scene scene = new Scene(root, 1129, 750);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }


}
