package com.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddEmployeeController implements IControlledScreen {
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField phone_no;
    @FXML
    private TextField role;
    @FXML
    private TextField salary;
    @FXML
    private DatePicker dob;


    ScreensController mycontroller;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    }

    public void addEmployeeToDb(ActionEvent actionEvent){
        System.out.println("added");
        //TODO: Add logic
        

    }
    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }
}
