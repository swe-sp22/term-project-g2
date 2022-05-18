package com.gui;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShowEmployeeController implements IControlledScreen{

    @FXML
    private TableColumn<?, ?> EID;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> dob;

    @FXML
    private TableView<?> employees;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> role;

    @FXML
    private TableColumn<?, ?> salary;

    ScreensController mycontroller;

    public void setScreenParent(ScreensController screenParent){
        mycontroller = screenParent;
    };
    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }

    public void display(){
        EmployeeDao employeeDao = new EmployeeDao();
        
    }

}
