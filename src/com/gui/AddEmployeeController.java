package com.gui;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

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

    public void addEmployeeToDb(ActionEvent actionEvent) throws SQLException {
        System.out.println("added");
        //TODO: Add logic
        Employee newEmployee = new Employee(name.getText(), address.getText(), phone_no.getText(), dob.getValue(), role.getText(), salary.getText());
        EmployeeDao employeeDao = new EmployeeDao();
        int value = employeeDao.addEmployee(newEmployee);
        mycontroller.unloadScreen(Main.showEmployeeScreenName);
        mycontroller.loadScreen(Main.showEmployeeScreenName, Main.showEmployeeScreenFile);
        System.out.println(value);
        mycontroller.unloadScreen(Main.showEmployeeScreenName);
        mycontroller.loadScreen(Main.showEmployeeScreenName,Main.showEmployeeScreenFile);
    }
    public void gotoMainScreen(ActionEvent actionEvent) {
        mycontroller.setScreen(Main.mainScreenName);
    }
}
